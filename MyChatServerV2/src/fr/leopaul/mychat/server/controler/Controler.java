package fr.leopaul.mychat.server.controler;

import java.util.Observable;
import java.util.Observer;

import fr.leopaul.mychat.server.controler.listeners.Logger;
import fr.leopaul.mychat.server.controler.listeners.WindowLogListener;
import fr.leopaul.mychat.server.model.reseau.MultithreadedServer;
import fr.leopaul.mychat.server.vue.log.WindowLog;

public class Controler implements Observer {

	private final Logger logger = new Logger();
	private final WindowLog vue = new WindowLog();
	private final MultithreadedServer server = new MultithreadedServer(logger);

	public Controler() {
		addListeners();

		logger.addObserver(this);
	}

	private void addListeners() {
		WindowLogListener logListener = new WindowLogListener(this);

		vue.getButStart().addActionListener(logListener);
		vue.getButStop().addActionListener(logListener);
	}

	public void startServer() {
		int port = 45000;
//		try {
//			port = Integer.parseInt(vue.getTxtfPort().getText());
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}

		server.setPort(port);
		server.start();
	}

	public void stopServer() {
		server.stop();
	}
	
	private void appendTxtA(String message) {
		vue.getTxtaLog().append(message + "\n");
	}

	@Override
	public void update(Observable server, Object obj) {
		String msg = (String) obj;
		
		appendTxtA(msg);
	}
}
