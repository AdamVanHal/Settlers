package main;
import java.io.IOException;

import Utilities.*;

public class Test1 {
	HostNetwork Host;
	ClientNetwork Client;
	
	public void runTest(){
		System.out.println("Trying to initialize networking");
		Host = new HostNetwork(4500,"Test","test");
		Client = new ClientNetwork("127.0.0.1",4500);
		System.out.println("Successfully created network objects");
		try {
			Host.StartHost();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Client.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Host.addClients(2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Test1 test = new Test1();
		test.runTest();
	}
}
