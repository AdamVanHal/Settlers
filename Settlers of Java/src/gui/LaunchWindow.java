package gui;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;

/**
 * @file LaunchWindow.java
 * @author Adam Van Hal and Stuart Wreath
 * @since 2016.11.1
 * @details This class generates the GUI responsible for displaying the Launch Window for the game. The player
 * has the ability to choose the amount of players for the game, but this program does not do anything with the
 * information yet. The start button disposes of the launch window and opens the play window.
 */

public class LaunchWindow {

	public JFrame frame;
	public static String username;

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
	public LaunchWindow() {
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
		frame = new JFrame("Settlers of Java");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Status = new JPanel();
		Status.setBounds(0, 0, 150, 561);
		frame.getContentPane().add(Status);
		Status.setLayout(null);
		
		
		
		JTextField usernameField = new JTextField();
		JLabel lblPlayer = new JLabel("Enter a username");
		JLabel Title = new JLabel("Settlers of Java!");
		
		JButton btnHost = new JButton("Host");
		btnHost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							username = usernameField.getText();
							frame.dispose();
							HostWindow window = new HostWindow();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							username = usernameField.getText();
							frame.dispose();
							JoinWindow window = new JoinWindow();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		Status.add(btnHost);
		Status.add(btnJoin);
		Status.add(lblPlayer);
		Status.add(Title);
		Status.add(usernameField);
		
		Title.setBounds(175,0,100,25);
		btnHost.setBounds(75,200,100,25);
		btnJoin.setBounds(275,200,100,25);
		lblPlayer.setBounds(150,50,125,25);
		usernameField.setBounds(150, 75, 150, 25);
	}

}
