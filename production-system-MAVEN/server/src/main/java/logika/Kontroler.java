package logika;

import baza.DBBroker;

public class Kontroler {
	private static Kontroler instance;
	private DBBroker dbb;
	public static Kontroler getInstance() {
		if(instance==null) instance= new Kontroler();
		return instance;
	}
	
	public Kontroler() {
		dbb= new DBBroker();
	}
}
