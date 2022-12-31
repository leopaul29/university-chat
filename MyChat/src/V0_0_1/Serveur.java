package V0_0_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends Thread {

	//---- main
	public static void main(String[] args) {
		
		ServerSocket socket;
		try {
		socket = new ServerSocket(2009);
		Thread t = new Thread(new AccepterClient(socket));
		t.start();
		System.out.println("Mes employeurs sont prêts !");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	class AccepterClient implements Runnable {

		private ServerSocket socketserveur;
		private Socket socket;
		private int nbClient = 1;
		
		public AccepterClient(ServerSocket s) {
			this.socketserveur = s;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(true) {
					socket = socketserveur.accept(); // Un client se connecte on l'accepte
					System.out.println("Le client numero " + nbClient + " est connecté");
					nbClient ++;
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
