package fr.leopaul.mychat.server.launcher;

import java.awt.HeadlessException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import fr.leopaul.mychat.server.model.reseau.MultithreadedServer;

public class LauncherServer {

	public static void main(String[] args) {

		// Ask port to open
		String res = JOptionPane.showInputDialog(null, "Using port to open :", "Start chat server",
				JOptionPane.QUESTION_MESSAGE);

		// Create and run server on this port
		int port = 45000;
		try {
			port = Integer.parseInt(res);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		MultithreadedServer server = new MultithreadedServer(port);
		server.start();

		try {
			// Ask when kick him
			JOptionPane.showOptionDialog(null,
					"Local IP : " + Inet4Address.getLocalHost().getHostAddress() + "\nServer is running on port "
							+ port,
					"Run chat server", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Stop" }, "Stop");
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			server.stop();
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			server.stop();
			e.printStackTrace();
		}

		server.stop();
		System.exit(0);
	}
}
