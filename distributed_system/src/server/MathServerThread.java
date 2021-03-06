package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MathServerThread extends Thread {

	private Socket socket = null;
	
	public MathServerThread(Socket sock)
	{
		super("localhost");
		this.socket = sock;
	}
	
	public void run()
	{
		try
		{
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	        BufferedReader in = new BufferedReader(
	                    new InputStreamReader(
	                    socket.getInputStream()));
	 
	        String inputLine, outputLine;
	        
	        MathProtocol mp = new MathProtocol();
	        outputLine = mp.processInput(null);
	        out.println(outputLine);
	 
	        while ((inputLine = in.readLine()) != null) 
	        {
		        outputLine = mp.processInput(inputLine);
		        out.println(outputLine);
		        if (outputLine.equals("Bye"))
		            break;
	        }
	      
	        out.close();
	        in.close();
	        
	        socket.close();
		}
		catch(Exception e)
		{
			System.out.println("whoops");
			e.printStackTrace();
		}
	}
}