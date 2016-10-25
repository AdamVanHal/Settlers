package GameBoard;

public class PieceNode {
	String resource;
	String robber;
	int number;
	public PieceNode(){
		resource = "";
	}
	public void setOccupancy(String a){
		resource = a;
	}
	public void setNumber(int a){
		number = a;
	}
	public String getOccupancy(){
		return resource;
	}
	public int getNumber(){
		return number;
	}
}
