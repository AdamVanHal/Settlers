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
			players[i] = new PlayerInfo(i+1);
		}
		
		System.out.println("Due to the complexity of how the methods work in the back end of the game, the following tests are set up as a simulation of playing the game and testing out all the legal and illegal moves dictated by the rules.");
		
		System.out.println("\nPiece setting tests:");
		System.out.print("Player 1 builds a settlement: ");
		players[1].setSettlement(game.getPoint(2),players[1]);
		
		System.out.print("\nPlayer 2 builds a settlement: ");
		players[0].setSettlement(game.getPoint(1),players[0]);
		
		System.out.print("\nPlayer 2 tries to build a settlement over Player 1's settlement: ");
		players[0].setSettlement(game.getPoint(2),players[0]);
		
		System.out.print("\nPlayer 1 tries to build a settlement on top of first settlement: ");
		players[1].setSettlement(game.getPoint(2),players[1]);
		
		System.out.print("\nPlayer 1 tries to build a settlement adjacent to first settlement: ");
		players[1].setSettlement(game.getPoint(5),players[1]);
		
		System.out.print("\nPlayer 1 builds a city over first settlement: ");
		players[1].setCity(game.getPoint(2),players[1]);
		
		System.out.print("\nPlayer 2 tries to build a city on a space without a settlement: ");
		players[0].setCity(game.getPoint(19),players[0]);
		
		System.out.print("\nChecking that Player 1 has a city: ");
		System.out.println(game.getPoint(2).hasCity());
		
		System.out.print("\nChecking that Player 2 has a settlement: ");
		System.out.println(game.getPoint(1).hasSettlement());
		
		System.out.print("\nPlayer 1 builds a road adjacent to city: ");
		players[1].setRoad(game.getLine(4),players[1]);
		
		System.out.print("\nPlayer 1 builds a road over already built road: ");
		players[1].setRoad(game.getLine(4),players[1]);
		
		System.out.print("\nPlayer 1 builds a road not adjacent to other road or city: ");
		players[1].setRoad(game.getLine(14),players[1]);
		
		System.out.print("\nPlayer 1 builds a road adjacent to other road: ");
		players[1].setRoad(game.getLine(8),players[1]);
		
		System.out.print("\nPlayer 2 builds a road adjacent to settlment: ");
		players[0].setRoad(game.getLine(3),players[0]);
		
		System.out.print("\nPlayer 2 builds a road over already built road from Player 1: ");
		players[0].setRoad(game.getLine(8),players[0]);
		
		System.out.println("Resource collecting test:");
		System.out.println("\nRolling the die 20 times for a good random sample.");
		for(int i = 0; i < 20; i++){
			int a = d6.roll();
			int b = d6.roll();
			System.out.println("Die roll "+(i+1)+" value: "+(a+b));
			players[1].gatherResources(a+b);
			players[0].gatherResources(a+b);
		}
		//players[1].buySettlement(game.getPoint(20), players[1]);
		System.out.println("\nDue to a randomized board, the 20 die rolls will not cause the same resources to be collected every time.");
		System.out.println("So this is a read out of what each player currently has according to what they've built and collected");
		System.out.println("\nPlayer1: ");
		System.out.println("Wheat: " + players[1].getWheat());
		System.out.println("Wood: " + players[1].getWood());
		System.out.println("Brick: " + players[1].getBrick());
		System.out.println("Ore: " + players[1].getOre());
		System.out.println("Sheep: " + players[1].getSheep());
		System.out.println("Settlements left: " + players[1].getSet());
		System.out.println("Cities left: " + players[1].getCities());
		System.out.println("Victory Points: " + players[1].getVP());
		System.out.println("Roads left: " + players[1].getRoads());
		System.out.println("\nPlayer2: ");
		System.out.println("Wheat: " + players[0].getWheat());
		System.out.println("Wood: " + players[0].getWood());
		System.out.println("Brick: " + players[0].getBrick());
		System.out.println("Ore: " + players[0].getOre());
		System.out.println("Sheep: " + players[0].getSheep());
		System.out.println("Settlements left: " + players[0].getSet());
		System.out.println("Cities left: " + players[0].getCities());
		System.out.println("Victory Points: " + players[0].getVP());
		System.out.println("Roads left: " + players[0].getRoads() + "\n");
		
		System.out.println("Robber test:");
		System.out.println("\nRolling the die another 20 times to show proof of working robber.");
		game.getPiece(3).setRobber(true);
		game.getPiece(2).setRobber(true);
		for(int i = 0; i < 20; i++){
			int a = d6.roll();
			int b = d6.roll();
			System.out.println("Die roll "+(i+1)+" value: "+(a+b));
			players[1].gatherResources(a+b);
			players[0].gatherResources(a+b);
		}
		System.out.println("All the following numbers should be the same as the above readout due to no resources being collected");
		System.out.println("\nPlayer1: ");
		System.out.println("Wheat: " + players[1].getWheat());
		System.out.println("Wood: " + players[1].getWood());
		System.out.println("Brick: " + players[1].getBrick());
		System.out.println("Ore: " + players[1].getOre());
		System.out.println("Sheep: " + players[1].getSheep());
		System.out.println("Settlements left: " + players[1].getSet());
		System.out.println("Cities left: " + players[1].getCities());
		System.out.println("Victory Points: " + players[1].getVP());
		System.out.println("Roads left: " + players[1].getRoads());
		System.out.println("\nPlayer2: ");
		System.out.println("Wheat: " + players[0].getWheat());
		System.out.println("Wood: " + players[0].getWood());
		System.out.println("Brick: " + players[0].getBrick());
		System.out.println("Ore: " + players[0].getOre());
		System.out.println("Sheep: " + players[0].getSheep());
		System.out.println("Settlements left: " + players[0].getSet());
		System.out.println("Cities left: " + players[0].getCities());
		System.out.println("Victory Points: " + players[0].getVP());
		System.out.println("Roads left: " + players[0].getRoads() + "\n\n");
		
		players[1].setWheat(1);
		players[1].setWood(2);
		players[1].setBrick(2);
		players[1].setOre(0);
		players[1].setSheep(1);
		players[0].setWheat(2);
		players[0].setWood(0);
		players[0].setBrick(0);
		players[0].setOre(3);
		players[0].setSheep(0);
		
		
		System.out.println("Piece buying tests:");
		System.out.print("Player 1 buying a settlement: ");
		players[1].buySettlement(game.getPoint(20), players[1]);
		
		System.out.print("\nPlayer 1 buying a road: ");
		players[1].buyRoad(game.getLine(22), players[1]);
		
		System.out.print("\nPlayer 2 buying a city: ");
		players[0].buyCity(game.getPoint(1), players[0]);
		
		System.out.print("\nPlayer 1 attempting to buy city: ");
		players[1].buyCity(game.getPoint(20), players[1]);
		
		System.out.print("\nPlayer 2 attempting to buy road: ");
		players[0].buyRoad(game.getLine(2), players[0]);
		
		System.out.print("\nPlayer 2 attempting to buy settlement: ");
		players[0].buySettlement(game.getPoint(12), players[0]);
	}
}
