/*
*	@file PlayWindow.java
*	@author Adam Van Hal
*	@date 10-17-16
*	@Creates a place to draw the game boar and interact with players
*/
package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import GameBoard.BoardGraphics;
import GameBoard.GameBoard;
import Utilities.Dice;
import infoClasses.PlayerInfo;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayWindow {

	public JFrame frame;
	
	//LongestRoad lRoad = new LongestRoad();
	public Dice d6 = new Dice(6);
	public static GameBoard game = new GameBoard();
	public PlayerInfo[] players =  new PlayerInfo[4];
	

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
		frame = new JFrame("Settlers of Java");
		frame.setBounds(100, 100, 875, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//add the main game area to the center
		BoardGraphics Island = new BoardGraphics();
		Island.setBounds(160, 0, 685, 644);
		frame.getContentPane().add(Island);
		
		for(int i = 0; i < 4; i ++){
			players[i] = new PlayerInfo(i+1);
		}
		
		JPanel Status = new JPanel();
		Status.setBounds(0, 0, 150, 600);
		frame.getContentPane().add(Status);
		Status.setLayout(null);
		
		//Generic button that currently does nothing
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				frame.dispose();
			}
		});
		btnEndTurn.setBounds(50, 575, 90, 25);
		Status.add(btnEndTurn);
		JLabel Player = new JLabel("");
		JLabel Resources = new JLabel("Resources");
		JLabel Brick = new JLabel("Brick");
		JLabel Wool = new JLabel("Wool");
		JLabel Ore = new JLabel("Ore");
		JLabel Grain = new JLabel("Grain");
		JLabel Lumber = new JLabel("Lumber");
		
		JLabel BrickVal		= new JLabel("0");
		JLabel WoolVal		= new JLabel("0");
		JLabel OreVal		= new JLabel("0");
		JLabel GrainVal		= new JLabel("0");
		JLabel LumberVal	= new JLabel("0");
		
		
		Resources.setBounds(47, 25, 65, 25);
		Brick.setBounds(60, 50, 65, 25);
		Wool.setBounds(60, 75, 65, 25);
		Ore.setBounds(60, 100, 65, 25);
		Grain.setBounds(60, 125, 65, 25);
		Lumber.setBounds(60, 150, 65, 25);
		
		BrickVal.setBounds(47, 50, 65, 25);
		WoolVal.setBounds(47, 75, 65, 25);
		OreVal.setBounds(47, 100, 65, 25);
		GrainVal.setBounds(47, 125, 65, 25);
		LumberVal.setBounds(47, 150, 65, 25);
		
		
		Status.add(Resources);
		Status.add(Brick);
		Status.add(Wool);
		Status.add(Ore);
		Status.add(Grain);
		Status.add(Lumber);
		
		Status.add(BrickVal);
		Status.add(WoolVal);
		Status.add(OreVal);
		Status.add(GrainVal);
		Status.add(LumberVal);
	}
}
