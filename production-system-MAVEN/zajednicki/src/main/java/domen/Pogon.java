package domen;

import java.io.Serializable;
import java.util.Date;

public class Pogon implements Serializable{
private long pogonID;
private Date datumPocetkaRada;
private Grad grad;
private String adresa;
private String kontakt;
private boolean aktivan;
private Korisnik korisnik;

public Pogon() {
}

public long getPogonID() {
	return pogonID;
}

public void setPogonID(long pogonID) {
    if(pogonID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	this.pogonID = pogonID;
}

public Date getDatumPocetkaRada() {
	return datumPocetkaRada;
}

public void setDatumPocetkaRada(Date datumPocetkaRada) {
	if(datumPocetkaRada==null) throw new NullPointerException("Datum pocetka rada pogona ne sme biti null");
    if(datumPocetkaRada.after(new Date())) throw new IllegalArgumentException("Datum pocetka rada pogona ne moze biti posle danasnjeg datuma");
	this.datumPocetkaRada = datumPocetkaRada;
}

public Grad getGrad() {
	return grad;
}

public void setGrad(Grad grad) {
	if(grad==null) throw new NullPointerException("Grad ne sme biti null");

	this.grad = grad;
}

public String getAdresa() {
	return adresa;
}

public void setAdresa(String adresa) {
	if(adresa==null) throw new NullPointerException("Adresa pogona ne sme biti null");
    if(adresa.isEmpty()) throw new IllegalArgumentException("Adresa pogona ne sme biti prazna");
	this.adresa = adresa;
}

public String getKontakt() {
	return kontakt;
}

public void setKontakt(String kontakt) {
	if(kontakt==null) throw new NullPointerException("Kontakt pogona ne sme biti null");
	
    if(kontakt.isEmpty()) throw new IllegalArgumentException("Kontakt pogona ne sme biti prazan");
    this.kontakt = kontakt;
}

public boolean isAktivan() {
	return aktivan;
}

public void setAktivan(boolean aktivan) {
	this.aktivan = aktivan;
}

public Korisnik getKorisnik() {
	return korisnik;
}

public void setKorisnik(Korisnik korisnik) {
	if(korisnik==null) throw new NullPointerException("Korisnik ne sme biti null");

	this.korisnik = korisnik;
}

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

@Override
	public String toString() {
		return grad+" ,"+adresa;
	}


}
