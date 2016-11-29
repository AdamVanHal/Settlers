package Utilities;

import java.util.Random;

public class Randomizer {
	public Randomizer(){
		
	}
	
	public int[] randomize(int[] arr){
		 Random rnd = new Random();
		    for (int i = arr.length - 1; i > 0; i--)
		    {
		      int index = rnd.nextInt(i + 1);
		      int a = arr[index];
		      arr[index] = arr[i];
		      arr[i] = a;
		    }
		    return arr;
	}
}
