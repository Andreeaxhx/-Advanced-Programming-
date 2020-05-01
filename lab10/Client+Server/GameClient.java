

import java.io.*;
import java.net.*;

public class GameClient {

	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	
	public GameClient(String address, int port)
	{
		try
		{
			socket = new Socket(address, port);
			System.out.println("Connected!");
			
			input = new DataInputStream(System.in);
			out = new DataOutputStream(socket.getOutputStream());
			
	
		
		
		String line = "";
		
		while(!line.contentEquals("stop"))
		{
			try
			{
				line = input.readLine();
				out.writeUTF(line);
			}
			catch(IOException i)
			{
				System.out.println(i);
			}
		}
		
		System.out.println("Program stopped!");
		System.out.println("Closing connection");
		
			socket.close();
			input.close();
			out.close();
			
	}catch(UnknownHostException u) 
		{System.out.println(u);}
		catch(IOException i)
		{System.out.println(i);}
	}
		
	
	
	public static void main(String args[])
	{
		GameClient client = new GameClient("127.0.0.1", 5000);
	}
}
