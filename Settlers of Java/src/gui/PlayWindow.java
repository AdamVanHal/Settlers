/*
*	@file PlayWindow.java
*	@author Adam Van Hal
*	@date 12-13-16
*	@Creates a place to draw the game boar and interact with players
*/
package gui;

import java.awt.Color;
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
	
	public JLabel vpVal = new JLabel("0");
		

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
	 * @post   Initializes everything the host needs but not the clients
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
	
	/*
	 * @pre    None
	 * @post   Initializes all GUI components and their listeners, including the board element 
	 * @return None
	 */
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
		Status.setBounds(0, 0, 150, 700);
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
		btnEndTurn.setBounds(35, 594, 90, 25);
		Status.add(btnEndTurn);
		btnEndTurn.setEnabled(myTurn);
		
		JLabel Player = new JLabel("Player " + playerNumber + ":");
		JLabel user = new JLabel(LaunchWindow.username);
		JLabel Resources = new JLabel("<HTML><u>Resources</U></HTML>");
		JLabel Brick = new JLabel("Brick");
		JLabel brickAbbr = new JLabel("(B)");
		JLabel Wool = new JLabel("Wool");
		JLabel woolAbbr = new JLabel("(W)");
		JLabel Ore = new JLabel("Ore");
		JLabel oreAbbr = new JLabel("(O)");
		JLabel Grain = new JLabel("Grain");
		JLabel grainAbbr = new JLabel("(G)");
		JLabel Lumber = new JLabel("Lumber");
		JLabel lumberAbbr = new JLabel("(L)");
		
		Player.setBounds(50, 25, 60, 25);
		user.setBounds(50,50,60,25);
		Resources.setBounds(47, 125, 65, 25);
		Brick.setBounds(65, 150, 65, 25);
		Wool.setBounds(65, 175, 65, 25);
		Ore.setBounds(65, 200, 65, 25);
		Grain.setBounds(65, 225, 65, 25);
		Lumber.setBounds(65, 250, 65, 25);
		
		brickAbbr.setBounds(20,150,65,25);
		brickAbbr.setForeground(new Color(209,79,50,255));
		woolAbbr.setBounds(20,175,65,25);
		woolAbbr.setForeground(new Color(136,214,19,255));
		oreAbbr.setBounds(20,200,65,25);
		oreAbbr.setForeground(new Color(114,107,97,255));
		grainAbbr.setBounds(20,225,65,25);
		grainAbbr.setForeground(new Color(249,237,9,255));
		lumberAbbr.setBounds(20,250,65,25);
		lumberAbbr.setForeground(new Color(19,119,8,255));
		
		BrickVal.setBounds(47, 150, 65, 25);
		WoolVal.setBounds(47, 175, 65, 25);
		OreVal.setBounds(47, 200, 65, 25);
		GrainVal.setBounds(47, 225, 65, 25);
		LumberVal.setBounds(47, 250, 65, 25);
		
		JLabel rollShow = new JLabel("");
		rollShow.setBounds(30,75,125,25);
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
					if(c==7){
						for(int i=0;i<19;i++){
							game.getPiece(i).setRobber(false);
						}
						game.getPiece((int)Math.floor(Math.random()*19)).setRobber(true);
						for(int i=0; i<players.length;i++){
							int count = 0;
							count += players[i].getBrick();
							count += players[i].getSheep();
							count += players[i].getOre();
							count += players[i].getWheat();
							count += players[i].getWood();
							int target = count/2;
							if(count>7){
								while(count>target){
									int Resource =(int) Math.floor(Math.random()*5);
									if(Resource == 0){
										if(players[i].getBrick()>0){
											players[i].setBrick(players[i].getBrick()-1);
											count-=1;
										}else{
											Resource+=1;
										}
									}
									if(Resource == 1){
										if(players[i].getSheep()>0){
											players[i].setSheep(players[i].getSheep()-1);
											count-=1;
										}else{
											Resource+=1;
										}
									}
									if(Resource == 2){
										if(players[i].getOre()>0){
											players[i].setOre(players[i].getOre()-1);
											count-=1;
										}else{
											Resource+=1;
										}
									}
									if(Resource == 3){
										if(players[i].getWheat()>0){
											players[i].setWheat(players[i].getWheat()-1);
											count-=1;
										}else{
											Resource+=1;
										}
									}
									if(Resource == 4){
										if(players[i].getWood()>0){
											players[i].setWood(players[i].getWood()-1);
											count-=1;
										}
									}
								}
							}
						}
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
					frame.repaint();
				}
			}
		});
		btnRoll.setBounds(35, 544, 90, 25);
		Status.add(btnRoll);
		btnRoll.setEnabled(false);
		
		Status.add(Player);
		Status.add(user);
		Status.add(Resources);
		Status.add(Brick);
		Status.add(brickAbbr);
		Status.add(Wool);
		Status.add(woolAbbr);
		Status.add(Ore);
		Status.add(oreAbbr);
		Status.add(Grain);
		Status.add(grainAbbr);
		Status.add(Lumber);
		Status.add(lumberAbbr);
		
		Status.add(BrickVal);
		Status.add(WoolVal);
		Status.add(OreVal);
		Status.add(GrainVal);
		Status.add(LumberVal);
		
		JLabel victoryPoints = new JLabel("Victory Points: ");
		victoryPoints.setBounds(30, 500, 100, 25);
		vpVal.setBounds(120, 500, 100, 25);
		Status.add(victoryPoints);
		Status.add(vpVal);
		
		
		JLabel buildCosts = new JLabel("<HTML><U>Build Costs:</U></HTML>");
		//BWOGL
		JLabel subSettlement = new JLabel("Settlement:");
		JLabel settlementCost = new JLabel("1B, 1W, 1G, 1L");
		JLabel subRoad = new JLabel("Road: ");
		JLabel roadCost = new JLabel("1B, 1L");
		JLabel subCity = new JLabel("City: ");
		JLabel cityCost = new JLabel("3O, 2G");
		
		buildCosts.setBounds(47,300,100,25);
		subSettlement.setBounds(47,325,100,25);
		settlementCost.setBounds(47,350,100,25);
		subRoad.setBounds(47,375,100,25);
		roadCost.setBounds(47,400,100,25);
		subCity.setBounds(47,425,100,25);
		cityCost.setBounds(47,450,100,25);
		
		Status.add(buildCosts);
		Status.add(subSettlement);
		Status.add(settlementCost);
		Status.add(subRoad);
		Status.add(roadCost);
		Status.add(subCity);
		Status.add(cityCost);
		
		if(isHost){btnEndTurn.setEnabled(true);}
		
		frame.repaint();
	}
	
	/*
	 * @pre	Players array exists, networkConnection exists	
	 * @post Message was sent to the network
	 * @return None
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
	
	/*
	 * @pre    Players array exists, GameBoard game exists, frame is created
	 * @post   Updates game information and redraws the window
	 * @return None
	 */
	public void receivePlayerArray(PlayerInfo[] players2, GameBoard game2){
		this.players = players2;
		this.game = game2;
		
		BrickVal.setText(Integer.toString(players[playerNumber].getBrick()));
		WoolVal.setText(Integer.toString(players[playerNumber].getSheep()));
		OreVal.setText(Integer.toString(players[playerNumber].getOre()));
		GrainVal.setText(Integer.toString(players[playerNumber].getWheat()));
		LumberVal.setText(Integer.toString(players[playerNumber].getWood()));
		
		vpVal.setText(Integer.toString(players[playerNumber].getVP()));
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
