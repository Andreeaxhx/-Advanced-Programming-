import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class GameServer {
	
	private ServerSocket server = null;
	
	//ArrayList<ClientThread> connections = new ArrayList<ClientThread>();
	boolean shouldRun = true;
	
	//private Socket socket = null;
	//private DataInputStream in = null;
	//private DataOutputStream out = null; 
	
	public GameServer (int port)
	{
		try
		{
			server = new ServerSocket(port);
			while(shouldRun) 
			{
			
			System.out.println("Server started!");
			
			System.out.println("Waiting for a client...");
			
			Socket s = server.accept();
			
			new ClientThread(s).start();
			
			//ClientThread sc = new ClientThread(s, this);
			//sc.start();
			//connections.add(sc);
			//socket = server.accept();
			//System.out.println("Client accepted!");
			}
			} catch (IOException e)
			{
				e.printStackTrace();
			} finally {
				 try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }

			
			
			
			/*in = new DataInputStream(
					new BufferedInputStream(socket.getInputStream()));
			out = new DataOutputStream(
					new BufferedOutputStream(socket.getOutputStream()));
			*/
			/*String line = "";
			
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
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}
	*/
	}	
	public static void main(String args[])
	{
		GameServer server = new GameServer(5000);
	}
	
	
}
	

