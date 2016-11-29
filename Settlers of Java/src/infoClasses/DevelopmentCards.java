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
		for(int i = 0; i < 25; i++){
			System.out.print(deck[i] + " ");
		}
		System.out.println();
		deck = rand.randomize(deck);
		for(int i = 0; i < 25; i++){
			System.out.print(deck[i] + " ");
		}
	}
	
	public int[] getDeck(){
		return deck;
	}
}
