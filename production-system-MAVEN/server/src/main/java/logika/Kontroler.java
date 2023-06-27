package logika;

import java.sql.SQLException;
import java.util.ArrayList;

import baza.DBBroker;
import domen.Korisnik;
import domen.Materijal;
import domen.Pogon;

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

	public ArrayList<Materijal> vratiMaterijale() {
		return dbb.vratiMaterijale();
	}

	public boolean sacuvajMaterijal(Materijal materijal) {
		try {
			return dbb.sacuvajMaterijal(materijal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Pogon> vratiPogone() {
		return dbb.vratiPogone();
	}
}
