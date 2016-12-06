package Utilities;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class HostNetwork {
	public int port;
	public String hostName;
	public String gameName;
	private ServerSocket serverSocket;
	public ArrayList<NetworkThread> clients = new ArrayList<NetworkThread>();
	

	public HostNetwork(int portNumber, String hostName, String gameName) {
		this.port=portNumber;
		this.hostName = hostName;
		this.gameName = gameName;
		
	}
	
	public void Port(int portNumber){
		this.port = portNumber;
	}
	
	public void StartHost() throws IOException{
		serverSocket=new ServerSocket(port);
	}
	
	//adds users to your connection
	public void addClients(int numClients) throws IOException{
		
		for(int i=1; i<=numClients; i++){
			Socket socket = serverSocket.accept();
			NetworkThread t = new NetworkThread(this, socket, i);
			//add this new client to the array of references to these threads
			clients.add(t);
			//start this new thread
			t.start();
			System.out.println(i + " client(s) connected");
		}
	}
	
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
	public void broadcast(Message msg){
		for(int i=0;i<clients.size();i++){
			NetworkThread client = clients.get(i);
			client.writeMsg(msg);
		}
	}

	public static void main(String[] args) throws IOException {
		HostNetwork Host = new HostNetwork(3000,"Jeff","New Game");
		Host.StartHost();
		System.out.println("Server Online"); 
		Host.addClients(2);
		System.out.println("Clients Added");
		Host.broadcast(new Message("Text", "Testing"));              
	}

}
