package logika;

import java.sql.SQLException;
import java.util.ArrayList;

import baza.DBBroker;
import domen.Grad;
import domen.JedinicaMere;
import domen.Korisnik;
import domen.Materijal;
import domen.Pogon;
import domen.Proizvod;
import domen.Proizvodnja;

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

	public ArrayList<Korisnik> vratiKorisnike() {
		return dbb.vratiKorisnike();
	}

	public ArrayList<Grad> vratiGradove() {
		return dbb.vratiGradove();
	}

	public boolean sacuvajPogon(Pogon pogon) {
		try {
			return dbb.sacuvajPogon(pogon);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean izmeniPogon(Pogon pogonIzmena) {
		try {
			return dbb.izmeniPogon(pogonIzmena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<JedinicaMere> vratiJediniceMere() {
		return dbb.vratiJediniceMere();
	}

	public boolean sacuvajProizvod(Proizvod proizvod) {
		try {
			return dbb.sacuvajProizvod(proizvod);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Proizvod> vratiProizvode() {
		return dbb.vratiProizvode();
	}

	public boolean obrisiProizvod(Proizvod proizvodBris) {
		try {
			return dbb.obrisiProizvod(proizvodBris);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean sacuvajProizvodnju(Proizvodnja proizvodnja) {

		try {
			return dbb.sacuvajProizvodnju(proizvodnja);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}