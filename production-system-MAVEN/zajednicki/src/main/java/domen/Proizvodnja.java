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
	this.proizvodnjaID = proizvodnjaID;
}

public Date getDatumVremePocetka() {
	return datumVremePocetka;
}

public void setDatumVremePocetka(Date datumVremePocetka) {
	this.datumVremePocetka = datumVremePocetka;
}

public Date getDatumVremeZavrsetka() {
	return datumVremeZavrsetka;
}

public void setDatumVremeZavrsetka(Date datumVremeZavrsetka) {
	this.datumVremeZavrsetka = datumVremeZavrsetka;
}

public Pogon getPogon() {
	return pogon;
}

public void setPogon(Pogon pogon) {
	this.pogon = pogon;
}

public Korisnik getKorisnik() {
	return korisnik;
}

public void setKorisnik(Korisnik korisnik) {
	this.korisnik = korisnik;
}

public ArrayList<ElementProizvodnje> getIzlazi() {
	return izlazi;
}

public void setIzlazi(ArrayList<ElementProizvodnje> izlazi) {
	this.izlazi = izlazi;
}


}
