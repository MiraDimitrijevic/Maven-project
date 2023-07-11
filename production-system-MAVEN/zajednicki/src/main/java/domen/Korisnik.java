package domen;

import java.io.Serializable;
/**
 * Klasa Korisnik predstavlja klijenta sistema, koji se prijavljuje na sistem,
 * nakon cega ima pristup sistemskim operacija. Implementira interfejs Serializable.
 * 
 * Sadrzi Ime i prezime klijenta, njegovo korisnicko ime i lozinku, kao i 
 * radno mesto, koje predstavlja poziciju korisnika u kompaniji za koju je 
 * aplikacija pravljena. 
 * 
 **@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class Korisnik implements Serializable{
/**
 * Jedinstveni identifikator korisnika.
 */
private long korisnikID;
/**
 * Ime i prezime korisnika.
 */
private String imePrezime;
/**
 * Korisnicko ime kojim se korisnik prijavljuje na sistem.
 */
private String korisnickoIme;
/**
 * Lozinka za prijavu korisnika.
 */
private String lozinka;
/**
 * Radno mesto korisnika, tj. pozicija na kojoj on radi u kompaniji.
 */
private String radnoMesto;

/**
 * Kreira prazan objekat koji predstavlja korisnika sistema.
 */
public Korisnik() {
}
/**
 * Kreira objekat Korisnika sa odredjenim identifikatorom, imenom i prezimenom, 
 * korisnickim imenom, lozinkom i nazivom radnog mesta.
 * @param korisnikID Jedinstveni identifikator korisnika.
 * @param imePrezime Ime i prezime korisnika.
 * @param korisnickoIme Jedinstveno korisnicko ime za prijavu na sistem.
 * @param lozinka Lozinka kojoj se korisnik prijavljuje na sistem.
 * @param radnoMesto Naziv radnog mesta na kom je korisnik zaposlen.
 */
public Korisnik(long korisnikID, String imePrezime, String korisnickoIme, String lozinka, String radnoMesto) {
	super();
	this.korisnikID = korisnikID;
	this.imePrezime = imePrezime;
	this.korisnickoIme = korisnickoIme;
	this.lozinka = lozinka;
	this.radnoMesto = radnoMesto;
}
/**
 * Vraca jedinstveni identifikator korisnika.
 * @return Identifikator korisnika.
 */
public long getKorisnikID() {
	return korisnikID;
}
/**
 * Postavlja jedinstveni identifikator korisnika.
 * @param korisnikID Identifikator korisnika koji postavljamo.
 */
public void setKorisnikID(long korisnikID) {
    if(korisnikID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	this.korisnikID = korisnikID;
}
/**
 * Vraca ime i prezime korisnika.
 * @return Ime i prezime korisnika.
 */
public String getImePrezime() {
	return imePrezime;
}
/**
 * Postavlja ime i prezime korisnika.
 * @param imePrezime Ime i prezime korisnika.
 */
public void setImePrezime(String imePrezime) {
	if(imePrezime==null) throw new NullPointerException("Ime i prezime korisnika ne sme biti null");
    if(imePrezime.isEmpty()) throw new IllegalArgumentException("Ime i prezime korisnika ne sme biti prazno");
	this.imePrezime = imePrezime;
}
/**
 * Vraca jedinstveno korisnicko ime odredjenog korisnika.
 * @return Korisnicko ime za logovanje korisnika.
 */
public String getKorisnickoIme() {
	return korisnickoIme;
}
/**
 * Postavlja korisnicko ime za nekog korisnika.
 * Korisnicko ime mora biti jedinstveno.
 * @param korisnickoIme Korisnicko ime korisnika.
 */
public void setKorisnickoIme(String korisnickoIme) {
	if(korisnickoIme==null) throw new NullPointerException("Korisnicko ime korisnika ne sme biti null");
    if(korisnickoIme.isEmpty()) throw new IllegalArgumentException("Korisnicko ime korisnika ne sme biti prazno");
	this.korisnickoIme = korisnickoIme;
}

/**
 * Vraca lozinku odredjenog korisnika.
 * @return Lozinka za logovanje korisnika.
 */

public String getLozinka() {
	return lozinka;
}
/**
 * Postavlja lozinku odredjenog korisnika.
 * @param lozinka Lozinka za logovanje korisnika.
 */

public void setLozinka(String lozinka) {
	if(lozinka==null) throw new NullPointerException("Lozinka korisnika ne sme biti null");
    if(lozinka.isEmpty()) throw new IllegalArgumentException("Lozinka korisnika ne sme biti prazna");
	this.lozinka = lozinka;
}
/**
 * Vraca radno mesto, tj. poziciju u kompaniji odredjenog korisnika.
 * @return Radno mesto korisnika.
 */

public String getRadnoMesto() {
	return radnoMesto;
}

/**
 * Postavlja radno mesto, tj. poziciju u kompaniji odredjenog korisnika.
 * @param radnoMesto Radno mesto korisnika.
 */

public void setRadnoMesto(String radnoMesto) {
	if(radnoMesto==null) throw new NullPointerException("Radno mesto korisnika ne sme biti null");
    if(radnoMesto.isEmpty()) throw new IllegalArgumentException("Radno mesto korisnika ne sme biti prazno");
	this.radnoMesto = radnoMesto;
}
/**
 * Vraca string reprezentaciju Korisnika.
 * @return String reprezentacija korisnika.
 */
@Override
	public String toString() {
		return imePrezime;
	}


}
