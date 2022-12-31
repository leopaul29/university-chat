package V0_0_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends Thread {

	//---- main
	public static void main(String[] args) {
		
		ServerSocket socketserver;
		Socket socketduserveur;
		BufferedReader in;
		PrintWriter out;
		
		try {
			// Creation d'une Serveursocket pour le serveur
			//
			socketserver = new ServerSocket(2009);
			System.out.println("Le serveur est à l'écoute du port " + socketserver.getLocalPort());
			
			// Attachement d'une socket au serveur
			//
			socketduserveur = socketserver.accept();
			System.out.println("Client connecté !");
			
			// Je gére le flux sortant 
			//
			out = new PrintWriter(socketduserveur.getOutputStream());
			out.println("Vous êtes connecté en tant que client");
			
			// Je vide le buffer
			//
			out.flush();
			
			// Je ferme la connexion
			//
			socketduserveur.close();
			socketserver.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
