package infoClasses;

import GameBoard.PointNode;

public class City {
	PlayerInfo player;
	PointNode location;
	int roll;
	int[] pieceDieVal;
	int[] resource;
	//Creates a Settlements object that initiates all the variables
	public City(PointNode a, PlayerInfo b){
		player = b;
		pieceDieVal = new int[3];
		resource = new int[3];
		location = a;
		for(int i = 0; i < 3; i++){
			if(location.getAdjacentPiece()[i] == null){
				pieceDieVal[i] = 0;
			}
			else{
				pieceDieVal[i] = location.getAdjacentPiece()[i].getTileID();
			}
		}
		for(int i = 0; i < 3; i++){
			if(location.getAdjacentPiece()[i] == null){
				resource[i] = 0;
			}
			else{
				resource[i] = location.getAdjacentPiece()[i].getTileResource();
			}
		}
	}
	public void getResources(int a){
		roll = a;
		for(int i = 0; i < 3; i++){
			if(pieceDieVal[i] == roll){
				if(resource[i] == 1){
					player.setWheat((player.getWheat()+1));
				}
				if(resource[i] == 2){
					player.setWood((player.getWood()+1));
				}
				if(resource[i] == 3){
					player.setSheep((player.getSheep()+1));
				}
				if(resource[i] == 4){
					player.setOre((player.getOre()+1));
				}
				if(resource[i] == 5){
					player.setBrick((player.getBrick()+1));
				}
			}
		}
	}
}
