package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientPrompt {

	public static void main(String[] args)
	{
		ClientPrompt client = new ClientPrompt();
		try
		{
			client.request();
		}catch(Exception e)
		{
			System.out.println("oops");
		}
	}
	
	public void request() throws IOException
	{
		
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			clientSocket = new Socket("localhost", 4444);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
		String fromServer;
		String fromUser;
		
		while ((fromServer = in.readLine()) != null) 
		{

			System.out.println("Server: " + fromServer);
			fromUser = sysin.readLine();
			System.out.println("Client: " + fromUser);
			out.println(fromUser);
		}
		
		out.close();
        in.close();
        sysin.close();
        clientSocket.close();
	}
}
