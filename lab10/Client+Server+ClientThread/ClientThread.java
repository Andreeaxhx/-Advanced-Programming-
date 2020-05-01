import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
 private Socket socket = null ;
 public ClientThread (Socket socket) { this.socket = socket ; }
 public void run () {
 try {
	 DataInputStream in = new DataInputStream(
				new BufferedInputStream(socket.getInputStream()));
 // Get the request from the input stream: client -> server
 /*BufferedReader in = new BufferedReader(
		 new InputStreamReader(socket.getInputStream()));*/
 
 String request = in.readLine();
 
 String line = "";
 while(!line.equals("stop"))
	{
		try
		{
			System.out.println(request);
			line = in.readUTF();
			//if(line!="stop")
				System.out.println("Server received the request: " + line);
			//else if(line=="stop")System.out.println("Program stopped!");
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}
 // Send the response to the oputput stream: server -> client
// PrintWriter out = new PrintWriter(socket.getOutputStream());
 //String raspuns = "Hello " + request + "!";
 System.out.println("Program stopped!");
	System.out.println("Closing connection");
 //out.println(raspuns);
 //out.flush();
 } catch (IOException e) {
 
	 System.err.println("Communication error... " + e);
 
 } finally {
 
 try {
	socket.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} // or use try-with-resources
 }
 }
}

/*
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
 
	private Socket socket = null ;
	DataInputStream in;
	DataOutputStream out;
	boolean shouldRun = true;
	GameServer server;
	

	public ClientThread (Socket socket, GameServer server) { 
		super("servConnThread");
		this.socket = socket ; }
	
	public void sendStringToClient(String text) {
		try {
			out.writeUTF(text);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendStringToAllClients(String text) {
		for(int index=0; index<server.connections.size(); index++)
		{
			ClientThread sc = server.connections.get(index);
			sc.sendStringToClient(text);
		}
		
	}
	
 
	public void run () {
 
		try {
			in = new DataInputStream(
					new BufferedInputStream(socket.getInputStream()));
			out = new DataOutputStream(
					new BufferedOutputStream(socket.getOutputStream()));
			
			while(shouldRun) {
				
				String textIn = in.readUTF();
				sendStringToAllClients(textIn); {}
			}
			in.close();
			out.close();
			socket.close();
 // Get the request from the input stream: client -> server
 
			/*BufferedReader in = new BufferedReader(
 
					new InputStreamReader(socket.getInputStream()));
 
			String request = in.readLine();
 // Send the response to the oputput stream: server -> client
 
			PrintWriter out = new PrintWriter(socket.getOutputStream());
 
			String raspuns = "Hello " + request + "!";

			out.println(raspuns);
 
			out.flush();*/
 
		/*} catch (IOException e) {

			System.err.println("Communication error... " + e);
 
		} finally {
 
			try {
 
				socket.close(); // or use try-with-resources
 
			} catch (IOException e) { System.err.println (e); }
 
		}
 }
}*/