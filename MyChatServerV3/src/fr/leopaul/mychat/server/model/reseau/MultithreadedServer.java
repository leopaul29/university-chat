package fr.leopaul.mychat.server.model.reseau;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer implements Runnable {

	private ServerSocket serverSocket;
	private int port = 45000;
	private Socket socket;

	public MultithreadedServer() {
	}

	public void start() {
		Thread t = new Thread(this);
		t.start();
		System.out.println("Server start");
	}

	public void stop() {
		System.out.println("Server stop");
	}

	@Override
	public void run() {
		try {
			this.serverSocket = new ServerSocket(port);

			System.out.println("En attente d'une prochaine connection");

			while ((this.socket = this.serverSocket.accept()) != null) {
				ClientManager clientManager = new ClientManager(socket);
				Thread thread = new Thread(clientManager);
				thread.start();
			}

		} catch (IOException e) {
			System.out.println("Server error");
			e.printStackTrace();
		} finally {
			try {
				this.socket.close();
				this.serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
