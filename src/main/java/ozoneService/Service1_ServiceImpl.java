package ozoneService;

import java.util.LinkedList;
import java.util.List;

import io.grpc.stub.StreamObserver;

public class Service1_ServiceImpl extends ozoneServiceGrpc.ozoneServiceImplBase {
	  
  @Override
  public void ozoneTrack(requestLocalArea request, StreamObserver<responseByArea> responseObserver) {

	  LinkedList<responseByArea> korea = new LinkedList<responseByArea>();
	  
	  korea.add(responseByArea.newBuilder()
			  .setCity("Seoul")
			  .setIndex(5)
              .setBand("Bad")
              .setAdvice("bla bla bla")
              .build());
	  
	  korea.add(responseByArea.newBuilder()
			  .setCity("Busan")
			  .setIndex(4)
              .setBand("Bad")
              .setAdvice("bla bla bla")
              .build());
	  
	  korea.add(responseByArea.newBuilder()
			  .setCity("Jeju")
			  .setIndex(3)
              .setBand("Not Bad")
              .setAdvice("bla bla bla")
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