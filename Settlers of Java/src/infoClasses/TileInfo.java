package infoClasses;

import java.util.Scanner;
import java.io.*;

public class TileInfo{
	int dieVal = 0;
	int id = 0;
	int resourceType = 0;
	
	public static void main(String[] args){
	
	}
	
	public static int getDieVal(){return dieVal;}
	public static boolean setDieVal(int inp){inp = dieVal;}
	
	public static int getId(){return id;}
	public static boolean setId(int inp){id = inp;}
	
	public static int getResourceType(){return resourceType;}
	public static boolean setResourceType(int inp){resourceType = inp;}
	
}