package pm_Service;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import jmDNS.SimpleServiceRegistration;
import jmDNS.SimpleServiceDiscovery;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import pm_Service.pm_ServiceGrpc.pm_ServiceImplBase;

public class Service2_server extends pm_ServiceImplBase{
	
	Data_pm pmdata = new Data_pm();

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Service2_server service2 = new Service2_server();		
		System.out.println("Starting gRPC PM service server.");		
		
		//Define the port
		int port = 50052;
		
		// jmDNS
		String service_type = "_parameter._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
			
		try {
			// get a reference to the server		
			Server server = ServerBuilder.forPort(port)
					.addService(service2)
					.build()
					.start();
			System.out.println("Server started, listening on " + port);
			server.awaitTermination();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void pmQualityTrack(Empty request, StreamObserver<PMatter> responseObserver) {
		String status;
		
		if(pmdata.isOn()) {
			  status ="On";
		}
		else {
			  status ="Off";
		}
		
		String pmID = pmdata.getTypeId();
		String pmStatus = status;
		Integer pmDensity = pmdata.getDensity();
		
		PMatter response = PMatter.newBuilder()
				.setPmID(pmID).setStatus(pmStatus).setDensity(pmDensity)
				.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();		
	}
	
	// on and off
	@Override
	public void pmOnOff(Requestpms request, StreamObserver<Responsepms> responseObserver) {
		//notification of method invocation
		System.out.println("Receiving request to turn On/Off purifier");
		//if true, devices off otherwise, on
		Boolean OnOff = request.getSwitch();
		if (OnOff) {
        	System.out.println("Setting purifier off!");
        }
        else {
        	System.out.println("Setting purifier on!");
        }
		
		Responsepms response = Responsepms.newBuilder().setSwitch(OnOff).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	// density
	@Override 
	public StreamObserver<DensityRequest> pmDensity(StreamObserver<DensityResponse> responseObserver){
		return new StreamObserver<DensityRequest>() {
			//initializing variable for density change 
			int density = 0;

			public void onNext(DensityRequest value) {
				//variable set to the user input
				density = value.getDensity();
				System.out.println("PMs density changed: " + density);
				
			}

			public void onError(Throwable t) {
				t.printStackTrace();
				
			}
			//response to the variable
			public void onCompleted() {
				DensityResponse response = DensityResponse.newBuilder().setDensity(density).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();				
			}
			
		};
	}

}
