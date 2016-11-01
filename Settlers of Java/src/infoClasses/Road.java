/*
*	@file Road.java
*	@author Ryan Niday
*	@date 11-1-16
*	@brief a class to represent the roads a player creates in catan
*/
package infoClasses;

import GameBoard.LineNode;

public class Road {
	PlayerInfo player;
	LineNode location;
	
	/* @pre a is a valid LineNode, b is a valid PlayerInfo
	*  @post a Road object is created with variables initialized to appropriate values
	*  @return none
	*/
	public Road(LineNode a,PlayerInfo b){
		player = b;
		location = a;
	}
	
	/* @pre none
	*  @post none
	*  @return player
	*/
	public PlayerInfo  getPlayer(){
		return player;
	}
}
