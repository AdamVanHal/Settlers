package GameBoard;

public class LineNode {
	LineNode[] adjacentLine;
	PointNode[] adjacentPoint;
	PieceNode[] adjacentPiece;
	String occupancy;
	public LineNode(){
		adjacentLine = new LineNode[4];
		adjacentPoint = new PointNode[2];
		adjacentPiece = new PieceNode[2];
		occupancy = "";
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
}
