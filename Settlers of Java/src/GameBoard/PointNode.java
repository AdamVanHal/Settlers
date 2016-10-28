package GameBoard;

import infoClasses.Settlement;

public class PointNode {
	LineNode[] adjacentLine;
	PieceNode[] adjacentPiece;
	PointNode[] adjacentPoint;
	Settlement settlement;
	String occupancy;
	public PointNode(){
		adjacentLine = new LineNode[3];
		adjacentPiece = new PieceNode[3];
		adjacentPoint = new PointNode[3];
		occupancy = "";
	}
	//Sets location number as a string. Not actually useful for anything besides some testing
	public void setOccupancy(String a){
		occupancy = a;
	}
	//Creates an array of of the three adjacent lines to the point
	public void setAdjacentLines(LineNode a,LineNode b,LineNode c){
		adjacentLine[0] = a;
		adjacentLine[1] = b;
		adjacentLine[2] = c;
	}
	//Creates an array of the three pieces adjacent to the point
	public void setAdjacentPieces(PieceNode a,PieceNode b,PieceNode c){
		adjacentPiece[0] = a;
		adjacentPiece[1] = b;
		adjacentPiece[2] = c;
	}
	//Creates an array of the three points adjacent to the point
	public void setAdjacentPoints(PointNode a,PointNode b,PointNode c){
		adjacentPoint[0] = a;
		adjacentPoint[1] = b;
		adjacentPoint[2] = c;
	}
	//Gets the almost useless location number set as a string for who knows why
	public String getOccupancy(){
		return occupancy;
	}
	//Gets the array of adjacent lines
	public LineNode[] getAdjacentLines(){
		return adjacentLine;
	}
	//Gets the array of adjacent pieces
	public PieceNode[] getAdjacentPiece(){
		return adjacentPiece;
	}
	//Gets the array of adjacent points
	public PointNode[] getAdjacentPoint(){
		return adjacentPoint;
	}
	//Sets a settlement on the point and prevents from any overlapping settlements
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
	
	public Settlement getSettlement(){
		return settlement;
	}
}
