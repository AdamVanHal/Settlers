package Utilities;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

//class to set up a client connection to a running host
public class ClientNetwork {
	private int port;
	private String hostIP;
	private Socket ServerConnection;
	private NetworkThread Listener;
	
	//initialize a new client object
	public ClientNetwork(String HostIP, int HostPort){
		hostIP = HostIP;
		port = HostPort;
	}
	
	//change the port (before trying to connect)
	public void Change(String HostIP, int HostPort){
		hostIP = HostIP;
		port = HostPort;
	}
	
	//initiates a connection to a host on this port and IP address that is waiting for new clients
	//creates and returns a thread that holds this connection
	public ArrayList<NetworkThread> start() throws UnknownHostException, IOException{
		ServerConnection = new Socket(hostIP,port);
		Listener = new NetworkThread(ServerConnection,0);
		Listener.start();
		ArrayList<NetworkThread> Thread = new ArrayList<NetworkThread>();
		Thread.add(Listener);
		return(Thread);
	}
	
	//remnant from stand-alone testing
	public static void main(String[] args) throws Exception {
		ClientNetwork Connection = new ClientNetwork("127.0.0.1", 5000);
		Connection.start();
		
	}

}
