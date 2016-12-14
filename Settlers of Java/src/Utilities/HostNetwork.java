package Utilities;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

//class that sets up the server side of the network connection
public class HostNetwork {
	public int port;
	public String hostName;
	public String gameName;
	private ServerSocket serverSocket;
	public ArrayList<NetworkThread> clients = new ArrayList<NetworkThread>();
	
//constructor to initialize a new network connection to start a game
	public HostNetwork(int portNumber, String hostName, String gameName) {
		this.port=portNumber;
		this.hostName = hostName;
		this.gameName = gameName;
	}
	
	//to change the port the game is on, only before starting the server
	public void Port(int portNumber){
		this.port = portNumber;
	}
	//starts the server so that clients can connect
	public void StartHost() throws IOException{
		serverSocket=new ServerSocket(port);
	}
	
	//adds users to your connection
	//blocks each time until a new client is added
	//spins up a fresh thread to hold the client in
	public void addClients(int numClients) throws IOException{
		for(int i=1; i<=numClients; i++){
			Socket socket = serverSocket.accept();
			NetworkThread t = new NetworkThread(this, socket, i);
			//add this new client to the array of references to these threads
			clients.add(t);
			//start this new thread
			t.start();
			System.out.println(i + " client(s) connected");
			t.writeMsg(new Message("Set ID", Integer.valueOf(i)));
		}
	}
	
	//closes the server and emptys the array that stores the client thread references
	public void close() throws IOException{
		for(int i=0;i<clients.size();i++){
			NetworkThread client = clients.get(i);
			//Kill threads so they are not running anymore
			client.close();
		}
		//empty the client list
		clients.clear();
		serverSocket.close();
	}
	
	//send message to all players
	public boolean broadcast(Message msg){
		for(int i=0;i<clients.size();i++){
			NetworkThread client = clients.get(i);
			client.writeMsg(msg);
		}
		return true;
	}
	
	//stand alone testing remnant
	public static void main(String[] args) throws IOException {
		HostNetwork Host = new HostNetwork(3000,"Jeff","New Game");
		Host.StartHost();
		System.out.println("Server Online"); 
		Host.addClients(2);
		System.out.println("Clients Added");
		Host.broadcast(new Message("Text", "Testing"));              
	}

}
