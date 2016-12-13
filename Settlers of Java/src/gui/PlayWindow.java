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
import java.util.ArrayList;
import Utilities.NetworkThread;
import Utilities.Message;
import gui.LaunchWindow;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayWindow {

	public JFrame frame;
	
	//LongestRoad lRoad = new LongestRoad();
	public Dice d6 = new Dice(6);
	public volatile GameBoard game;
	public volatile PlayerInfo[] players;
	private boolean isHost;
	private ArrayList<NetworkThread> networkConnection = new ArrayList<NetworkThread>();
	private BoardGraphics Island;
	
	private int numTurns     = 0;
	public  int numPlayers   = 0;
	public  int playerNumber = 0;
	
	public boolean ifSetup   = true;
	public boolean myTurn   = false;
	public boolean hasRolled = false;
	public boolean initDone = false;
	
	public static String username;
	
	//global swing stuff
	public JLabel BrickVal		= new JLabel("0");
	public JLabel WoolVal		= new JLabel("0");
	public JLabel OreVal		= new JLabel("0");
	public JLabel GrainVal		= new JLabel("0");
	public JLabel LumberVal		= new JLabel("0");
	public JButton btnRoll 		= new JButton("Roll");
	public JButton btnEndTurn 	= new JButton("End Turn");
		

	/*
	 * @pre    None
	 * @post   Launches the play window, primarily used in stand-alone testing. 
	 * @return None
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayWindow window = new PlayWindow(new ArrayList<NetworkThread>(), true);
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
	public PlayWindow(ArrayList<NetworkThread> Threads, boolean IsHost) {
		frame = new JFrame("Settlers of Java");
		frame.setBounds(100, 100, 875, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		networkConnection = Threads;
		for(int i=0; i<networkConnection.size();i++){
			networkConnection.get(i).gameReference(this);
		}
		this.isHost = IsHost;
		if(isHost){
			hostInitialize();
			frame.setTitle("Host: Settlers of Java");
		}
		else{
			
		}
	}
	
	

	/*
	 * @pre    None
	 * @post   Initializes all GUI components and their listeners, including the board element 
	 * @return None
	 */
	private void hostInitialize() {
		//add the main game area to the center
		game = new GameBoard();
		numPlayers = networkConnection.size()+1;
		players = new PlayerInfo[numPlayers];
		for(int i = 0; i < numPlayers; i ++){
			players[i] = new PlayerInfo(i+1);
		}
		for(int i=0; i<networkConnection.size();i++){
			networkConnection.get(i).writeMsg(new Message("initialize", game, players));
		}
		initialize(game, players);
		myTurn = true;
		Island.cursorState = 4;
	}
	
	public void initialize(GameBoard game2, PlayerInfo[] players2){
		this.game = game2;
		this.players = players2;
		Island = new BoardGraphics(this);
		Island.setBounds(160, 0, 685, 644);
		frame.getContentPane().add(Island);
		
		numPlayers = players2.length;
		
		if(!isHost){
			playerNumber = networkConnection.get(0).playerID;
			username = HostWindow.username;
		}
		else{
			username = JoinWindow.username;
		}
		
		JPanel Status = new JPanel();
		Status.setBounds(0, 0, 150, 600);
		frame.getContentPane().add(Status);
		Status.setLayout(null);
		
		//Generic button that currently does nothing
		
		btnEndTurn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if((myTurn && hasRolled) || (myTurn && ifSetup)){
					if(playerNumber == (numPlayers-1)){
						players[0].setTurn(true);
					}
					else{
						players[playerNumber+1].setTurn(true);
					}
					players[playerNumber].setTurn(false);
					numTurns ++;
					if(numTurns > 1){
						ifSetup = false;
					}
					myTurn = false;
					updatePlayerArray();
					btnEndTurn.setEnabled(false);
					btnRoll.setEnabled(false);
					hasRolled = false;
					initDone = false;
				}
				
			}
		});
		btnEndTurn.setBounds(35, 575, 90, 25);
		Status.add(btnEndTurn);
		btnEndTurn.setEnabled(myTurn);
		
		JLabel Player = new JLabel("Player " + playerNumber + ":");
		JLabel user = new JLabel(LaunchWindow.username);
		JLabel Resources = new JLabel("Resources");
		JLabel Brick = new JLabel("Brick");
		JLabel Wool = new JLabel("Wool");
		JLabel Ore = new JLabel("Ore");
		JLabel Grain = new JLabel("Grain");
		JLabel Lumber = new JLabel("Lumber");
		
		Player.setBounds(50, 25, 60, 25);
		Resources.setBounds(47, 125, 65, 25);
		Brick.setBounds(65, 150, 65, 25);
		Wool.setBounds(65, 175, 65, 25);
		Ore.setBounds(65, 200, 65, 25);
		Grain.setBounds(65, 225, 65, 25);
		Lumber.setBounds(65, 250, 65, 25);
		
		BrickVal.setBounds(47, 150, 65, 25);
		WoolVal.setBounds(47, 175, 65, 25);
		OreVal.setBounds(47, 200, 65, 25);
		GrainVal.setBounds(47, 225, 65, 25);
		LumberVal.setBounds(47, 250, 65, 25);
		
		JLabel rollShow = new JLabel("");
		rollShow.setBounds(30,50,125,25);
		Status.add(rollShow);
		
		//Generic button that currently does nothing
		
		btnRoll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(!ifSetup && !hasRolled){
					int a = d6.roll();
					int b = d6.roll();
					System.out.println(a+b);
					int c = a + b;
					rollShow.setText("A(n) " + c + " was rolled.");
					for(int i=0; i<players.length;i++){
						players[i].gatherResources(a+b);
					}
				
					BrickVal.setText(Integer.toString(players[playerNumber].getBrick()));
					WoolVal.setText(Integer.toString(players[playerNumber].getSheep()));
					OreVal.setText(Integer.toString(players[playerNumber].getOre()));
					GrainVal.setText(Integer.toString(players[playerNumber].getWheat()));
					LumberVal.setText(Integer.toString(players[playerNumber].getWood()));
					hasRolled = true;
					btnRoll.setEnabled(false);
					updatePlayerArray();
					btnEndTurn.setEnabled(true);
				}
			}
		});
		btnRoll.setBounds(35, 525, 90, 25);
		Status.add(btnRoll);
		btnRoll.setEnabled(false);
		
		Status.add(Player);
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
		
		if(isHost){btnEndTurn.setEnabled(true);}
		
		frame.repaint();
	}
	
	/*
	 * @pre		
	 * @post
	 * @return
	 */
	public void updatePlayerArray(){
		/*Object[] temp = new Object[2];
		temp[0]=players[1];
		temp[1] = game;*/
		System.out.println(players[1].getSet());
		for(int i=0; i<networkConnection.size();i++){
			networkConnection.get(i).writeMsg(new Message("updatePlayerArray", game, players));
		}
		//To show that messages do make it across network
		for(int i=0; i<networkConnection.size();i++){
			networkConnection.get(i).writeMsg(new Message("Text", "Updating"));
		}
	}
	
	public void receivePlayerArray(PlayerInfo[] players2, GameBoard game2){
		this.players = players2;
		this.game = game2;
		
		BrickVal.setText(Integer.toString(players[playerNumber].getBrick()));
		WoolVal.setText(Integer.toString(players[playerNumber].getSheep()));
		OreVal.setText(Integer.toString(players[playerNumber].getOre()));
		GrainVal.setText(Integer.toString(players[playerNumber].getWheat()));
		LumberVal.setText(Integer.toString(players[playerNumber].getWood()));
		if(players[playerNumber].getTurn()){
			myTurn = true;
			btnRoll.setEnabled(!ifSetup && !hasRolled);
			if(ifSetup){
				btnEndTurn.setEnabled(true);
			}
			else{
				btnEndTurn.setEnabled(hasRolled);
			}
		}
		
		frame.repaint();
		if(ifSetup){
			if(players[playerNumber].getTurn() && Island.cursorState == 0 && initDone == false){
				Island.cursorState = 4;
			}
		}
	}
	
}
