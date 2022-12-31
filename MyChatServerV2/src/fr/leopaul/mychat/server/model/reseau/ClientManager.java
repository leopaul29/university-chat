package fr.leopaul.mychat.server.model.reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import fr.leopaul.mychat.server.controler.listeners.Logger;

public class ClientManager implements Runnable {

	private Socket clientSocket;
	private final Logger logger;
	
	public ClientManager(Socket clientSocket, Logger logger)	{
		this.clientSocket = clientSocket;
		
		this.logger = logger;
	}

	public void execute() {
		logger.log("Client connecté !");

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream());
			String text;

			while (!"/quit".equals(text = in.readLine())) {
				out.println("Serveur accuse réception de : " + text);
				out.flush();
			}

			clientSocket.close();
			logger.log("Client disconnected");
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
