package Utilities;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class HostNetwork {
	public int port;
	public String hostName;
	public String gameName;
	private ServerSocket serverSocket;
	public ArrayList<ListenThread> clients = new ArrayList<ListenThread>();
	

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
			ListenThread t = new ListenThread(this, socket, i);
			//add this new client to the array of references to these threads
			clients.add(t);
			//start this new thread
			t.start();
			System.out.println(i + " client(s) connected");
		}
	}
	
	public void close() throws IOException{
		for(int i=0;i<clients.size();i++){
			ListenThread client = clients.get(i);
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
			ListenThread client = clients.get(i);
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
		// reading from keyboard (keyRead object)
		//BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		// sending to client (pwrite object)
		//OutputStream ostream = sock.getOutputStream(); 
		//PrintWriter pwrite = new PrintWriter(ostream, true);

		// receiving from server ( receiveRead  object)
		//InputStream istream = sock.getInputStream();
		//BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

		/*String receiveMessage, sendMessage;               
		while(true){
			if((receiveMessage = receiveRead.readLine()) != null)  {
				System.out.println(receiveMessage);         
			}         
			sendMessage = keyRead.readLine(); 
			pwrite.println(sendMessage);             
			pwrite.flush();
		} */              

	}

}
