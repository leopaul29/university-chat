package V0_0_1;

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
			socket = new Socket("localhost", 2009);
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
