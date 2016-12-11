package Utilities;

import java.io.Serializable;
import java.util.Random;

public class Randomizer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6236884773759400834L;

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
