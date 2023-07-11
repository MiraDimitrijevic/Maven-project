package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Proizvodnja implements Serializable {
private long proizvodnjaID;
private Date datumVremePocetka;
private Date datumVremeZavrsetka;
private Pogon pogon;
private Korisnik korisnik;
private ArrayList<ElementProizvodnje> izlazi;

public Proizvodnja() {
}

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

public long getProizvodnjaID() {
	return proizvodnjaID;
}

public void setProizvodnjaID(long proizvodnjaID) {
    if(proizvodnjaID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");

	this.proizvodnjaID = proizvodnjaID;
}

public Date getDatumVremePocetka() {
	return datumVremePocetka;
}

public void setDatumVremePocetka(Date datumVremePocetka) {
	if(datumVremePocetka==null) throw new NullPointerException("Datum i vreme pocetka proizvodnje ne sme biti null");
    if(datumVremePocetka.after(new Date())) throw new IllegalArgumentException("Datum i vreme pocetka proizvodnje ne moze biti posle danasnjeg datuma");
	this.datumVremePocetka = datumVremePocetka;
}

public Date getDatumVremeZavrsetka() {
	return datumVremeZavrsetka;
}

public void setDatumVremeZavrsetka(Date datumVremeZavrsetka) {
	if(datumVremeZavrsetka==null) throw new NullPointerException("Datum i vreme zavrsetka proizvodnje ne sme biti null");
    if(datumVremeZavrsetka.before(datumVremePocetka)) throw new IllegalArgumentException("Datum i vreme zavrsetka proizvodnje ne moze biti pre datuma i vremena pocetka proizvodnje");
	this.datumVremeZavrsetka = datumVremeZavrsetka;
}

public Pogon getPogon() {
	return pogon;
}

public void setPogon(Pogon pogon) {
	if(pogon==null) throw new NullPointerException("Pogon ne sme biti null");

	this.pogon = pogon;
}

public Korisnik getKorisnik() {
	return korisnik;
}

public void setKorisnik(Korisnik korisnik) {
	if(korisnik==null) throw new NullPointerException("Korisnik ne sme biti null");

	this.korisnik = korisnik;
}

public ArrayList<ElementProizvodnje> getIzlazi() {
	return izlazi;
}

public void setIzlazi(ArrayList<ElementProizvodnje> izlazi) {
	if(izlazi==null) throw new NullPointerException("Lista elemenata proizvodnje ne sme biti null");
    if(izlazi.size()==0) throw new IllegalArgumentException("Lista elemenata proizvodnje ne moze biti prazna");
	this.izlazi = izlazi;
}


}
