package Utilities;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientThread extends Thread {
	// the socket where to listen/talk
	Socket socket;
	ObjectInputStream sInput;
	ObjectOutputStream sOutput;
	// my unique id (easier for deconnection)
	int id;
	// the Username of the Client
	String username;
	// the only type of message a will receive
	//ChatMessage cm;
	// the date I connect
	String date;

	// Constructore
	ClientThread(Socket socket) {
		// a unique id
		id = 7;//++uniqueId;
		this.socket = socket;
		/* Creating both Data Stream */
		System.out.println("Thread trying to create Object Input/Output Streams");
		try
		{
			// create output first
			sOutput = new ObjectOutputStream(socket.getOutputStream());
			sInput  = new ObjectInputStream(socket.getInputStream());
			// read the username
			username = (String) sInput.readObject();
			System.out.println(username + " just connected.");
		}
		catch (IOException e) {
			System.out.println("Exception creating new Input/output Streams: " + e);
			return;
		}
		// have to catch ClassNotFoundException
		// but I read a String, I am sure it will work
		catch (ClassNotFoundException e) {
		}
        date = new Date().toString() + "\n";
	}

	// what will run forever
	public void run() {
		// to loop until LOGOUT
		boolean keepGoing = true;
		while(keepGoing) {
			// read a String (which is an object)
			try {
				//cm = (ChatMessage) sInput.readObject();
				String test = (String) sInput.readObject();
			}
			catch (IOException e) {
				System.out.println(username + " Exception reading Streams: " + e);
				break;				
			}
			catch(ClassNotFoundException e2) {
				break;
			}
			// the message part of the ChatMessage
			/*String message = cm.getMessage();

			// Switch on the type of message receive
			switch(cm.getType()) {

			case ChatMessage.MESSAGE:
				broadcast(username + ": " + message);
				break;
			case ChatMessage.LOGOUT:
				display(username + " disconnected with a LOGOUT message.");
				keepGoing = false;
				break;
			case ChatMessage.WHOISIN:
				writeMsg("List of the users connected at " + sdf.format(new Date()) + "\n");
				// scan al the users connected
				for(int i = 0; i < al.size(); ++i) {
					ClientThread ct = al.get(i);
					writeMsg((i+1) + ") " + ct.username + " since " + ct.date);
				}
				break;
			}*/
		}
		// remove myself from the arrayList containing the list of the
		// connected Clients
		//remove(id);
		close();
	}
	
	// try to close everything
	private void close() {
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
	 * Write a String to the Client output stream
	 */
	private boolean writeMsg(String msg) {
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
