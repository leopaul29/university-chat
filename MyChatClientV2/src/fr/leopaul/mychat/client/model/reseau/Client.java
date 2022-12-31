package fr.leopaul.mychat.client.model.reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Scanner;

public class Client extends Observable implements Runnable {

	private String hostname;
	private int port;
	private Socket socket;
	private boolean alive;
	private PrintWriter out;
	private BufferedReader in;

	public Client(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void start() {
		Thread t = new Thread(this);
		setAlive(true);
		t.start();
		System.out.println("Client start");
	}
	
	public void stop() {
		setAlive(false);
		System.out.println("Client stop");
	}
	
	public void write(String text) {
		out.println(text);
		out.flush();
	}

	private void read(String text) {
		this.setChanged();
		this.notifyObservers(text);
	}
	
	@Override
	public void run() {
		try {
			this.socket = new Socket(hostname, port);

			out = new PrintWriter(this.socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

			String text;
			while ((text = in.readLine()) != null && isAlive()) {
				read(text);
			}

			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
