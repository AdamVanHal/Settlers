package GameBoard;

public class PointNode {
	LineNode[] adjacentLine;
	PieceNode[] adjacentPiece;
	PointNode[] adjacentPoint;
	String occupancy;
	public PointNode(){
		adjacentLine = new LineNode[3];
		adjacentPiece = new PieceNode[3];
		adjacentPoint = new PointNode[2];
		occupancy = "";
	}
	public void setOccupancy(String a){
		occupancy = a;
	}
	public void setAdjacentLines(LineNode a,LineNode b,LineNode c){
		adjacentLine[0] = a;
		adjacentLine[1] = b;
		adjacentLine[2] = c;
	}

	public void setAdjacentPieces(PieceNode a,PieceNode b,PieceNode c){
		adjacentPiece[0] = a;
		adjacentPiece[1] = b;
		adjacentPiece[2] = c;
	}
	public void setAdjacentPoints(PointNode a,PointNode b){
		adjacentPoint[0] = a;
		adjacentPoint[1] = b;
	}
	public String getOccupancy(){
		return occupancy;
	}
	public LineNode[] getAdjacentLines(){
		return adjacentLine;
	}

	public PieceNode[] getAdjacentPiece(){
		return adjacentPiece;
	}
}
