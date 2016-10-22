package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import GameBoard.BoardGraphics;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PlayWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayWindow window = new PlayWindow();
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
	public PlayWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//add the main game area to the center
		BoardGraphics Island = new BoardGraphics();
		Island.setBounds(160, 0, 564, 550);
		frame.getContentPane().add(Island);
		
		JPanel Status = new JPanel();
		Status.setBounds(0, 0, 150, 561);
		frame.getContentPane().add(Status);
		Status.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(61, 88, 89, 23);
		Status.add(btnNewButton);
	}
}
