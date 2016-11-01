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
 * informatin yet. The start button disposes of the launch window and opens the play window.
 */

public class LaunchWindow {

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
		JLabel lblPlayer = new JLabel("Number of Players");
		JLabel Title = new JLabel("Settlers of Java!");
		JRadioButton Three = new JRadioButton("3");
		Three.setSelected(true);
		JRadioButton Four = new JRadioButton("4");
		JRadioButton Five = new JRadioButton("5");
		JRadioButton Six = new JRadioButton("6");
		
		ButtonGroup NumPlay = new ButtonGroup();
		NumPlay.add(Three);
		NumPlay.add(Four);
		NumPlay.add(Five);
		NumPlay.add(Six);
		
		
		Status.add(btnStart);
		Status.add(lblPlayer);
		Status.add(Three);
		Status.add(Four);
		Status.add(Five);
		Status.add(Six);
		Status.add(Title);
		
		Title.setBounds(175,0,100,25);
		btnStart.setBounds(175,200,100,25);
		lblPlayer.setBounds(25,20,125,25);
		Three.setBounds(30,40,40,25);
		Four.setBounds(70,40,40,25);
		Five.setBounds(110,40,40,25);
		Six.setBounds(150,40,40,25);
		
	}

}
