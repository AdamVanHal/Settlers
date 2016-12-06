/*
*	@file SettlersOfJava.java
*	@author Ryan Niday
*	@date 11-1-16
*	@brief a simple test class for the back end of catan
*/
package main;

import GameBoard.GameBoard;
import infoClasses.PlayerInfo;
import Utilities.Dice;
import infoClasses.LongestRoad;

public class SettlersOfJava {
	public static void main(String[] args){
		LongestRoad lRoad = new LongestRoad();
		Dice d6 = new Dice(6);
		GameBoard game = new GameBoard();
		PlayerInfo[] players = new PlayerInfo[4];
		for(int i = 0; i < 4; i++){
			players[i] = new PlayerInfo(i+1);
		}
		players[1].setSettlement(game.getPoint(2),players[1]);
		players[1].setSettlement(game.getPoint(9),players[1]);
		players[1].setCity(game.getPoint(9),players[1]);
		players[1].setRoad(game.getLine(4),players[1]);
		players[1].setRoad(game.getLine(8),players[1]);
		players[1].setRoad(game.getLine(14),players[1]);
		players[1].setRoad(game.getLine(20),players[1]);
		players[1].setRoad(game.getLine(27),players[1]);
		players[0].setSettlement(game.getPoint(1),players[0]);
		players[0].setRoad(game.getLine(2),players[0]);
		players[0].setRoad(game.getLine(1),players[0]);
		players[0].setRoad(game.getLine(0),players[0]);
		players[0].setRoad(game.getLine(6),players[0]);
		players[0].setRoad(game.getLine(10),players[0]);
		players[0].setRoad(game.getLine(18),players[0]);
		//game.getPiece(5).setRobber(true);
		//game.getPiece(2).setRobber(true);
		for(int i = 0; i < 20; i++){
			int a = d6.roll();
			int b = d6.roll();
			System.out.println(a+b);
			players[1].gatherResources(a+b);
			players[0].gatherResources(a+b);
		}
		players[1].setBrick(1);
		players[1].setSheep(1);
		players[1].buySettlement(game.getPoint(20), players[1]);
		System.out.println("Player1: ");
		System.out.println("Wheat: " + players[1].getWheat());
		System.out.println("Wood: " + players[1].getWood());
		System.out.println("Settlements left: " + players[1].getSet());
		System.out.println("Cities left: " + players[1].getCities());
		System.out.println("Victory Points: " + players[1].getVP());
		System.out.println("Roads left: " + players[1].getRoads());
		System.out.println("Player2: ");
		System.out.println("Wheat: " + players[0].getWheat());
		System.out.println("Wood: " + players[0].getWood());
		System.out.println("Settlements left: " + players[0].getSet());
		System.out.println("Cities left: " + players[0].getCities());
		System.out.println("Victory Points: " + players[0].getVP());
		System.out.println("Roads left: " + players[0].getRoads() + "\n\n");
		System.out.println("Player1 claims longest road");
		lRoad.setRoadArray(game.getLine(4));
		lRoad.setRoadArray(game.getLine(8));
		lRoad.setRoadArray(game.getLine(14));
		lRoad.setRoadArray(game.getLine(20));
		lRoad.setRoadArray(game.getLine(27));
		if(lRoad.checkRoad(players[1])){
			for(int i = 0; i < 4; i++){
				players[i].setLongestRoad(false);
			}
			players[1].setLongestRoad(true);
		}
		System.out.println("Player1's longest road status: "+players[1].getLongestRoad());
		System.out.println("Player2's longest road status: "+players[0].getLongestRoad());
		System.out.println("Player2 claims longest road");
		lRoad.setRoadArray(game.getLine(2));
		lRoad.setRoadArray(game.getLine(1));
		lRoad.setRoadArray(game.getLine(0));
		lRoad.setRoadArray(game.getLine(6));
		lRoad.setRoadArray(game.getLine(10));
		lRoad.setRoadArray(game.getLine(18));
		if(lRoad.checkRoad(players[0])){
			for(int i = 0; i < 4; i++){
				players[i].setLongestRoad(false);
			}
			players[0].setLongestRoad(true);
		}
		System.out.println("Player1's longest road status: "+players[1].getLongestRoad());
		System.out.println("Player2's longest road status: "+players[0].getLongestRoad());
		players[0].tradeOffer(players[0], players[1]);
		System.out.println("Player1: ");
		System.out.println("Wheat: " + players[1].getWheat());
		System.out.println("Wood: " + players[1].getWood());
		System.out.println("Settlements left: " + players[1].getSet());
		System.out.println("Cities left: " + players[1].getCities());
		System.out.println("Victory Points: " + players[1].getVP());
		System.out.println("Roads left: " + players[1].getRoads());
		System.out.println("Player2: ");
		System.out.println("Wheat: " + players[0].getWheat());
		System.out.println("Wood: " + players[0].getWood());
		System.out.println("Settlements left: " + players[0].getSet());
		System.out.println("Cities left: " + players[0].getCities());
		System.out.println("Victory Points: " + players[0].getVP());
		System.out.println("Roads left: " + players[0].getRoads() + "\n\n");
	}
}
