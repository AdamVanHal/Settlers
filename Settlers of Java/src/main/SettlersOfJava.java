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

public class SettlersOfJava {
	public static void main(String[] args){
		Dice d6 = new Dice(6);
		GameBoard game = new GameBoard();
		PlayerInfo[] players = new PlayerInfo[4];
		for(int i = 0; i < 4; i++){
			players[i] = new PlayerInfo();
		}
		players[1].setSettlement(game.getPoint(2),players[1]);
		players[1].setSettlement(game.getPoint(9),players[1]);
		players[1].setCity(game.getPoint(9),players[1]);
		players[1].setRoad(game.getLine(4),players[1]);
		players[1].setRoad(game.getLine(3),players[1]);
		players[0].setSettlement(game.getPoint(1),players[0]);
		players[0].setRoad(game.getLine(2),players[0]);
		for(int i = 0; i < 20; i++){
			int a = d6.roll();
			int b = d6.roll();
			System.out.println(a+b);
			players[1].gatherResources(a+b);
			players[0].gatherResources(a+b);
		}
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
		System.out.println("Roads left: " + players[0].getRoads());
	}
}
