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
	this.pogonID = pogonID;
}

public Date getDatumPocetkaRada() {
	return datumPocetkaRada;
}

public void setDatumPocetkaRada(Date datumPocetkaRada) {
	this.datumPocetkaRada = datumPocetkaRada;
}

public Grad getGrad() {
	return grad;
}

public void setGrad(Grad grad) {
	this.grad = grad;
}

public String getAdresa() {
	return adresa;
}

public void setAdresa(String adresa) {
	this.adresa = adresa;
}

public String getKontakt() {
	return kontakt;
}

public void setKontakt(String kontakt) {
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


}
