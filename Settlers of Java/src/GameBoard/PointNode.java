/*
*	@file PointNode.java
*	@author Ryan Niday
*	@date 11-1-16
*	@brief a node class to keep track of the points of the game board
*/
package GameBoard;

import infoClasses.Settlement;
import infoClasses.City;

public class PointNode {
	LineNode[] adjacentLine;
	PieceNode[] adjacentPiece;
	PointNode[] adjacentPoint;
	Settlement settlement;
	City city;
	String occupancy;
	Port port;
	/* @pre none
	*  @post a node at a point of the board is created
	*  @return none
	*/	
	public PointNode(){
		adjacentLine = new LineNode[3];
		adjacentPiece = new PieceNode[3];
		adjacentPoint = new PointNode[3];
		occupancy = "";
	}
	/* @pre a is a valid String
	*  @post occupancy is equal to a
	*  @return none
	*/
	public void setOccupancy(String a){
		occupancy = a;
	}
	/* @pre a is a valid LineNode, b is a valid LineNode, c is a valid LineNode
	*  @post an array of a, b, and c are set into the array adjacentLine
	*  @return none
	*/
	public void setAdjacentLines(LineNode a,LineNode b,LineNode c){
		adjacentLine[0] = a;
		adjacentLine[1] = b;
		adjacentLine[2] = c;
	}
	/* @pre a is a valid PieceNode, b is a valid PieceNode, c is a valid PieceNode
	*  @post an array of a, b, and c are set into the array adjacentPiece
	*  @return none
	*/
	public void setAdjacentPieces(PieceNode a,PieceNode b,PieceNode c){
		adjacentPiece[0] = a;
		adjacentPiece[1] = b;
		adjacentPiece[2] = c;
	}
	/* @pre a is a valid PointNode, b is a valid PointNode, c is a valid PointNode
	*  @post an array of a, b, and c are set into the array adjacentPoint
	*  @return none
	*/
	public void setAdjacentPoints(PointNode a,PointNode b,PointNode c){
		adjacentPoint[0] = a;
		adjacentPoint[1] = b;
		adjacentPoint[2] = c;
	}
	/* @pre none
	*  @post none
	*  @return value of occupancy
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
	*  @return adjacentPiece array
	*/
	public PieceNode[] getAdjacentPiece(){
		return adjacentPiece;
	}
	/* @pre none
	*  @post none
	*  @return adjacentPoint array
	*/
	public PointNode[] getAdjacentPoint(){
		return adjacentPoint;
	}
	/* @pre a is a valid Settlement
	*  @post if a settlement is allowed here, settlement is set to a, otherwise none
	*  @return true is settlement is created, false if settlement is not created
	*/
	public boolean setSettlement(Settlement a){
		for(int i = 0; i < 3; i++){
			if(adjacentPoint[i] == null){
				
			}
			else if(adjacentPoint[i].getSettlement() != null){
				System.out.println("Can't settle adjacent to another settlement.");
				return false;
			}
		}
		if(settlement == null){
			settlement = a;
			return true;
		}
		else{
			System.out.println("Already has a settlement.");
			return false;
		}
	}
	/* @pre none
	*  @post none
	*  @return settlement
	*/
	public Settlement getSettlement(){
		return settlement;
	}
	//checks if a settlement is currently set at this point
	/* @pre none
	*  @post none
	*  @return false if settlement is null, true otherwise
	*/
	public boolean hasSettlement(){
		if(settlement == null){
			return false;
		}
		else{
			return true;
		}
	}
	/* @pre a is a valid City
	*  @post if a city is allowed here, the city is set to a, otherwise none
	*  @return true if city is created, false otherwise
	*/
	public boolean setCity(City a){
		if(hasSettlement()){
			city = a;
			return true;
		}
		else{
			return false;
		}
	}
}
