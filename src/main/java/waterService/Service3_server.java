package waterService;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import jmDNS.SimpleServiceRegistration;
import pm_Service.Requestpms;
import pm_Service.Responsepms;
import jmDNS.SimpleServiceDiscovery;

import waterService.SampleRequest;
import waterService.SampleResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import waterService.Service3_server;
import waterService.waterServiceGrpc.waterServiceImplBase;

public class Service3_server extends waterServiceImplBase{

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Starting gRPC water service server.");	
		Service3_server service3 = new Service3_server();
		
		//Define the port
		int port = 50053;
		String service_type = "_water._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		try {
			// get a reference to the server						
			Server server = ServerBuilder.forPort(port)
					.addService(service3)
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
	public StreamObserver<SampleRequest> createSample(StreamObserver<SampleResponse> responseObserver) {	
		   StreamObserver<SampleRequest> requestObserver = new StreamObserver<SampleRequest>() {

			@Override
			// every time sample request is received 
			public void onNext(SampleRequest value) {
				// store water sample input by user in the variable 'result'
				String result = value.getId();
				
				// response
				SampleResponse sampleResponse = SampleResponse.newBuilder().setWaterSample(result).build();
				
				// send message back to response observer
				responseObserver.onNext(sampleResponse);
			}

			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
			}
		};
		return requestObserver;
	}

}
