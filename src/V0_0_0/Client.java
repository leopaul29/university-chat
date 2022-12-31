package V0_0_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread {
	
	//---- main
	public static void main(String[] args) {

		Socket socket;
		BufferedReader in;
		PrintWriter out;
		
		try {
			// Creation d'une nouvelle socket
			//
			socket = new Socket(InetAddress.getLocalHost(), 2009);
			System.out.println("Demande de connexion");
			
			// Je r�cup�re le flux sortant
			//
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// Je lis une cha�ne de caract�res
			//
			String messageDistant = in.readLine();
			
			// J'affiche le message re�u
			//
			System.out.println(messageDistant);
			
			// Je ferme la socket
			//
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
