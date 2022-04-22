package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import ozoneService.Service1_Client;
import ozoneService.Service1_server;
import ozoneService.ozoneServiceGrpc;
import ozoneService.ozoneServiceGrpc.ozoneServiceBlockingStub;
import ozoneService.requestLocalArea;

import ozoneService.responseByArea;
import pm_Service.DensityRequest;
import pm_Service.DensityResponse;
import pm_Service.pm_ServiceGrpc;
import pm_Service.pm_ServiceGrpc.pm_ServiceBlockingStub;
import pm_Service.Responsepms;
import pm_Service.Service2_server;
import pm_Service.Requestpms;

import waterService.SampleRequest;
import waterService.SampleResponse;
import waterService.Service3_server;
import waterService.waterServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import jmDNS.SimpleServiceDiscovery;

import jmDNS.SimpleServiceRegistration;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

import javax.swing.event.ChangeEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ServiceGUI implements ActionListener{
	
	private static int ozonePort = 50051;
	private static int pmPort = 50052;
	private static int waterPort = 50053;
	
	public JLabel pmsDataId;
	public JLabel pmsDataStatus;
	public JLabel pmsDataIntensity;
	
	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	private JTextField entry3, reply3;
	
	private JPanel getService1JPanel() {
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		
		// create an instance of a label
		JLabel label = new JLabel("Request a country name");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("Korea", 10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1.setEditable(false);
		panel.add(reply1);
		panel.setLayout(boxlayout);
		
		return panel;
	}
	
	private JPanel getService2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		JLabel label = new JLabel("Request PM(particular matter) level");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("4", 10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 2");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 10);
		reply2.setEditable(false);
		panel.add(reply2);
		panel.setLayout(boxlayout);
		return panel;

	}
	
	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		JLabel label = new JLabel("Request water sample id/name");
		panel.add(label);

		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3 = new JTextField("A1", 10);
		panel.add(entry3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 3");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 10);
		reply3.setEditable(false);
		panel.add(reply3);
		panel.setLayout(boxlayout);
		return panel;
	}
	
	private JPanel closeJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);

		JButton button = new JButton("Exit");
		button.addActionListener(this);
		panel.add(button);

		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

		panel.setLayout(boxlayout);
		return panel;
	}
	
// ---------------------------------------------------------------------------------------------- //


	public static void main(String[] args) throws InterruptedException, IOException {

		ServiceGUI gui = new ServiceGUI();
		gui.build();
		
	}
	private void build() {

		// create an instance of frame
		JFrame frame = new JFrame("Pollution Monitoring");

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(100, 100, 100, 100)));

		panel.add(getService1JPanel());
		panel.add(getService2JPanel());
		panel.add(getService3JPanel());
		panel.add(closeJPanel());

		// Set size for the frame
		frame.setSize(420, 420);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();

		// make frame visible
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		JButton button = (JButton) e.getSource();
		String label = button.getActionCommand();
		
		if (label.equals("Invoke Service 1")) {	
			
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress("localhost", ozonePort)
					.usePlaintext()
					.build();
			
			System.out.println(" ===================================================="
					+ "\n Ozone service to be invoked ...");
			
			ozoneServiceGrpc.ozoneServiceBlockingStub stub = ozoneServiceGrpc
					.newBlockingStub(channel);
			
			requestLocalArea request = requestLocalArea
					.newBuilder()
					.setCountry("Korea")
					.build();

			Iterator<responseByArea> responseIterator;

			try {
				responseIterator = stub.ozoneTrack(request);
				reply1.setText("Ozone information of cities in : " + request.getCountry());
				// only last response is returned in gui
				for (int i = 1; responseIterator.hasNext(); i++) {
					responseByArea result = responseIterator.next();
					System.out.println("RESPONSE # " + i + ": " + result);
				}
			} catch (StatusRuntimeException e1) {
				// logInfo("RPC failed: {0}", e.getStatus());
				System.out.println("RPC failed: {0} " + e1.getStatus());
			}
			
			System.out.println("Ozone Service complete! "
					+ "\n ===============================================");

		} else if (label.equals("Invoke Service 2")){

			System.out.println(" ===================================================="
					+ "\n PM service to be invoked ...");
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", pmPort)
                    .usePlaintext()
                    .build();
			pm_ServiceGrpc.pm_ServiceStub pmStub = pm_ServiceGrpc.newStub(channel);
				
			StreamObserver<DensityResponse> responseObserver = new StreamObserver<DensityResponse>() {

				@Override
				public void onNext(DensityResponse dense) {				
					reply2.setText("\n The density of PM in air is " + dense.getDensity());
					System.out.println("Purifier sensor has been aware of PM level " + dense.getDensity());
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

			responseObserver.onNext(DensityResponse.newBuilder()
					.setDensity(4).build());
			responseObserver.onCompleted();
			
			StreamObserver<DensityRequest> requestObserver = pmStub
					.withDeadlineAfter(2, TimeUnit.SECONDS)
					.pmDensity(new StreamObserver<DensityResponse>() {
				@Override
				public void onNext(DensityResponse value) {
					System.out.println("PMs density changed to Level 1.");
				}
				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}
				@Override
				public void onCompleted() {
					System.out.println("Success!"
							+ "\n ===============================================");
				}
			});		
			
			requestObserver.onNext(DensityRequest.newBuilder()
			.setDensity(4).build());
			requestObserver.onCompleted();
				
		} else if (label.equals("Invoke Service 3")) {
						
			System.out.println(" ===================================================="
					+ "\n Water service to be invoked ...");
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", waterPort)
                    .usePlaintext()
                    .build();
			
			waterServiceGrpc.waterServiceStub wStub = waterServiceGrpc.newStub(channel);

			StreamObserver<SampleRequest> request = wStub.createSample(new StreamObserver<SampleResponse>() {
				
				@Override
				public void onNext(SampleResponse value) {
					reply3.setText("Water Sample is " + value.getWaterSample());
					String result = value.getWaterSample();
					System.out.println(result + " is drinkable.");

					
					// response
//					SampleResponse sampleResponse = SampleResponse.newBuilder().setWaterSample(result).build();			
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					System.out.println("Server has completed sending data"
							+ "\n ===============================================");
					
				}
			});

			request.onNext(SampleRequest.newBuilder()
					.setId("A1")
					.setName("Edible")
					.setLocation("Dublin")
					.build());

			
			request.onCompleted();
		}

	}
}
	

				


