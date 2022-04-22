package pm_Service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JOptionPane;

import jmDNS.SimpleServiceDiscovery;
import jmDNS.SimpleServiceRegistration;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import pm_Service.pm_ServiceGrpc;
import pm_Service.pm_ServiceGrpc.pm_ServiceBlockingStub;
import pm_Service.pm_ServiceGrpc.pm_ServiceStub;

public class Service2_client {
	private static pm_ServiceGrpc.pm_ServiceBlockingStub bStub;
	private static pm_ServiceGrpc.pm_ServiceStub asyncStub;
	
	public static void main(String[] args) throws InterruptedException {
		
		// jmdns
		ServiceInfo serviceInfo;
		String service_type = "_parameter._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		
		// port & host
		int port = 50052;
		String host = "localhost";
		
		// build a channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		// stubs from proto
		bStub = pm_ServiceGrpc.newBlockingStub(channel);
		asyncStub = pm_ServiceGrpc.newStub(channel);
		
		pmQualityTrack();
		pmOnOff();
		pmDensity();
				
		System.out.println("Shutting down channel");
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	// pm
	public static void pmQualityTrack() {
		
		// request
		Empty emp = Empty.newBuilder().build();
		// reponse
		PMatter response;
		
		try {
			//gathering pms information
			response = bStub.pmQualityTrack(emp);
			System.out.println("The app is sensoring: " + response.getPmID());
			System.out.println("PM status: " + response.getStatus());
			System.out.println("Density: " + response.getDensity());				
		}catch(StatusRuntimeException e) {
			System.out.println("Density client failed:"+ e.getStatus());
			return;
		}	
	}
	
	// Purifier
	public static void pmOnOff(){
		Requestpms request = Requestpms.newBuilder().setSwitch(false).build();
		
		//if true, purifier off otherwise, on
		Responsepms response = bStub.pmOnOff(request);
		if (response.getSwitch()) {
			System.out.println("Purifier off!");
		}
		else {
			System.out.println("Purifier on!");
		}
	}
		
	//pmDensity 
	public static void pmDensity(){
		StreamObserver<DensityResponse> responseObserver = new StreamObserver<DensityResponse>() {

			@Override
			public void onNext(DensityResponse dense) {				
				System.out.println("Purifier has been set to level " + (dense.getDensity()-1));
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Purifier adjustment completed");
			}
		};

		StreamObserver<DensityRequest> requestObserver = asyncStub.pmDensity(responseObserver);
		try {
			//simulating several requests from client to change temperature
			// set density 5 -> 4 -> 3-> 2 -> 1 manually.
			requestObserver.onNext(DensityRequest.newBuilder().setDensity(5).build());
			System.out.println("PM in air changed to: 4");
			requestObserver.onNext(DensityRequest.newBuilder().setDensity(4).build());
			System.out.println("PM in air changed to: 3");
			requestObserver.onNext(DensityRequest.newBuilder().setDensity(3).build());
			System.out.println("PM in air changed to: 2");
			requestObserver.onNext(DensityRequest.newBuilder().setDensity(2).build());
			System.out.println("PM in air changed to: 1");			
			
			Thread.sleep(2000);
			// catch any errors
		} catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		requestObserver.onCompleted();
	}		

}
