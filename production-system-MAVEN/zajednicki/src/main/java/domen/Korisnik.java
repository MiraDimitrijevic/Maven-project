package domen;

import java.io.Serializable;
import java.util.Objects;
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
 * @throws IllegalArgumentException kada je id manji od 1.
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
 * @throws IllegalArgumentException kada je ime i prezime korisnika prazan string.
 * @throws NullPointerException kada je ime i prezime korisnika null.
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
 * @throws IllegalArgumentException kada je korisnicko ime korisnika prazan string.
 * @throws NullPointerException kada je korisnicko ime korisnika null.
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
 * @throws IllegalArgumentException kada je lozinka korisnika prazan string.
 * @throws NullPointerException kada je lozinka korisnika null.
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
 * @throws IllegalArgumentException kada je radno mesto korisnika prazan string.
 * @throws NullPointerException kada je radno mesto korisnika null.
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
/**
 * Poredi dva korisnika prema identifikatoru i korisnickom imenu.
 * 
 * @return 
 * <ul>
 * 		<li> true - ako je unet isti objekat ili ako su id i korisnicko ime isti. </li>
 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase Korisnik. </li>
 * </ul>
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Korisnik other = (Korisnik) obj;
	return Objects.equals(korisnickoIme, other.korisnickoIme) && korisnikID == other.korisnikID;
}




}
