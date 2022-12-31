package fr.leopaul.serverMultiClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer {

	private ServerSocket serverSocket;
	private int port;

	public MultithreadedServer(int port) {
		this.port = port;
	}

	private void execute() {
		try {
			this.serverSocket = new ServerSocket(port);

			System.out.println("En attente de connection");

			Socket socket;
			while ((socket = this.serverSocket.accept()) != null) {
				ClientManager clientManager = new ClientManager(socket);
				Thread thread = new Thread(clientManager);
				thread.start();
			}

		} catch (IOException e) {
			System.out.println("Server error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		int port = 45000;
		MultithreadedServer server = new MultithreadedServer(port);
		server.execute();
	}
}
