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
/**
 * Klasa Kontroler izvrsava sistemske operacije.
 * U pitanju je singlton klasa, a sadrzi i objekat brokera 
 * baze podataka, cije metode poziva.
 * @author Mirjana Dimitrijevic
 *
 */
public class Kontroler {
	/**
	 * Instanca klase Kontroler.
	 */
	private static Kontroler instance;
	/**
	 * Broker baze podataka koji izvrsava CRUD operacije.
	 */
	private DBBroker dbb;
	/**
	 * Vraca instancu klase Kontroler.
	 * Singlton klasa moze imati samo jedan objekat, pa tako pri svakom 
	 * instanciranju ove klase, ta instanca pokazuje na jednu i jedinu
	 * instancu koja je kreirana kada se ova metoda prvi put pozvala.
	 * @return Instanca klase Kontroler.
	 */
	public static Kontroler getInstance() {
		if(instance==null) instance= new Kontroler();
		return instance;
	}
	/**
	 * Kreira prazan objekat klase Kontroler i instancira
	 * brokera baze podataka.
	 */
	public Kontroler() {
		dbb= new DBBroker();
	}
/**
 * Metoda za logovanje korisnika sa odgovarajucim korisnickim imenom 
 * i lozinkom. Vraca informacije o ulogovanom korisniku.
 * @param un Korisnicko ime korisnika.
 * @param pass Lozinka korisnika.
 * @return Ulogovani Korisnik ili null, ako su kredencijali pogresni.
 */
	public Korisnik login(String un, String pass) {
		return dbb.login(un,pass);
	}
/**
 * Metoda za registraciju korisnika, sa parametrima koje je uneo pri
 * popunjavanju forme za registraciju.
 * Korisnicko ime mora biti jedinstveno. 
 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi. 
 * @param korisnik Informacije o korisniku koji se registruje.
 * @return <ul>
	 * 		<li> true - ako je registracija uspesna. </li>
	 * 		<li> false - ako registracija nije uspesna. </li>
	 * </ul>
 */
	public boolean register(Korisnik korisnik) {
		try {
			return dbb.register(korisnik);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
/**
 * Metoda koja vraca listu materijala iz baze.
 * @return lista materijala.
 */
	public ArrayList<Materijal> vratiMaterijale() {
		return dbb.vratiMaterijale();
	}
	/**
	 * Metoda koja cuva kreirani materijal.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @param materijal Informacije o materijalu koji se cuva.
	 *@return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean sacuvajMaterijal(Materijal materijal) {
		try {
			return dbb.sacuvajMaterijal(materijal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Metoda koja vraca listu pogona iz baze.
	 * @return lista pogona.
	 */
	public ArrayList<Pogon> vratiPogone() {
		return dbb.vratiPogone();
	}
	/**
	 * Metoda koja vraca listu korisnika iz baze.
	 * @return lista korisnika.
	 */
	public ArrayList<Korisnik> vratiKorisnike() {
		return dbb.vratiKorisnike();
	}
	/**
	 * Metoda koja vraca listu gradova iz baze.
	 * @return lista gradova.
	 */
	public ArrayList<Grad> vratiGradove() {
		return dbb.vratiGradove();
	}
	/**
	 * Metoda koja cuva kreirani pogon.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @param pogon Informacije o pogonu koji se cuva.
	 * @return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean sacuvajPogon(Pogon pogon) {
		try {
			return dbb.sacuvajPogon(pogon);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Metoda koja menja podatke o odredjenom pogonu.
     * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi. 
     * @param pogonIzmena Informacije o pogonu koji se menja.
	 * @return <ul>
		 * 		<li> true - ako je izmena uspesna. </li>
		 * 		<li> false - ako izmena nije uspesna. </li>
		 * </ul>
	 */
	public boolean izmeniPogon(Pogon pogonIzmena) {
		try {
			return dbb.izmeniPogon(pogonIzmena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Metoda koja vraca listu jedinica mere iz baze.
	 * @return lista jedinica mere.
	 */
	public ArrayList<JedinicaMere> vratiJediniceMere() {
		return dbb.vratiJediniceMere();
	}
	/**
	 * Metoda koja cuva kreirani proizvod.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi. 
	 * @param proizvod Informacije o proizvodu koji se cuva.
	 * @return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean sacuvajProizvod(Proizvod proizvod) {
		try {
			return dbb.sacuvajProizvod(proizvod);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Metoda koja vraca listu proizvoda iz baze.
	 * @return lista proizvoda.
	 */
	public ArrayList<Proizvod> vratiProizvode() {
		return dbb.vratiProizvode();
	}
	/**
	 * Metoda koja brise odredjeni proizvod.
     *Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi. 
     * @param proizvodBris Informacije o proizvodu koji se brise.
	 * @return <ul>
		 * 		<li> true - ako je brisanje uspesno. </li>
		 * 		<li> false - ako brisanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean obrisiProizvod(Proizvod proizvodBris) {
		try {
			return dbb.obrisiProizvod(proizvodBris);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Metoda koja cuva kreiranu proizvodnju.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi. 
	 * @param proizvodnja Informacije o proizvodnji koja se cuva.
     * @return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean sacuvajProizvodnju(Proizvodnja proizvodnja) {

		try {
			return dbb.sacuvajProizvodnju(proizvodnja);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}