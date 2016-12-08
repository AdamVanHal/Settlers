package Utilities;

import java.io.*;
import java.net.*;
//give Thread access to play window so that thread can update game state as needed
import gui.PlayWindow;
import GameBoard.GameBoard;


public class NetworkThread extends Thread {
	// the socket where to listen/talk
	private Socket socket;
	private ObjectInputStream sInput;
	private ObjectOutputStream sOutput;
	public int playerID;
	// the Username of the Client
	private String username;
	//connection back to the host object so that the Listener can relay all messages in the network
	private HostNetwork Host;
	//Type identifies this as a listener on the host or on the client so it knows if it needs to relay messages after acting on them
	private String Type;
	private PlayWindow GameState;

	// Constructor for host side
	NetworkThread(HostNetwork Host, Socket socket, int UniqueID) {
		this.Host = Host;
		Type = "Host";
		// a unique id
		playerID = UniqueID;
		this.socket = socket;
		/* Creating both Data Stream */
		System.out.println("Thread trying to create Object Input/Output Streams");
		try
		{
			// create output first
			sOutput = new ObjectOutputStream(socket.getOutputStream());
			sInput  = new ObjectInputStream(socket.getInputStream());
			//tell player what his id is
			this.writeMsg(new Message("Set ID", playerID));
			//System.out.println(username + " just connected.");
		}
		catch (IOException e) {
			System.out.println("Exception creating new Input/output Streams: " + e);
			return;
		}
	}

	// Constructor for Client side
	NetworkThread(Socket socket, int UniqueID) {
		Type = "Client";
		// a unique id
		playerID = UniqueID;
		this.socket = socket;
		/* Creating both Data Stream */
		System.out.println("Thread trying to create Object Input/Output Streams");
		try
		{
			// create output first
			sOutput = new ObjectOutputStream(socket.getOutputStream());
			sInput  = new ObjectInputStream(socket.getInputStream());
			
		}
		catch (IOException e) {
			System.out.println("Exception creating new Input/output Streams: " + e);
			return;
		}
	}
	
	public void gameReference(PlayWindow Game){
		this.GameState = Game;
	}
	
	// This loop will run forever listening for messages
	public void run() {
		// to loop until LOGOUT
		boolean keepGoing = true;
		while(keepGoing) {
			Message msg;
			try {
				msg = (Message) sInput.readObject();
			}
			catch (IOException e) {
				System.out.println(username + " Exception reading Streams: " + e);
				break;				
			}
			catch(ClassNotFoundException e2) {
				break;
			}
			//if this is the server side listener, copy this message to all other clients
			if(this.Type == "Host"){
				this.Host.broadcast(msg);
			}
			//Switch on the type of message received
			switch(msg.Type) {

			case "Text":
				//if this is a text message, print the first arg from the objects list
				System.out.println((String) msg.Objects[0]);
				break;
			case "Set ID":
				this.playerID = (int) msg.Objects[0];
				break;
			case "Drop Client":
				//client is leaving the game
				break;
			case "Set User Name":
				//Set the user name
				break;
			case "initialize":
				GameState.initialize((GameBoard)msg.Objects[0]);
				System.out.println("initialize");
				break;
			}
		}//end while loop
		close();
	}
	
	// try to close everything
	public void close() {
		// try to close the connection
		try {
			if(sOutput != null) sOutput.close();
		}
		catch(Exception e) {}
		try {
			if(sInput != null) sInput.close();
		}
		catch(Exception e) {};
		try {
			if(socket != null) socket.close();
		}
		catch (Exception e) {}
	}

	/*
	 * Write a String to the output stream
	 */
	public boolean writeMsg(Message msg) {
		// if Client is still connected send the message to it
		if(this.Type == "Host"){
			this.Host.broadcast(msg);
			return true;
		}
		if(!socket.isConnected()) {
			close();
			return false;
		}
		
		// write the message to the stream
		try {
			sOutput.writeObject(msg);
		}
		// if an error occurs, do not abort just inform the user
		catch(IOException e) {
			System.out.println("Error sending message to " + username);
			System.out.println(e.toString());
		}
		return true;
	}
	
	public boolean Broadcast(Message msg) {
		// if Client is still connected send the message to it
		if(!socket.isConnected()) {
			close();
			return false;
		}
		
		// write the message to the stream
		try {
			sOutput.writeObject(msg);
		}
		// if an error occurs, do not abort just inform the user
		catch(IOException e) {
			System.out.println("Error sending message to " + username);
			System.out.println(e.toString());
		}
		return true;
	}
}
