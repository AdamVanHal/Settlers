/*
*	@file LineNode.java
*	@author Ryan Niday
*	@date 11-1-16
*	@brief a node class to keep track of the lines of the board game
*/
package GameBoard;

import java.io.Serializable;

import infoClasses.Road;

public class LineNode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8142537287777601517L;
	int playerNumber;
	LineNode[] adjacentLine;
	PointNode[] adjacentPoint;
	PieceNode[] adjacentPiece;
	String occupancy;
	Road road;
	/* @pre none
	*  @post a node at a line of the board is created with all variables initialized
	*  @return none
	*/
	public LineNode(){
		adjacentLine = new LineNode[4];
		adjacentPoint = new PointNode[2];
		adjacentPiece = new PieceNode[2];
		occupancy = "";
		road = null;
	}
	/* @pre a is a valid String
	*  @post occupancy is set to a
	*  @return none
	*/
	public void setOccupancy(String a){
		occupancy = a;
	}
	/* @pre a is a valid LineNode, b is a valid LineNode, c is a valid LineNode, d is a valid LineNode
	*  @post an array of a, b, c, and d are set into the array adjacentLine
	*  @return none
	*/
	public void setAdjacentLines(LineNode a,LineNode b,LineNode c,LineNode d){
		adjacentLine[0] = a;
		adjacentLine[1] = b;
		adjacentLine[2] = c;
		adjacentLine[3] = d;
	}
	/* @pre a is a valid PointNode, b is a valid PointNode
	*  @post an array of a, and b are set into the array adjacentPoint
	*  @return none
	*/
	public void setAdjacentPoints(PointNode a,PointNode b){
		adjacentPoint[0] = a;
		adjacentPoint[1] = b;
	}
	/* @pre a is a valid PieceNode, b is a valid PieceNode
	*  @post an array of a, and b are set into the array adjacentPiece
	*  @return none
	*/
	public void setAdjacentPieces(PieceNode a,PieceNode b){
		adjacentPiece[0] = a;
		adjacentPiece[1] = b;
	}
	/* @pre none
	*  @post none
	*  @return occupancy
	*/
	public String getOccupancy(){
		return occupancy;
	}
	/* @pre none
	*  @post none
	*  @return adjacentLine array
	*/
	public LineNode[] getAdjacentLines(){
		return adjacentLine;
	}
	/* @pre none
	*  @post none
	*  @return adjacentPoint array
	*/
	public PointNode[] getAdjacentPoint(){
		return adjacentPoint;
	}
	/* @pre none
	*  @post none
	*  @return adjacentPiece array
	*/
	public PieceNode[] getAdjacentPiece(){
		return adjacentPiece;
	}
	/* @pre a is a valid Road, b is a valid Road array
	*  @post if a road is allowed here, then road is set to a, otherwise none
	*  @return true if road is set, false otherwise
	*/
	public boolean setRoad(Road a,Road[] b){
		if(road == null){
			for(int i = 0; i < 4; i++){
				if(adjacentLine[i] != null && adjacentLine[i].getRoad() != null){
					for(int j = 0; j < 15; j++){
						if(adjacentLine[i] != null && adjacentLine[i].getRoad() == b[j]){
							road = a;
							return true;
						}
					}
				}
			}
			for(int i = 0; i < 2; i++){
				if(adjacentPoint[i].getSettlement() != null){
					if(adjacentPoint[i].getSettlement().getPlayer() == a.getPlayer()){
						road = a;
						return true;
					}
				}
			}
		}
		return false;
	}
	/* @pre none
	*  @post none
	*  @return road
	*/
	public Road getRoad(){
		return road;
	}
	
	public void setPlayerNumber(int a){
		playerNumber = a;
	}
	
	public int getPlayerNumber(){
		return playerNumber;
	}
}
