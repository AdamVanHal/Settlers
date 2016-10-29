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
		for(int i = 0; i < 20; i++){
			int a = d6.roll();
			int b = d6.roll();
			System.out.println(a+b);
			players[1].gatherResources(a+b);
			players[2].gatherResources(a+b);
		}
		System.out.println("Wheat: " + players[1].getWheat());
		System.out.println("Wood: " + players[1].getWood());
		System.out.println("Settlements left: " + players[1].getSet());
		System.out.println("Cities left: " + players[1].getCities());
		System.out.println("Wheat: " + players[2].getWheat());
	}
}
