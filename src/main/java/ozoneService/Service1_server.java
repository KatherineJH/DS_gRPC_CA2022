package ozoneService;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import jmDNS.SimpleServiceRegistration;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;
import ozoneService.ozoneServiceGrpc.ozoneServiceBlockingStub;
import ozoneService.ozoneServiceGrpc.ozoneServiceImplBase;
import waterService.Service3_server;


public class Service1_server extends ozoneServiceImplBase{
	
    public static void main(String[] args) throws IOException, InterruptedException {
		// Server instance is created on port 50051. This is the port we want the server 
		// to bind to and where it will listen to incoming messages.
    	// get a reference to the server
    	Service1_server service1 = new Service1_server();	
    	System.out.println("Starting gRPC ozone service server.");
    	
    	//Define the port
		int port = 50051;
		
		// jmDNS
		String service_type = "_ozone._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		try {
			// get a reference to the server		
			Server server = ServerBuilder.forPort(port)
					.addService(service1)
					.build()
					.start();
			System.out.println("Server started, listening on " + port);
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println(e);
		}		
	}

  @Override
  public void ozoneTrack(requestLocalArea request, StreamObserver<responseByArea> responseObserver) {

	  LinkedList<responseByArea> korea = new LinkedList<responseByArea>();
	  
	  korea.add(responseByArea.newBuilder()
			  .setCity("Seoul")
			  .setIndex(4)
              .setBand("Bad")
              .setAdvice("Recommend to enjoy indoor activities!")
              .build());
	  
	  korea.add(responseByArea.newBuilder()
			  .setCity("Busan")
			  .setIndex(3)
              .setBand("Not bad")
              .setAdvice("You must put some sun screen outside.")
              .build());
	  
	  korea.add(responseByArea.newBuilder()
			  .setCity("Jeju")
			  .setIndex(2)
              .setBand("Good")
              .setAdvice("Put some sun screen and enjoy sunshine.")
              .build());

	  
      for (int i = 0; i < 3; i++) {
    	  responseByArea stockQuote = responseByArea.newBuilder()
    			  .setCity(korea.get(i).getCity())
    			  .setIndex(korea.get(i).getIndex())
                  .setBand(korea.get(i).getBand())
                  .setAdvice(korea.get(i).getAdvice())
                  .build();

          responseObserver.onNext(stockQuote);
      }
      responseObserver.onCompleted();
  }
  

}



