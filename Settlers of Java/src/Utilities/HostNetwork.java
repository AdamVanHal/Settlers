package Utilities;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class HostNetwork {
	private int port;
	private String hostName;
	private String gameName;
	private ServerSocket serverSocket;
	public ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	

	public HostNetwork(int portNumber, String hostName, String gameName) throws IOException{
		this.port=portNumber;
		this.hostName = hostName;
		this.gameName = gameName;
		serverSocket=new ServerSocket(port);
		
	}
	
	//adds users to your connection
	public void addUsers(int numPlayers) throws IOException{
		
		for(int i=0; i>numPlayers; i++){
			Socket socket = serverSocket.accept();
			ClientThread t = new ClientThread(socket);
		}
	}

	public static void main(String[] args) throws IOException {
		ServerSocket sersock = new ServerSocket(3000);
		System.out.println("Server  ready for chatting");
		Socket sock = sersock.accept( );                          
		// reading from keyboard (keyRead object)
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		// sending to client (pwrite object)
		OutputStream ostream = sock.getOutputStream(); 
		PrintWriter pwrite = new PrintWriter(ostream, true);

		// receiving from server ( receiveRead  object)
		InputStream istream = sock.getInputStream();
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

		String receiveMessage, sendMessage;               
		while(true){
			if((receiveMessage = receiveRead.readLine()) != null)  {
				System.out.println(receiveMessage);         
			}         
			sendMessage = keyRead.readLine(); 
			pwrite.println(sendMessage);             
			pwrite.flush();
		}               

	}

}
