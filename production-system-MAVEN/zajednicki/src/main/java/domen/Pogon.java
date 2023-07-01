package domen;

import java.io.Serializable;
import java.util.Date;
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
 */
public void setPogonID(long pogonID) {
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
 */
public void setDatumPocetkaRada(Date datumPocetkaRada) {
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
 */
public void setGrad(Grad grad) {
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
 */
public void setAdresa(String adresa) {
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
 */
public void setKontakt(String kontakt) {
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
 */
public void setKorisnik(Korisnik korisnik) {
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


}
