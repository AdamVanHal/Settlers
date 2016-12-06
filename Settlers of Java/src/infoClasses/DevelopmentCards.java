package infoClasses;

import Utilities.Randomizer;

public class DevelopmentCards {
	int[] deck;
	Randomizer rand;
	public DevelopmentCards(){
		deck  = new int[25];
		rand = new Randomizer();
		for(int i = 0; i < 25; i++){
			if(i<14){
				deck[i] = 1;
			}
			else if(i<19){
				deck[i] = 2;
			}
			else if(i<21){
				deck[i] = 3;
			}
			else if(i<23){
				deck[i] = 4;
			}
			else if(i<25){
				deck[i] = 5;
			}
		}
		deck = rand.randomize(deck);
		int[] tempArr = new int[26];
		for(int i = 0; i < 26; i++){
			tempArr[i] = deck[i];
		}
		tempArr[26] = 0;
		deck = tempArr;
	}
	
	public int[] getDeck(){
		return deck;
	}
	public void setDeck(int[] newDeck){
		deck = newDeck;
	}
}
