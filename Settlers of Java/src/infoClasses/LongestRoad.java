package infoClasses;

import GameBoard.LineNode;

public class LongestRoad {
	int longest;
	int current;
	PlayerInfo[] players;
	LineNode[] consecutiveRoad;
	public LongestRoad(PlayerInfo[] a){
		longest = 5;
		players = a;
		consecutiveRoad = new LineNode[15];
	}
	
	public void setRoadArray(LineNode a){
		for(int i = 0; i < 15; i++){
			if(consecutiveRoad[i] == null){
				consecutiveRoad[i] = a;
				current++;
				return;
			}
		}
	}
	
	public boolean checkRoad(PlayerInfo player){
		if(current < longest){
			consecutiveRoad = new LineNode[15];
			current = 0;
			return false;
		}
		else{
			for(int i = 0; i < 15; i++){
				if(consecutiveRoad[i+1] == null){
					consecutiveRoad = new LineNode[15];
					longest = current;
					current = 0;
					return true;
				}
				else if(checkAdjacency(player,consecutiveRoad[i],consecutiveRoad[i+1])){
					
				}
				else{
					consecutiveRoad = new LineNode[15];
					current = 0;
					return false;
				}
			}
		}
		consecutiveRoad = new LineNode[15];
		current = 0;
		return false;
	}
	
	public boolean checkAdjacency(PlayerInfo player, LineNode road1, LineNode road2){
		if(road1.getRoad().getPlayer() == player && road2.getRoad().getPlayer() == player){
			for(int i = 0; i < 4; i++){
				if(road1.getAdjacentLines()[i] == null){
					return false;
				}
				else if(road1.getAdjacentLines()[i] == road2){
					return true;
				}
			}
		}
		else{
			return false;
		}
		return false;
	}
}
