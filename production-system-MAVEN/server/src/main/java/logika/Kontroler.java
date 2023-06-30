package logika;

import java.sql.SQLException;

import baza.DBBroker;
import domen.Korisnik;

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

	public Korisnik login(String un, String pass) {
		return dbb.login(un,pass);
	}

	public boolean register(Korisnik korisnik) {
		try {
			return dbb.register(korisnik);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
