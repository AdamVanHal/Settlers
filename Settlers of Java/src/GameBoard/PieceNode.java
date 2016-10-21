package GameBoard;

public class PieceNode {
	String resource;
	String robber;
	String number;
	public PieceNode(){
		resource = "";
	}
	public void setOccupancy(String a){
		resource = a;
	}
	public String getOccupancy(){
		return resource;
	}
}
