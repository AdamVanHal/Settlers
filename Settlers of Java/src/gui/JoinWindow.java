package gui;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

import javax.swing.*;

import Utilities.ClientNetwork;

/**
 * @file LaunchWindow.java
 * @author Stuart Wreath
 * @since 2016.11.8
 * @details This class generates the GUI for the window that allows a player to enter the IP Address
 * of the player whose game they want to join, and then join it.
 */

public class JoinWindow {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	 
	 /*
	 * @pre    None
	 * @post   Launches the launch window 
	 * @return None
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchWindow window = new LaunchWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JoinWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	 
	 /*
	 * @pre    None
	 * @post   The elements of the launch window gui are initialized
	 * @return None
	 */
	private void initialize() {
		ClientNetwork Client;
		Client = new ClientNetwork("127.0.0.1",5000);
		frame = new JFrame("Join an Existing Game");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Status = new JPanel();
		Status.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(Status);
		Status.setLayout(null);
		
		JLabel lblError = new JLabel("");
		JLabel lblJoin = new JLabel("Enter the IP Address of the Host");
		JLabel lblPort = new JLabel("Enter the Port of the Host");
		JLabel lblName = new JLabel("username");
		JLabel Title = new JLabel("Settlers of Java!");
		JTextField txtJoin = new JTextField("IP Address");
		JTextField txtPort = new JTextField("Port");
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				int PortNumber = 5000;
				try {
					PortNumber = Integer.parseInt(txtPort.getText());
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				}
				Client.Change(txtJoin.getText(), PortNumber);
				try {
					Client.start();
				} catch (IOException e1) {
					//Network Failure
					e1.printStackTrace();
				}
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frame.dispose();
							PlayWindow window = new PlayWindow();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		Title.setBounds(125,0,200,25);
		btnStart.setBounds(175,180,100,25);
		lblJoin.setBounds(135,75,180,25);
		txtJoin.setBounds(135,100,180,25);
		lblPort.setBounds(135, 125, 180, 25);
		txtPort.setBounds(135, 150, 180, 25);
		lblError.setBounds(0,45,450,25);
		lblName.setBounds(0,45,450,25);
		
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setVerticalAlignment(SwingConstants.TOP);
		lblName.setText("Username: " + LaunchWindow.username);
		
		lblError.setForeground(Color.red);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setVerticalAlignment(SwingConstants.TOP);
		
		Title.setFont (Title.getFont ().deriveFont (20.0f));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setVerticalAlignment(SwingConstants.TOP);
		
		Status.add(lblError);
		Status.add(btnStart);
		Status.add(lblJoin);
		Status.add(lblPort);
		Status.add(Title);
		Status.add(txtJoin);
		Status.add(txtPort);
		Status.add(lblName);
	}
}

