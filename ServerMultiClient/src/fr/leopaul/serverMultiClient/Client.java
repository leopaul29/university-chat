package fr.leopaul.serverMultiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private String hostname;
	private int port;
	private Socket socket;

	public Client(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void execute() {
		try {
			this.socket = new Socket(hostname, port);

			BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			PrintWriter out = new PrintWriter(this.socket.getOutputStream());

			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				String text = sc.nextLine();
				out.println(text);
				out.flush();
				
				if(text.equals("stop")) {
					break;
				}
				
				String recu = in.readLine();
				System.out.println(recu);
			}

			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String hostname = "localhost";
		int port = 45000;
		Client client = new Client(hostname, port);
		client.execute();
	}
}
