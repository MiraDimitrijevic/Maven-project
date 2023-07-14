package domen;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 * Klasa Pogon predstavlja pogon preduzeca. Implementira interfejs Serializable.
 * 
 * Sadrzi jedinstveni identifikator pogona, datum kada je pogon otvoren,
 * tj. kada je zapoceo sa radom, grad u kome je pogon otvoren, adresu na kojoj se nalazi,
 * kontakt telefon pogona, podatak o tome da li je pogon aktivan ili ugasen, kao i 
 * Korisnika odnosno zaposlenog koji je nadlezan za proizvodnju u tom pogonu.
 * 
 **@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class Pogon implements Serializable{
	/**
	 * Jedinstveni identifikator pogona.
	 */
private long pogonID;
/**
 * Datum pocetka rada pogona.
 */
private Date datumPocetkaRada;
/**
 * Grad u kome se pogon nalazi.
 */
private Grad grad;
/**
 * Adresa na kojoj se pogon nalazi.
 */
private String adresa;
/**
Kontakt telefon pogona.
 */
private String kontakt;
/**
 * Podatak o tome da li je pogon aktivan ili ugasen.
*/
private boolean aktivan;
/**
 *Korisnik koji je nadlezan za rad pogona.
 */
private Korisnik korisnik;

/**
 * Kreira prazan objekat klase Pogon.
 */
public Pogon() {
}
/**
 * Vraca jedinstveni identifikator pogona.
 * @return Jedinstveni identifikator pogona.
 */

public long getPogonID() {
	return pogonID;
}
/**
 * Postavlja jedinstveni identifikator pogona.
 * @param pogonID Jedinstveni identifikator pogona.
 * @throws IllegalArgumentException kada je id manji od 1.

 */
public void setPogonID(long pogonID) {
    if(pogonID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	this.pogonID = pogonID;
}
/**
 * Vraca datum pocetka rada pogona.
 * @return Datum pocetka rada pogona.
 */
public Date getDatumPocetkaRada() {
	return datumPocetkaRada;
}
/**
 * Postavlja datum pocetka rada pogona.
 * @param datumPocetkaRada Datum pocetka rada pogona.
 * @throws IllegalArgumentException kada je datum pocetka rada pogona datum kasniji u odnosu na danasnji.
 * @throws NullPointerException kada je datum pocetka rada pogona null.
 */
public void setDatumPocetkaRada(Date datumPocetkaRada) {
	if(datumPocetkaRada==null) throw new NullPointerException("Datum pocetka rada pogona ne sme biti null");
    if(datumPocetkaRada.after(new Date())) throw new IllegalArgumentException("Datum pocetka rada pogona ne moze biti posle danasnjeg datuma");
	this.datumPocetkaRada = datumPocetkaRada;
}
/**
 * Vraca grad u kom je pogon otvoren.
 * @return Grad u kom je pogon otvoren.
 */
public Grad getGrad() {
	return grad;
}
/**
 * Postavlja grad u kom je pogon otvoren.
 * @param grad Grad u kom je pogon otvoren.
 * @throws NullPointerException kada je grad u kom se nalazi pogon null.

 * 
 */
public void setGrad(Grad grad) {
	if(grad==null) throw new NullPointerException("Grad ne sme biti null");

	this.grad = grad;
}
/**
 * Vraca adresu na kojoj se pogon nalazi.
 * @return Adresa na kojoj se pogon nalazi.
 */
public String getAdresa() {
	return adresa;
}
/**
 * Postavlja adresu na kojoj se pogon nalazi.
 * @param adresa Adresa na kojoj se pogon nalazi.
 * @throws IllegalArgumentException kada je adresa pogona prazan string.
 * @throws NullPointerException kada je adresa pogona null.
 */
public void setAdresa(String adresa) {
	if(adresa==null) throw new NullPointerException("Adresa pogona ne sme biti null");
    if(adresa.isEmpty()) throw new IllegalArgumentException("Adresa pogona ne sme biti prazna");
	this.adresa = adresa;
}
/**
 * Vraca kontakt telefon pogona.
 * @return Telefon za kontaktiranje pogona.
 */
public String getKontakt() {
	return kontakt;
}
/**
 * Postavlja kontakt telefon pogona.
 * @param kontakt Telefon za kontaktiranje pogona.
 * @throws IllegalArgumentException kada je kontakt pogona prazan string.
 * @throws NullPointerException kada je kontakt pogona null.
 */
public void setKontakt(String kontakt) {
	if(kontakt==null) throw new NullPointerException("Kontakt pogona ne sme biti null");
	
    if(kontakt.isEmpty()) throw new IllegalArgumentException("Kontakt pogona ne sme biti prazan");
    this.kontakt = kontakt;
}
/**
 * Vraca podatak o tome da li je pogon aktivan ili ugasen.
 * @return Informacija o aktivnosti pogona.
 */
public boolean isAktivan() {
	return aktivan;
}
/**
 * Postavlja podatak o tome da li je pogon aktivan ili ugasen.
 * @param aktivan Informacija o aktivnosti pogona.
 */
public void setAktivan(boolean aktivan) {
	this.aktivan = aktivan;
}
/**
 * Vraca informacije o Korisniku koji je nadlezan za pogon.
 * @return Informacije o nadleznom Korisniku.
 */
public Korisnik getKorisnik() {
	return korisnik;
}
/**
 * Postavlja informacije o Korisniku koji je nadlezan za pogon.
 * @param korisnik Informacije o nadleznom Korisniku.
 * @throws NullPointerException kada je korisnik nadlezan za pogon null.
 */
public void setKorisnik(Korisnik korisnik) {
	if(korisnik==null) throw new NullPointerException("Korisnik ne sme biti null");

	this.korisnik = korisnik;
}

/**
 * Kreira objekat klase Pogon sa odredjenim identifikatorom, datumom pocetka rada, gradom i adresom
 * na kojoj se pogon nalazi, kontakt telefonom, informacijom da li je pogon aktivan i Korisnikom
 * koji je nadlezan za rad pogona.
 * @param pogonID Jedinstveni identifikator pogona.
 * @param datumPocetkaRada datum pocetka rada pogona.
 * @param grad Grad u kome je pogon otvoren.
 * @param adresa Adresa na kojoj se pogon nalazi.
 * @param kontakt Telefon za kontakt pogona.
 * @param aktivan Podatak o tome da li je pogon u funkciji ili je ugasen.
 * @param korisnik Podaci o korisniku koji je nadlezan za rad pogona.
 */
public Pogon(long pogonID, Date datumPocetkaRada, Grad grad, String adresa, String kontakt, boolean aktivan,
		Korisnik korisnik) {
	super();
	this.pogonID = pogonID;
	this.datumPocetkaRada = datumPocetkaRada;
	this.grad = grad;
	this.adresa = adresa;
	this.kontakt = kontakt;
	this.aktivan = aktivan;
	this.korisnik = korisnik;
}
/**
 * Vraca string reprezentaciju Pogona.
 * @return String reprezentacija pogona.
 */
@Override
	public String toString() {
		return grad+" ,"+adresa;
	}
/**
 * Poredi dva pogona prema identifikatoru i kontaktu.
 * 
 * @return 
 * <ul>
 * 		<li> true - ako je unet isti objekat ili ako su id i kontakt pogona isti. </li>
 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase Pogon. </li>
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
	Pogon other = (Pogon) obj;
	return Objects.equals(kontakt, other.kontakt) && pogonID == other.pogonID;
}


}
