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
	public void addUsers(int numClients) throws IOException{
		
		for(int i=1; i>numClients; i++){
			Socket socket = serverSocket.accept();
			ClientThread t = new ClientThread(socket);
			clients.add(t);
			System.out.println(i + " client(s) connected");
		}
	}

	public static void main(String[] args) throws IOException {
		HostNetwork Host = new HostNetwork(3000,"Jeff","New Game");
		Host.StartHost();
		System.out.println("Server Online"); 
		Host.addUsers(2);
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
