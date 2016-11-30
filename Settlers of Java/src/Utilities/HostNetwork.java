package Utilities;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class HostNetwork {
	public int port;
	public String hostName;
	public String gameName;
	private ServerSocket serverSocket;
	public ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	

	public HostNetwork(int portNumber, String hostName, String gameName) {
		this.port=portNumber;
		this.hostName = hostName;
		this.gameName = gameName;
		
	}
	
	public void StartHost() throws IOException{
		serverSocket=new ServerSocket(port);
	}
	
	//adds users to your connection
	public void addClients(int numClients) throws IOException{
		
		for(int i=1; i<=numClients; i++){
			Socket socket = serverSocket.accept();
			ClientThread t = new ClientThread(socket);
			clients.add(t);
			System.out.println(i + " client(s) connected");
		}
	}
	
	public void close() throws IOException{
		for(int i=0;i<clients.size();i++){
			ClientThread client = clients.get(i);
			//Kill threads so they are not running anymore
		}
		serverSocket.close();
	}
	
	//send message to all players
	public void broadcast(String Action){
		
	}

	public static void main(String[] args) throws IOException {
		HostNetwork Host = new HostNetwork(3000,"Jeff","New Game");
		Host.StartHost();
		System.out.println("Server Online"); 
		Host.addClients(2);
		System.out.println("Server Online");
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
