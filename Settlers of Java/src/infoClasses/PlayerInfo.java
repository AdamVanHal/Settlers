/*
*	@file PlayrInfo.java
*	@author Stuart Wreath/Ryan Niday
*	@date 11-1-16
*	@brief a class to keep track of player's cards and stats during a game of catan
*/
package infoClasses;

import java.util.Scanner;
import java.io.*;
import GameBoard.PointNode;
import GameBoard.LineNode;

public class PlayerInfo{
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

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		String str = "";
		int choice = 1000;
		int date = 0;
		while(choice != 0){
			System.out.println("-------------------------");
			System.out.println("1.getVP 		2.calcVP\n"			+
								"3.getPvp		4.calcPvp\n"		+
								"5.getRoad		6.setRoad\n"		+
								"7.getWheat		8.setWheat\n"		+
								"9.getSheep		10.setSheep\n"		+
								"11.getOre		12.setOre\n"		+
								"13.getBrick		14.setBrick\n"	+
								"15.getWood		16.setWood\n"		+
								"17.getSet		18.setSet\n"		+
								"19.getCities		20.setCities\n"	+
								"21.getKnights		22.setKnights\n"+
								"23.getDev		24.setDev\n");
			choice = kb.nextInt();
		}
	}
	/* @pre none
	*  @post creates a PlayerInfo object with variables initialed to appropriate values
	*  @return none
	*/
	public PlayerInfo(){
		settlements = new Settlement[9];
		cities = new City[4];
		roads = new Road[15];
		Set = 5;
		Cities = 4;
		Roads = 15;
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
	public void setSettlement(PointNode a, PlayerInfo b){
		if(Set <= 0){
			System.out.println("No Settlements left");
			return;
		}
		for(int i = 0; i < 9; i++){
			if(settlements[i] == null){
				settlements[i] = new Settlement(a,b);
				if(a.setSettlement(settlements[i])){
					System.out.println("success");
					Set--;
					VP++;
				}
				else{
					settlements[i] = null;
				}
				i = 9;
			}
		}
	}
	
	/* @pre a is a valid PointNode, b is a valid PlayerInfo
	*  @post if city is allowed in requested space, then a new City is set in first open spot in cities array
	*  @return none
	*/
	public void setCity(PointNode a,PlayerInfo b){
		for(int i = 0; i < 4; i++){
			if(cities[i] == null){
				cities[i] = new City(a,b);
				if(a.hasSettlement()){
					System.out.println("success");
					Cities--;
					Set++;
					VP++;
				}
				else{
					cities[i] = null;
				}
			}
			i = 4;
		}
	}
	
	/* @pre a is a valid LineNode, b is a valid PlayerInfo
	*  @post if road is allowed in requested space, then a new Road is set in first open spot in roads array
	*  @return none
	*/
	public void setRoad(LineNode a, PlayerInfo b){
		for(int i = 0; i < 15; i++){
			if(roads[i] == null){
				roads[i] = new Road(a,b);
				if(a.setRoad(roads[i],roads)){
					System.out.println("success");
					Roads--;
				}
				else{
					System.out.println("fail");
					roads[i] = null;
				}
				i = 15;
			}
		}
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
	
	
}	
