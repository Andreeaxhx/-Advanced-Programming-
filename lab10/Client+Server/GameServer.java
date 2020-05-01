import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class GameServer {
	
	private ServerSocket server = null;
	private Socket socket = null;
	private DataInputStream in = null;
	//private DataOutputStream out = null; 
	
	public GameServer (int port)
	{
		try
		{
			server = new ServerSocket(port);
			
			System.out.println("Server started!");
			
			System.out.println("Waiting for a client...");
			
			socket = server.accept();
			System.out.println("Client accepted!");
			
			
			//new ClientThread(socket).start();
			
			in = new DataInputStream(
					new BufferedInputStream(socket.getInputStream()));
			//out = new DataOutputStream(
				//	new BufferedOutputStream(socket.getOutputStream()));
			
			String line = "";
			
			while(!line.equals("stop"))
			{
				try
				{
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
			System.out.println("Program stopped!");
			System.out.println("Closing connection");
			
			socket.close();
			in.close();
			
	
	}	catch(IOException i)
		{
		System.out.println(i);
	}
		}
	public static void main(String args[])
	{
		GameServer server = new GameServer(5000);
	}
	
	
}
	

