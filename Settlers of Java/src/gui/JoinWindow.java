package gui;

import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

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
		frame = new JFrame("Join an Existing Game");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Status = new JPanel();
		Status.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(Status);
		Status.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
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
		JLabel lblError = new JLabel("");
		JLabel lblJoin = new JLabel("Enter the IP Address of the Host");
		JLabel lblName = new JLabel("username");
		JLabel Title = new JLabel("Settlers of Java!");
		JTextField txtJoin = new JTextField("IP Address");
		
		Title.setBounds(125,0,200,25);
		btnStart.setBounds(175,180,100,25);
		lblJoin.setBounds(135,78,180,25);
		txtJoin.setBounds(135,100,180,25);
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
		Status.add(Title);
		Status.add(txtJoin);
		Status.add(lblName);
	}
}

