package fr.leopaul.mychat.server.model.reseau;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer implements Runnable {

	private ServerSocket serverSocket;
	private int port;
	private boolean alive;

	public MultithreadedServer(int port) {
		this.port = port;
	}

	public void start() {
		Thread t = new Thread(this);
		setAlive(true);
		t.start();
		System.out.println("Server start");
	}
	
	public void stop() {
		setAlive(false);
		System.out.println("Server stop");
	}
	
	@Override
	public void run() {
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

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
