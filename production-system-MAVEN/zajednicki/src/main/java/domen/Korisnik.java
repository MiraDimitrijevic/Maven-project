package domen;

import java.io.Serializable;

public class Korisnik implements Serializable{
private long korisnikID;
private String imePrezime;
private String korisnickoIme;
private String lozinka;
private String radnoMesto;

public Korisnik() {
}

public Korisnik(long korisnikID, String imePrezime, String korisnickoIme, String lozinka, String radnoMesto) {
	super();
	this.korisnikID = korisnikID;
	this.imePrezime = imePrezime;
	this.korisnickoIme = korisnickoIme;
	this.lozinka = lozinka;
	this.radnoMesto = radnoMesto;
}

public long getKorisnikID() {
	return korisnikID;
}

public void setKorisnikID(long korisnikID) {
	this.korisnikID = korisnikID;
}

public String getImePrezime() {
	return imePrezime;
}

public void setImePrezime(String imePrezime) {
	this.imePrezime = imePrezime;
}

public String getKorisnickoIme() {
	return korisnickoIme;
}

public void setKorisnickoIme(String korisnickoIme) {
	this.korisnickoIme = korisnickoIme;
}

public String getLozinka() {
	return lozinka;
}

public void setLozinka(String lozinka) {
	this.lozinka = lozinka;
}

public String getRadnoMesto() {
	return radnoMesto;
}

public void setRadnoMesto(String radnoMesto) {
	this.radnoMesto = radnoMesto;
}

@Override
	public String toString() {
		return imePrezime;
	}


}
