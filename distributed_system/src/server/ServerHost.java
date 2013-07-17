package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerHost {

	public static void main(String[] args)
	{
		ServerHost serv = new ServerHost();
		try {
			serv.RunServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void RunServer() throws IOException
	{
		ServerSocket server = new ServerSocket(4444);
		boolean listening = true;
		while(listening)
		{
			new MathServerThread(server.accept()).start();
		}
		server.close();
	}
	
}
