package Utilities;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ClientNetwork {
	private int port;
	private String hostIP;
	private Socket ServerConnection;
	private NetworkThread Listener;
	
	public ClientNetwork(String HostIP, int HostPort){
		hostIP = HostIP;
		port = HostPort;
	}
	
	public void Change(String HostIP, int HostPort){
		hostIP = HostIP;
		port = HostPort;
	}
	
	public ArrayList<NetworkThread> start() throws UnknownHostException, IOException{
		ServerConnection = new Socket(hostIP,port);
		Listener = new NetworkThread(ServerConnection,0);
		Listener.start();
		ArrayList<NetworkThread> Thread = new ArrayList<NetworkThread>();
		Thread.add(Listener);
		return(Thread);
	}

	public static void main(String[] args) throws Exception {
		ClientNetwork Connection = new ClientNetwork("127.0.0.1", 5000);
		Connection.start();
		
	}

}
