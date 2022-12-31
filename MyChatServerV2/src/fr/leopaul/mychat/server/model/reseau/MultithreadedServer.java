package fr.leopaul.mychat.server.model.reseau;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import fr.leopaul.mychat.server.controler.listeners.Logger;

public class MultithreadedServer implements Runnable {

	private ServerSocket serverSocket;
	private int port;
	private boolean alive;
	
	private final Logger logger;
	
	public MultithreadedServer(Logger logger) {
		this.logger = logger;
	}

	public void start() {
		if(isAlive()) {
			logger.log("A server is already running");
			return;
		}
		
		Thread t = new Thread(this);
		setAlive(true);
		t.start();
		logger.log("Server start");
	}

	public void stop() {
		if(!isAlive()) {
			logger.log("Server already stop");
			return;
		}
		
		setAlive(false);
		logger.log("Server stop");
	}

	@Override
	public void run() {
		try {
			this.serverSocket = new ServerSocket(port);

			logger.log("En attente d'une prochaine connection");

			Socket socket;
			while ((socket = this.serverSocket.accept()) != null && isAlive()) {
				ClientManager clientManager = new ClientManager(socket, logger);
				Thread thread = new Thread(clientManager);
				thread.start();
			}
			socket.close();
			this.serverSocket.close();
		} catch (IOException e) {
			logger.log("Server error");
			e.printStackTrace();
		}
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
}
