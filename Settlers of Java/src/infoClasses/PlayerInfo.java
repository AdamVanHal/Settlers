package infoClasses;

import java.util.Scanner;
import java.io.*;

public class PlayerInfo{
	int VP = 0;
	int Pvp = 0;
	int Road = 0;
	int Wheat = 0;
	int Sheep = 0;
	int Ore = 0;
	int Brick = 0;
	int Wood = 0;
	int Set = 0;
	int Cities = 0;
	int Knights = 0;
	int Dev = 0;
	boolean longestRoad = false;

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		String str = "";
		int choice = 1000;
		int date = 0;
		while(choice != 0){
			System.out.println("-------------------------");
			System.out.println("1.getVP 		2.calcVP\n"			+
								"3.getPvp		4.calcPvp\n"		+
								"5.getRoad		6.setRoad\n"		+
								"7.getWheat		8.setWheat\n"		+
								"9.getSheep		10.setSheep\n"		+
								"11.getOre		12.setOre\n"		+
								"13.getBrick		14.setBrick\n"	+
								"15.getWood		16.setWood\n"		+
								"17.getSet		18.setSet\n"		+
								"19.getCities		20.setCities\n"	+
								"21.getKnights		22.setKnights\n"+
								"23.getDev		24.setDev\n");
			choice = kb.nextInt();
		}
	}
	
	//*****
	//actual victory points methods
	//*****
	public static int getVP(){
		return VP;
	}
	public static boolean calcVP(){
		
	}
	
	//*****
	//public victory points methods
	//*****
	public static int Pvp(){
			return Pvp;
	}
	public static boolean calcPvp(){
		
	}
	
	//*****
	//road get and set methods
	//*****
	public static int getRoad(){return Road;}
	public stativ boolean setRoad(int inp){Road = inp;}
	public static boolean longestRoad(boolean inp){longestRoad = inp;}
	
	//*****
	//wheat get and set methods
	//*****
	public static int getWheat(){return Wheat;}
	public static boolean setWheat(int inp){Wheat = inp;}
	
	//*****
	//Sheep get and set methods
	//*****
	public static int getSheep(){return Sheep;}
	public static boolean setSheep(int inp){Sheep = inp;}
	
	//*****
	//Ore get and set methods
	//*****
	public static int getOre(){return Ore;}
	public static boolean setOre(int inp){Ore = inp;}
	
	//*****
	//Brick get and set methods
	//*****
	public static int getBrick(){return Brick;}
	public static boolean setBrick(int inp){Brick = inp;}
	
	//*****
	//Wood get and set methods
	//*****
	public static int getWood(){return Wood;}
	public static boolean setWood(int inp){Wood = inp;}
	
	//*****
	//Settlement get and set methods
	//*****
	public static int getSet(){return Set;}
	public static boolean setSet(int inp){Set = inp;}
	
	//*****
	//Cities get and set methods
	//*****
	public static int getCities(){return Cities;}
	public static boolean setCities(int inp){Cities = inp;}
	
	//*****
	//Knight get and set methods
	//*****
	public static int getKnights(){return Knights;}
	public static boolean setKnights(int inp){Knights = inp;}
	
	//*****
	//get and set methods for number of development cards
	//*****
	public static int getDev(){return Dev;}
	public static boolean setDev(int inp){Dev = inp;}
	
	
}	
