package GameBoard;

import infoClasses.TileInfo;

public class PieceNode {
	TileInfo resource;
	String robber;
	int number;
	public PieceNode(){
		resource = new TileInfo();
	}
	public void setTileID(int a){
		resource.setId(a);
	}
	public int getTileID(){
		return resource.getId();
	}
	public void setTileResource(int a){
		resource.setResourceType(a);
	}
	public int getTileResource(){
		return resource.getResourceType();
	}
	public void setNumber(int a){
		number = a;
	}
	public int getNumber(){
		return number;
	}
}
