package waterService;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import jmDNS.SimpleServiceRegistration;
import jmDNS.SimpleServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import waterService.waterServiceGrpc;
import waterService.waterServiceGrpc.waterServiceBlockingStub;
import waterService.waterServiceGrpc.waterServiceStub;


public class Service3_client {
	
	public static void main(String[] args) throws InterruptedException {
		
		// jmdns
		ServiceInfo serviceInfo;
		String service_type = "_water._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);

		int port = 50053;
		String host = "localhost";
		
		// build a channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		doBiDiStreamingCall(channel);

		System.out.println("Shutting down channel");
		channel.shutdown();

	}
	
	private static void doBiDiStreamingCall(ManagedChannel channel) {
		// create an asynchronous client
		waterServiceGrpc.waterServiceStub asyncClient = waterServiceGrpc.newStub(channel);

		// Latch to make thread wait for ready
		CountDownLatch latch = new CountDownLatch(1);

		// response part
		StreamObserver<SampleRequest> requestObserver = asyncClient.createSample(new StreamObserver<SampleResponse>() {

			@Override
			public void onNext(SampleResponse value) {
				System.out.println("Response from server: " + value.getWaterSample());
			}

			@Override
			public void onError(Throwable t) {
				// to make sure latch disappears
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				System.out.println("Server is done sending data");
				latch.countDown();
			}
		});

		// generate a few requests.
		// send 5 messages to the server and we can expect 5 messages back.
		// can use onNext calls as many as times I want.

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter water sample to retrieve: ");
	
		String sampleId = "";
		boolean valid = false;
		List<String> sampleList = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			do {
				System.out.println("Enter water sample: ");
				if (sc.hasNext("[a-zA-Z0-9]+")) {
					sampleId = sc.nextLine();
					valid = true;
				} else {
					sc.nextLine();
					System.out.println("Please enter a valid water sample.");
				}

			} while (!valid);
			sampleList.add(sampleId);
		}
		
		// request part
		// print out requests(inputs)using lambda
		sampleList.forEach(id -> {
			System.out.println("Sending: " + id);
			requestObserver.onNext(SampleRequest.newBuilder().setId(id).build());
		});

		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		// done sending request
		requestObserver.onCompleted();

		// wait 3 sec
		try {
			latch.await(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	

}
