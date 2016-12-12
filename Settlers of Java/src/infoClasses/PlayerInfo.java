/*
*	@file PlayrInfo.java
*	@author Stuart Wreath/Ryan Niday
*	@date 11-1-16
*	@brief a class to keep track of player's cards and stats during a game of catan
*/
package infoClasses;

import java.io.Serializable;
//import java.util.Scanner;

import GameBoard.PointNode;
import GameBoard.LineNode;

public class PlayerInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2602545802985608963L;
	//Scanner myScan;
	int VP = 0;
	int Pvp = 0;
	int Wheat = 0;
	int Sheep = 0;
	int Ore = 0;
	int Brick = 0;
	int Wood = 0;
	int Set = 0;
	int Cities = 0;
	int Roads = 0;
	int Knights = 0;
	int Dev = 0;
	boolean longestRoad = false;
	boolean largestArmy = false;
	Settlement[] settlements;
	City[] cities;
	Road[] roads;
	int monopoly;
	int roadBuilding;
	int yearOfPlenty;
	int knightCard;
	DevelopmentCards dCards;
	boolean wheatPort = false;
	boolean woodPort = false;
	boolean brickPort = false;
	boolean orePort = false;
	boolean sheepPort = false;
	boolean miscPort = false;
	boolean myTurn = false;
	int playerNumber;

	/* @pre none
	*  @post creates a PlayerInfo object with variables initialed to appropriate values
	*  @return none
	*/
	public PlayerInfo(int a){
		settlements = new Settlement[9];
		cities = new City[4];
		roads = new Road[15];
		Set = 5;
		Cities = 4;
		Roads = 15;
		dCards = new DevelopmentCards();
		//myScan = new Scanner(System.in);
		playerNumber = a;
	}
	
	//get and set functions for whether it is this players turn currently
	public void setTurn(boolean a){myTurn = a;}
	public boolean getTurn(){return myTurn;}
	
	public void setPlayerNumber(int a){
		playerNumber = a;
	}
	
	public int getPlayerNubmer(){
		return playerNumber;
	}
	
	//*****
	//actual victory points methods
	//*****
	public int getVP(){
		return VP;
	}
	
	//*****
	//public victory points methods
	//*****
	public int Pvp(){
			return Pvp;
	}
	public boolean calcPvp(){
		VP = Set+ (Cities * 2);
		if(longestRoad){VP++;}
		if(largestArmy){VP++;}
		return true;
	}
		
	//*****
	//wheat get and set methods
	//*****
	public int getWheat(){return Wheat;}
	public boolean setWheat(int inp){Wheat = inp; return true;}
	
	//*****
	//Sheep get and set methods
	//*****
	public int getSheep(){return Sheep;}
	public boolean setSheep(int inp){Sheep = inp; return true;}
	
	//*****
	//Ore get and set methods
	//*****
	public int getOre(){return Ore;}
	public boolean setOre(int inp){Ore = inp; return true;}
	
	//*****
	//Brick get and set methods
	//*****
	public int getBrick(){return Brick;}
	public boolean setBrick(int inp){Brick = inp; return true;}
	
	//*****
	//Wood get and set methods
	//*****
	public int getWood(){return Wood;}
	public boolean setWood(int inp){Wood = inp; return true;}
	
	//*****
	//Settlement get and set methods
	//*****
	public int getSet(){return Set;}
	public boolean setSet(int inp){Set = inp; return true;}
	
	//*****
	//Cities get and set methods
	//*****
	public int getCities(){return Cities;}
	public boolean setCities(int inp){Cities = inp; return true;}
	
	//*****
	//Roads get and set methods
	//*****
	public int getRoads(){return Roads;}
	public boolean setRoads(int inp){Roads = inp; return true;}
	public boolean getLongestRoad(){return longestRoad;}
	public boolean setLongestRoad(boolean inp){longestRoad = inp; return true;}

	
	//*****
	//Knight get and set methods
	//*****
	public int getKnights(){return Knights;}
	public boolean setKnights(int inp){Knights = inp; return true;}
	public boolean setLargestArmy(boolean inp){largestArmy = inp; return true;}
	
	//*****
	//get and set methods for number of development cards
	//*****
	public int getDev(){return Dev;}
	public boolean setDev(int inp){Dev = inp; return true;}
	
	public Road[] getRoadArray(){
		return roads;
	}
	
	//Adds a settlement to an array of settlements keeping track of where this players settlements are
	//Only sets a settlement if space is empty, and the player has settlements left
	/* @pre a is a valid PointNode, b is a valid PlayerInfo
	*  @post if settlement is allowed in requested space, then a new Settlement is set in first open spot in settlements array
	*  @return none
	*/
	public boolean setSettlement(PointNode a, PlayerInfo b){
		if(Set <= 0){
			System.out.println("No Settlements left");
			return false;
		}
		for(int i = 0; i < 9; i++){
			if(settlements[i] == null){
				settlements[i] = new Settlement(a,b);
				if(a.setSettlement(settlements[i])){
					if(a.getOccupancy().equals("1") || a.getOccupancy().equals("4")){
						miscPort = true;
					}
					else if(a.getOccupancy().equals("2") || a.getOccupancy().equals("6")){
						sheepPort = true;
					}
					else if(a.getOccupancy().equals("11") || a.getOccupancy().equals("16")){
						miscPort = true;
					}
					else if(a.getOccupancy().equals("27") || a.getOccupancy().equals("33")){
						miscPort = true;
					}
					else if(a.getOccupancy().equals("43") || a.getOccupancy().equals("47")){
						brickPort = true;
					}
					else if(a.getOccupancy().equals("50") || a.getOccupancy().equals("53")){
						woodPort = true;
					}
					else if(a.getOccupancy().equals("52") || a.getOccupancy().equals("48")){
						miscPort = true;
					}
					else if(a.getOccupancy().equals("39") || a.getOccupancy().equals("34")){
						wheatPort = true;
					}
					else if(a.getOccupancy().equals("12") || a.getOccupancy().equals("17")){
						orePort = true;
					}
					a.setPlayerNumber(playerNumber);
					System.out.println("success");
					Set--;
					VP++;
					return true;
				}
				else{
					settlements[i] = null;
				}
				return false;
			}
		}
		return false;
	}
	
	/* @pre a is a valid PointNode, b is a valid PlayerInfo
	*  @post if city is allowed in requested space, then a new City is set in first open spot in cities array
	*  @return none
	*/
	public boolean setCity(PointNode a,PlayerInfo b){
		for(int i = 0; i < 4; i++){
			if(cities[i] == null){
				cities[i] = new City(a,b);
				if(a.setCity(cities[i])){
					System.out.println("success");
					Cities--;
					Set++;
					VP++;
					return true;
				}
				else{
					cities[i] = null;
				}
			i = 4;
			return false;
			}
		}
		return false;
	}
	
	/* @pre a is a valid LineNode, b is a valid PlayerInfo
	*  @post if road is allowed in requested space, then a new Road is set in first open spot in roads array
	*  @return none
	*/
	public boolean setRoad(LineNode a, PlayerInfo b){
		for(int i = 0; i < 15; i++){
			if(roads[i] == null){
				roads[i] = new Road(a,b);
				if(a.setRoad(roads[i],roads)){
					a.setPlayerNumber(playerNumber);
					System.out.println("success");
					Roads--;
					return true;
				}
				else{
					System.out.println("fail");
					roads[i] = null;
				}
				i = 15;
				return false;
			}
		}
		return false;
	}
	//Gathers resources from all settlements currently on the board for this player
	/* @pre a is a valid int
	*  @post adjusts resource values by inputing a into a the player's current Settlements
	*  @return none
	*/
	public void gatherResources(int a){
		for(int i = 0; i < 9; i++){
			if(settlements[i] == null){
				i = 9;
			}
			else{
				settlements[i].getResources(a);
			}
		}
		for(int i = 0; i < 5; i++){
			if(cities[i] == null){
				i = 9;
			}
			else{
				cities[i].getResources(a);
			}
		}
	}
	
	public void buySettlement(PointNode a, PlayerInfo b){
		if(b.getBrick() >= 1 && b.getWood() >= 1 && b.getSheep() >= 1 && b.getWheat() >= 1){
			if(setSettlement(a,b)){
				b.setBrick(b.getBrick()-1);
				b.setWood(b.getWood()-1);
				b.setSheep(b.getSheep()-1);
				b.setWheat(b.getWheat()-1);
			}
		}
		else{
			System.out.println("Insuficiant funds.");
		}
	}
	
	public void buyCity(PointNode a, PlayerInfo b){
		if(b.getWheat() >= 2 && b.getOre() >= 3){
			if(setCity(a,b)){
				b.setWheat(b.getWheat() - 2);
				b.setOre(b.getOre() - 3);
			}
		}
		else{
			System.out.println("Insuficiant funds.");
		}
	}
	
	public void buyRoad(LineNode a, PlayerInfo b){
		if(b.getWood() >= 1 && b.getBrick() >= 1){
			if(setRoad(a,b)){
				b.setWood(b.getWood() - 1);
				b.setBrick(b.getBrick() - 1);
			}
		}
	}
	
	public void buyDCard(PlayerInfo a){
		if(dCards.getDeck()[0] == 0){
			if(a.getSheep() >= 1 && a.getOre() >= 1 && a.getWheat() >= 1){
				if(dCards.getDeck()[0] == 1){
					knightCard++;
					a.setSheep(a.getSheep()-1);
					a.setOre(a.getOre()-1);
					a.setWheat(a.getWheat()-1);
				}
				else if(dCards.getDeck()[0] == 2){
					yearOfPlenty++;
					a.setSheep(a.getSheep()-1);
					a.setOre(a.getOre()-1);
					a.setWheat(a.getWheat()-1);
				}
				else if(dCards.getDeck()[0] == 3){
					roadBuilding++;
					a.setSheep(a.getSheep()-1);
					a.setOre(a.getOre()-1);
					a.setWheat(a.getWheat()-1);
				}
				else if(dCards.getDeck()[0] == 4){
					monopoly++;
					a.setSheep(a.getSheep()-1);
					a.setOre(a.getOre()-1);
					a.setWheat(a.getWheat()-1);
				}
				else if(dCards.getDeck()[0] == 5){
					VP++;
					a.setSheep(a.getSheep()-1);
					a.setOre(a.getOre()-1);
					a.setWheat(a.getWheat()-1);
				}
				int[] tempArr = new int[dCards.getDeck().length-1];
				for(int i = 1; i < dCards.getDeck().length; i++){
					tempArr[i-1] = dCards.getDeck()[i];
				}
				dCards.setDeck(tempArr);
			}
		}
	}
	
	public void useMonopoly(PlayerInfo a,PlayerInfo[] b,int resource){
		for(int i = 0; i < b.length; i++){
			if(b[i] != a){
				if(resource == 1){
					a.setWheat(a.getWheat()+b[i].getWheat());
					b[i].setWheat(0);
				}
				else if(resource == 2){
					a.setWood(a.getWood()+b[i].getWood());
					b[i].setWood(0);
				}
				else if(resource == 3){
					a.setBrick(a.getBrick()+b[i].getBrick());
					b[i].setBrick(0);
				}
				else if(resource == 4){
					a.setOre(a.getOre()+b[i].getOre());
					b[i].setOre(0);
				}
				else if(resource == 5){
					a.setSheep(a.getSheep()+b[i].getSheep());
					b[i].setSheep(0);
				}
			}
		}
		monopoly--;
	}
	
	public void useRoadBuilding(PlayerInfo a,LineNode b,LineNode c){
		setRoad(b,a);
		setRoad(c,a);
		roadBuilding--;
	}
	
	public void useYearOfPlenty(PlayerInfo a,int resource){
		if(resource == 1){
			a.setWheat(a.getWheat()+2);
		}
		else if(resource == 2){
			a.setWood(a.getWood()+2);
		}
		else if(resource == 3){
			a.setBrick(a.getBrick()+2);
		}
		else if(resource == 4){
			a.setOre(a.getOre()+2);
		}
		else if(resource == 5){
			a.setSheep(a.getSheep()+2);
		}
		yearOfPlenty--;
	}
	
	public void useKnight(){
		knightCard--;
	}
	
	public void tradeInput(int numTrading,int type,PlayerInfo a){
		if(type == 1){
			a.setWheat(a.getWheat()-numTrading);
		}
		else if(type == 2){
			a.setWood(a.getWood()-numTrading);
		}
		else if(type == 3){
			a.setBrick(a.getBrick()-numTrading);
		}
		else if(type == 4){
			a.setOre(a.getOre()-numTrading);
		}
		else if(type == 5){
			a.setSheep(a.getSheep()-numTrading);
		}
	}
	
	public void tradeOutPut(int numTrading,int type,PlayerInfo a){
		if(type == 1){
			a.setWheat(a.getWheat()+numTrading);
		}
		else if(type == 2){
			a.setWood(a.getWood()+numTrading);
		}
		else if(type == 3){
			a.setBrick(a.getBrick()+numTrading);
		}
		else if(type == 4){
			a.setOre(a.getOre()+numTrading);
		}
		else if(type == 5){
			a.setSheep(a.getSheep()+numTrading);
		}
	}
	
	/*public void tradeOffer(PlayerInfo a,PlayerInfo b){
		int[] offer = new int[5];
		int[] request = new int[5];
		System.out.println("How much wheat do you offer?");
		offer[0] = myScan.nextInt();
		while(a.getWheat() < offer[0] || offer[0] < 0){
			System.out.println("How much do you really offer?");
			offer[0] = myScan.nextInt();
		}
		System.out.println("How much wood do you offer?");
		offer[1] = myScan.nextInt();
		while(a.getWood() < offer[1] || offer[1] < 0){
			System.out.println("How much do you really offer?");
			offer[1] = myScan.nextInt();
		}
		System.out.println("How much brick do you offer?");
		offer[2] = myScan.nextInt();
		while(a.getBrick() < offer[2] || offer[2] < 0){
			System.out.println("How much do you really offer?");
			offer[2] = myScan.nextInt();
		}
		System.out.println("How much ore do you offer?");
		offer[3] = myScan.nextInt();
		while(a.getOre() < offer[3] || offer[3] < 0){
			System.out.println("How much do you really offer?");
			offer[3] = myScan.nextInt();
		}
		System.out.println("How much sheep do you offer?");
		offer[4] = myScan.nextInt();
		while(a.getSheep() < offer[4] || offer[4] < 0){
			System.out.println("How much do you really offer?");
			offer[4] = myScan.nextInt();
		}
		System.out.println("How much wheat do you request?");
		request[0] = myScan.nextInt();
		while(b.getWheat() < request[0] || request[0] < 0){
			System.out.println("Please request a valid number");
			request[0] = myScan.nextInt();
		}
		System.out.println("How much wood do you request?");
		request[1] = myScan.nextInt();
		while(b.getWood() < request[1] || request[1] < 0){
			System.out.println("Please request a valid number");
			request[1] = myScan.nextInt();
		}
		System.out.println("How much brick do you request?");
		request[2] = myScan.nextInt();
		while(b.getBrick() < request[2] || request[2] < 0){
			System.out.println("Please request a valid number");
			request[2] = myScan.nextInt();
		}
		System.out.println("How much ore do you request?");
		request[3] = myScan.nextInt();
		while(b.getOre() < request[3] || request[3] < 0){
			System.out.println("Please request a valid number");
			request[3] = myScan.nextInt();
		}
		System.out.println("How much sheep do you request?");
		request[4] = myScan.nextInt();
		while(b.getSheep() < request[4] || request[4] < 0){
			System.out.println("Please request a valid number");
			request[4] = myScan.nextInt();
		}
		if(offerAcceptance(offer,request)){
			a.setWheat(a.getWheat() - offer[0] + request[0]);
			a.setWood(a.getWood() - offer[1] + request[1]);
			a.setBrick(a.getBrick() - offer[2] + request[2]);
			a.setOre(a.getOre() - offer[3] + request[3]);
			a.setSheep(a.getSheep() - offer[4] + request[4]);
			b.setWheat(b.getWheat() + offer[0] - request[0]);
			b.setWood(b.getWood() + offer[1] - request[1]);
			b.setBrick(b.getBrick() + offer[2] - request[2]);
			b.setOre(b.getOre() + offer[3] - request[3]);
			b.setSheep(b.getSheep() + offer[4] - request[4]);
		}
		else{
			System.out.println("Trade declined");
		}
	}
	
	public boolean offerAcceptance(int[] offer, int[] request){
		int decision;
		System.out.println("Other player's offer:");
		System.out.println("Wheat: " + offer[0]);
		System.out.println("Wood: " + offer[1]);
		System.out.println("Brick: " + offer[2]);
		System.out.println("Ore: " + offer[3]);
		System.out.println("Sheep: " + offer[4]);
		System.out.println("Other player's request:");
		System.out.println("Wheat: " + request[0]);
		System.out.println("Wood: " + request[1]);
		System.out.println("Brick: " + request[2]);
		System.out.println("Ore: " + request[3]);
		System.out.println("Sheep: " + request[4]);
		System.out.println("Do you accept the deal?(1 for yes, 0 for no)");
		decision = myScan.nextInt();
		if(decision == 1){
			return true;
		}
		else{ 
			return false;
		}
	}*/
	
}	
