package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * Klasa Proizvodnja predstavlja dogadjaj proizvodnje skupa proizvoda u preduzecu.
 *  Implementira interfejs Serializable.
 * 
 * Sastoji se iz jedinstvenog identifikatora proizvodnje, datuma i vremena kada je
 * proizvodnja pocela i kada se zavrsila, pogona u kom se proizvodnja odvijala, 
 * korisnika koji je zabelezio proizvodnju u sistemu i liste proizvoda koji predstavljaju izlaze
 * proizvodnje.

 * 
 **@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class Proizvodnja implements Serializable {
	/**
	 * Jedinstveni identifikator proizvodnje.
	 */
private long proizvodnjaID;
/**
 * Datum i vreme pocetka proizvodnje.
 */
private Date datumVremePocetka;
/**
 * Datum i vreme zavrsetka proizvodnje.
 */
private Date datumVremeZavrsetka;
/**
 * Pogon u kom se proizvodnja odvijala.
 */
private Pogon pogon;
/**
 * Korisnik koji je zabelezio proizvodnju u sistemu.
 */
private Korisnik korisnik;
/**
 * Lista elemenata proizvodnje koja predstavlja skup njenih izlaza.
 * Implementirana je kao ArrayList.
 */
private ArrayList<ElementProizvodnje> izlazi;
/**
 * Kreira prazan objekat klase Proizvodnja.
 */
public Proizvodnja() {
}
/**
 * Kreira objekat klase Proizvodnja, sa zadatim identifikatorom, 
 * datumom i vremenom pocetka proizvodnje i njenog zavrsetka,
 * pogonom u kome se proizvodnja desila, korisnikom koji je uneo podatke o proizvodnji,
 * i listom proizvoda koji su proizvedeni tom prilikom.
 * @param proizvodnjaID Indentifikator proizvodnje.
 * @param datumVremePocetka Datum i vreme kada je proizvodnja pocela.
 * @param datumVremeZavrsetka  Datum i vreme kada se proizvodnja zavrsila.
 * @param pogon Pogon u kome se proizvodnja odvijala.
 * @param korisnik Korisnik koji je zabelezio podatke o proizvodnji.
 * @param izlazi Lista i kolicine proizvoda koji su izlazi iz procesa.
 */
public Proizvodnja(long proizvodnjaID, Date datumVremePocetka, Date datumVremeZavrsetka, Pogon pogon, Korisnik korisnik,
		ArrayList<ElementProizvodnje> izlazi) {
	super();
	this.proizvodnjaID = proizvodnjaID;
	this.datumVremePocetka = datumVremePocetka;
	this.datumVremeZavrsetka = datumVremeZavrsetka;
	this.pogon = pogon;
	this.korisnik = korisnik;
	this.izlazi = izlazi;
}
/**
 * Vraca jedinstveni identifikator proizvodnje.
 * @return Jedinstveni identifikator proizvodnje.
 */
public long getProizvodnjaID() {
	return proizvodnjaID;
}
/**
 * Postavlja jedinstveni identifikator proizvodnje.
 * @param proizvodnjaID Jedinstveni identifikator proizvodnje.
 */
public void setProizvodnjaID(long proizvodnjaID) {
	this.proizvodnjaID = proizvodnjaID;
}
/**
 * Vraca datum i vreme pocetka proizvodnje.
 * @return Datum i vreme pocetka proizvodnje.
 */
public Date getDatumVremePocetka() {
	return datumVremePocetka;
}
/**
 * Postavlja datum i vreme pocetka proizvodnje.
 * @param datumVremePocetka Datum i vreme pocetka proizvodnje.
 */
public void setDatumVremePocetka(Date datumVremePocetka) {
	this.datumVremePocetka = datumVremePocetka;
}
/**
 * Vraca datum i vreme zavrsetka proizvodnje.
 * @return Datum i vreme zavrsetka proizvodnje.
 */
public Date getDatumVremeZavrsetka() {
	return datumVremeZavrsetka;
}
/**
 * Postavlja datum i vreme zavrsetka proizvodnje.
 * @param datumVremeZavrsetka Datum i vreme zavrsetka proizvodnje.
 */
public void setDatumVremeZavrsetka(Date datumVremeZavrsetka) {
	this.datumVremeZavrsetka = datumVremeZavrsetka;
}
/**
 * Vraca pogon u kom se proizvodnja odvija.
 * @return Pogon u kom se proizvodnja odvijala.
 */
public Pogon getPogon() {
	return pogon;
}
/**
 * Postavlja pogon u kom se proizvodnja odvija.
 * @param pogon Pogon u kom se proizvodnja odvijala.
 */
public void setPogon(Pogon pogon) {
	this.pogon = pogon;
}
/**
 * Vraca korisnika koji je proizvodnju zabelezio u sistemu.
 * @return Korisnik koji je proizvodnju zabelezio u sistemu.
 */
public Korisnik getKorisnik() {
	return korisnik;
}
/**
 * Postavlja korisnika koji je proizvodnju zabelezio u sistemu.
 * @param korisnik Korisnik koji je proizvodnju zabelezio u sistemu.
 */
public void setKorisnik(Korisnik korisnik) {
	this.korisnik = korisnik;
}
/**
 * Vraca listu elemenata koji su izlaz procesa ove proizvodnje.
 * @return Lista elemenata koji predstavljaju izlaz procesa proizvodnje.
 */
public ArrayList<ElementProizvodnje> getIzlazi() {
	return izlazi;
}
/**
 * Postavlja listu elemenata koji su izlaz procesa ove proizvodnje.
 * @param izlazi Lista elemenata koji predstavljaju izlaz procesa proizvodnje.
 */
public void setIzlazi(ArrayList<ElementProizvodnje> izlazi) {
	this.izlazi = izlazi;
}


}
