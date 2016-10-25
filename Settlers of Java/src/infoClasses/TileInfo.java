package infoClasses;

import java.util.Scanner;
import java.io.*;

public class TileInfo{
	int dieVal = 0;
	int id = 0;
	int resourceType = 0;
	
	public  void main(String[] args){
	
	}
	
	public int getDieVal(){return dieVal;}
	public boolean setDieVal(int inp){inp = dieVal;}
	
	public int getId(){return id;}
	public boolean setId(int inp){id = inp;}
	
	public int getResourceType(){return resourceType;}
	public boolean setResourceType(int inp){resourceType = inp;}
	
}