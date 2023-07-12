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
 * @throws IllegalArgumentException kada je id manji od 1.

 */
public void setProizvodnjaID(long proizvodnjaID) {
    if(proizvodnjaID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");

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
 * @throws IllegalArgumentException kada je datum pocetka proizvodnje datum kasniji u odnosu na danasnji datum.
 * @throws NullPointerException kada je datum pocetka proizvodnje null.
 */
public void setDatumVremePocetka(Date datumVremePocetka) {
	if(datumVremePocetka==null) throw new NullPointerException("Datum i vreme pocetka proizvodnje ne sme biti null");
    if(datumVremePocetka.after(new Date())) throw new IllegalArgumentException("Datum i vreme pocetka proizvodnje ne moze biti posle danasnjeg datuma");
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
 * @throws IllegalArgumentException kada je datum zavrsetka proizvodnje datum pre datuma pocetka proizvodnje.
 * @throws NullPointerException kada je datum zavrsetka proizvodnje null.
 */
public void setDatumVremeZavrsetka(Date datumVremeZavrsetka) {
	if(datumVremeZavrsetka==null) throw new NullPointerException("Datum i vreme zavrsetka proizvodnje ne sme biti null");
    if(datumVremeZavrsetka.before(datumVremePocetka)) throw new IllegalArgumentException("Datum i vreme zavrsetka proizvodnje ne moze biti pre datuma i vremena pocetka proizvodnje");
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
 * @throws NullPointerException kada je pogon u kome se odvija proizvodnja null.

 */
public void setPogon(Pogon pogon) {
	if(pogon==null) throw new NullPointerException("Pogon ne sme biti null");

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
 * @throws NullPointerException kada je korisnik koji unosi proizvodnju u sistem null.

 */
public void setKorisnik(Korisnik korisnik) {
	if(korisnik==null) throw new NullPointerException("Korisnik ne sme biti null");

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
 * @throws IllegalArgumentException kada je lista elemenata proizvodnje prazna.
 * @throws NullPointerException kada je lista elemenata proizvodnje null.
 */
public void setIzlazi(ArrayList<ElementProizvodnje> izlazi) {
	if(izlazi==null) throw new NullPointerException("Lista elemenata proizvodnje ne sme biti null");
    if(izlazi.size()==0) throw new IllegalArgumentException("Lista elemenata proizvodnje ne moze biti prazna");
	this.izlazi = izlazi;
}


}
