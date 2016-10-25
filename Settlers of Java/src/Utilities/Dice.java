package Utilities;
/* 
 * File Name: Dice.java
 * Author: Ryan Niday
 * KUID: 2820010
 * Email Address: ryanniday@ku.edu
 * Homework Assignment Number: 4
 * Description: This program creates the Dice class used by both the Pokemon class and Colosseum
 * 				class. In this class, a die is created based on a declared number of sides, and
 * 				randomly rolls a number as if a physical die was being rolled
 * Last Change: November 16, 2015
 */
import java.util.Random;
public class Dice {
	private final int sides;			//this variable holds the number of sides the declared die will have
	private Random dice;				//this variable holds the random class imported into this class
	//The constructor takes in a number and sets it as the sides of the die, and also creates a new instance of the random class	
	public Dice(int sides){
		this.sides = sides;
		dice = new Random();
	}
	//This method uses the declared random class and input number to simulate rolling a die with sides equal to the input number
	public int roll(){
		return dice.nextInt(sides)+1;
	}//a randomly selected number within the parameters is output
}
