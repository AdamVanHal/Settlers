package infoClasses;

import GameBoard.LineNode;

public class Road {
	PlayerInfo player;
	LineNode location;
	
	public Road(LineNode a,PlayerInfo b){
		player = b;
		location = a;
	}
	
	public PlayerInfo  getPlayer(){
		return player;
	}
}
