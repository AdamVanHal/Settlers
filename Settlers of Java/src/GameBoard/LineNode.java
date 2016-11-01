package GameBoard;

import infoClasses.Road;

public class LineNode {
	LineNode[] adjacentLine;
	PointNode[] adjacentPoint;
	PieceNode[] adjacentPiece;
	String occupancy;
	Road road;
	public LineNode(){
		adjacentLine = new LineNode[4];
		adjacentPoint = new PointNode[2];
		adjacentPiece = new PieceNode[2];
		occupancy = "";
		road = null;
	}
	public void setOccupancy(String a){
		occupancy = a;
	}
	public void setAdjacentLines(LineNode a,LineNode b,LineNode c,LineNode d){
		adjacentLine[0] = a;
		adjacentLine[1] = b;
		adjacentLine[2] = c;
		adjacentLine[3] = d;
	}
	public void setAdjacentPoints(PointNode a,PointNode b){
		adjacentPoint[0] = a;
		adjacentPoint[1] = b;
	}
	public void setAdjacentPieces(PieceNode a,PieceNode b){
		adjacentPiece[0] = a;
		adjacentPiece[1] = b;
	}
	public String getOccupancy(){
		return occupancy;
	}
	public LineNode[] getAdjacentLines(){
		return adjacentLine;
	}
	public PointNode[] getAdjacentPoint(){
		return adjacentPoint;
	}
	public PieceNode[] getAdjacentPiece(){
		return adjacentPiece;
	}
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
	public Road getRoad(){
		return road;
	}
}
