/*
*	@file TileInfo.java
*	@author Stuart Wreath
*	@date 11-1-16
*	@brief a class that controls the resource value, and number on the tiles of the game board
*/
package infoClasses;

import java.io.Serializable;

public class TileInfo implements Serializable{
	int dieVal = 0;
	int id = 0;
	int resourceType = 0;
	
	public static void main(String[] args){
	
	}
	
	public int getDieVal(){return dieVal;}
	public boolean setDieVal(int inp){inp = dieVal; return true;}
	
	public int getId(){return id;}
	public boolean setId(int inp){id = inp; return true;}
	
	public int getResourceType(){return resourceType;}
	public boolean setResourceType(int inp){resourceType = inp; return true;}
	
}