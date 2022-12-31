package fr.leopaul.mychat.server.model.reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientManager implements Runnable {

	private Socket clientSocket;
	
	public ClientManager(Socket clientSocket)	{
		this.clientSocket = clientSocket;
	}

	public void execute() {
		System.out.println("Client connecté !");

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream());
			String text;

			while (!"exit".equals(text = in.readLine())) {
				System.out.println("Text : " + text);
				out.println("Serveur accuse réception de : " + text);
				out.flush();
			}

			clientSocket.close();
			System.out.println("Client disconnected");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				clientSocket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}		
	}

	@Override
	public void run() {
		execute();
	}
}
