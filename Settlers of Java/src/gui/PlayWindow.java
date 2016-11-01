package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import GameBoard.BoardGraphics;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayWindow {

	private JFrame frame;

	/*
	 * @pre    None
	 * @post   Launches the play window, primarily used in standalone testing. 
	 * @return None
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

	/*
	 * @pre    None
	 * @post   Calls private function to initialize the gui 
	 * @return None
	 */
	public PlayWindow() {
		initialize();
	}

	/*
	 * @pre    None
	 * @post   Initializes all GUI components and their listeners, including the board element 
	 * @return None
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 871, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//add the main game area to the center
		BoardGraphics Island = new BoardGraphics();
		Island.setBounds(160, 0, 685, 644);
		frame.getContentPane().add(Island);
		
		JPanel Status = new JPanel();
		Status.setBounds(0, 0, 150, 561);
		frame.getContentPane().add(Status);
		Status.setLayout(null);
		
		//Generic button that currently does nothing
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
		});
		btnEndTurn.setBounds(61, 88, 89, 23);
		Status.add(btnEndTurn);
	}
}
