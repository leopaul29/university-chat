package fr.leopaul.mychat.server.controler.listeners;

import java.util.Observable;

public class Logger extends Observable {

	public void log(String message) {
		setChanged();
		notifyObservers(message);
	}
}
