package ozoneService;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.jmdns.ServiceInfo;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import jmDNS.SimpleServiceDiscovery;
import jmDNS.SimpleServiceRegistration;
import ozoneService.ozoneServiceGrpc.ozoneServiceBlockingStub;


public class Service1_Client {
    private static ozoneServiceGrpc.ozoneServiceBlockingStub bStub;    

	public static void main(String[] args) throws InterruptedException {

		// jmdns
		ServiceInfo serviceInfo;
		String service_type = "_ozone._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		
		// port & host
		int port = 50051;
		String host = "localhost";
				
    	// build a channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host , port)
				.usePlaintext()
				.build();
		
		// stub
		bStub = ozoneServiceGrpc.newBlockingStub(channel);

		method_1();
		
		System.out.println("Shutting down channel");
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

	}
    
    // method_1
    public static void method_1() {
    	// GUI
		JFrame f;
		f = new JFrame();
		
		// method 1.				
		int a = JOptionPane.showConfirmDialog(f,
				"Welcome to Ozone Service\n\nDo you want to send request to Ozone Server");
		if (a != JOptionPane.YES_OPTION) {
			return;
		}
		
		requestLocalArea request = requestLocalArea.newBuilder().setCountry("Korea").build();
		Iterator<responseByArea> response;

		try {
			response = bStub.ozoneTrack(request);
			for(int i = 1; response.hasNext(); i++) {
				responseByArea result = response.next();
				JOptionPane.showMessageDialog(f, "RESPONSE # " + i + " : " + result);
				System.out.println("RESPONSE # " + i + " : " + result);
			}			
		} catch (StatusRuntimeException e) {
			// logInfo("RPC failed: {0}", e.getStatus());
			System.out.println("RPC failed: {0} " + e.getStatus());
			return;
		}
				
    }
    
}

