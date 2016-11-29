package gui;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;

/**
 * @file LaunchWindow.java
 * @author Stuart Wreath
 * @since 2016.11.8
 * @details This class generates the GUI for the window that allows the player who is going to host the game
 * to choose what the settings are for the game, such as number of players and other details that will be decided
 * later.
 */

public class HostWindow {

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
	public HostWindow() {
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
		frame = new JFrame("Create and Host a Game");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Status = new JPanel();
		Status.setBounds(0, 0, 150, 561);
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
		//btnKick1 wouldnt be used, temporarily commented
		/*
		JButton btnKick1 = new JButton("Kick");
		btnKick1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {}
						catch (Exception e){ e.printStackTrace(); }
					}
				});
			}
		});*/
		JButton btnKick2 = new JButton("Kick");
		btnKick2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {}
						catch (Exception e){ e.printStackTrace(); }
					}
				});
			}
		});
		JButton btnKick3 = new JButton("Kick");
		btnKick3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {}
						catch (Exception e){ e.printStackTrace(); }
					}
				});
			}
		});
		JButton btnKick4 = new JButton("Kick");
		btnKick4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {}
						catch (Exception e){ e.printStackTrace(); }
					}
				});
			}
		});
		
		JLabel Title = new JLabel("Settlers of Java!");
		JLabel lblName = new JLabel("username");
		JTextField Player1 = new JTextField("Host: " + LaunchWindow.username);
		JTextField Player2 = new JTextField("Player 2: ");
		JTextField Player3 = new JTextField("Player 3: ");
		JTextField Player4 = new JTextField("Player 4: ");
		
		Title.setBounds(125,0,200,25);
		btnStart.setBounds(175,200,100,25);
		//btnKick1.setBounds(315,50,60,25);
		btnKick2.setBounds(315,75,60,25);
		btnKick3.setBounds(315,100,60,25);
		btnKick4.setBounds(315,125,60,25);
		Player1.setBounds(75,50,240,25);
		Player1.setEditable(false);
		Player2.setBounds(75,75,240,25);
		Player2.setEditable(false);
		Player3.setBounds(75,100,240,25);
		Player3.setEditable(false);
		Player4.setBounds(75,125,240,25);
		Player4.setEditable(false);
		
		lblName.setBounds(0,20,450,25);
		
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setVerticalAlignment(SwingConstants.TOP);
		lblName.setText("Username: " + LaunchWindow.username);
		
		Title.setFont (Title.getFont ().deriveFont (20.0f));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setVerticalAlignment(SwingConstants.TOP);
		
		Status.add(btnStart);
		Status.add(Title);
		Status.add(lblName);
		//Status.add(btnKick1);
		Status.add(btnKick2);
		Status.add(btnKick3);
		Status.add(btnKick4);
		Status.add(Player1);
		Status.add(Player2);
		Status.add(Player3);
		Status.add(Player4);
	}
}
