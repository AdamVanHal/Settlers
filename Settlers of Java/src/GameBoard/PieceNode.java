/*
*	@file PieceNode.java
*	@author Ryan Niday
*	@date 11-1-16
*	@brief a node class to keep track of the pieces of the game board
*/
package GameBoard;

import java.io.Serializable;

import infoClasses.TileInfo;

public class PieceNode implements Serializable{
	TileInfo resource;
	Boolean robber;
	int number;
	/* @pre none
	*  @post a node for a given piece of the board is created containing a TileInfo object as resource
	*  @return none
	*/
	public PieceNode(){
		resource = new TileInfo();
		robber = false;
	}
	/* @pre a is a valid int
	*  @post a is set into resource
	*  @return none
	*/
	public void setTileID(int a){
		resource.setId(a);
	}
	/* @pre none
	*  @post none
	*  @return the tile ID from resource
	*/
	public int getTileID(){
		return resource.getId();
	}
	/* @pre a is a valid int
	*  @post a is set into resource
	*  @return none
	*/
	public void setTileResource(int a){
		resource.setResourceType(a);
	}
	/* @pre none
	*  @post none
	*  @return the tile resource type identifier from resource
	*/
	public int getTileResource(){
		return resource.getResourceType();
	}
	/* @pre a is a valid int
	*  @post number is set to a
	*  @return none
	*/
	public void setNumber(int a){
		number = a;
	}
	/* @pre none
	*  @post none
	*  @return number
	*/
	public int getNumber(){
		return number;
	}
	
	public void setRobber(boolean a){
		robber = a;
	}
	
	public boolean getRobber(){
		return robber;
	}
}
