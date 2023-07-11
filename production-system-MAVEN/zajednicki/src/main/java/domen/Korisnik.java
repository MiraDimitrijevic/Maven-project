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
    if(korisnikID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	this.korisnikID = korisnikID;
}

public String getImePrezime() {
	return imePrezime;
}

public void setImePrezime(String imePrezime) {
	if(imePrezime==null) throw new NullPointerException("Ime i prezime korisnika ne sme biti null");
    if(imePrezime.isEmpty()) throw new IllegalArgumentException("Ime i prezime korisnika ne sme biti prazno");
	this.imePrezime = imePrezime;
}

public String getKorisnickoIme() {
	return korisnickoIme;
}

public void setKorisnickoIme(String korisnickoIme) {
	if(korisnickoIme==null) throw new NullPointerException("Korisnicko ime korisnika ne sme biti null");
    if(korisnickoIme.isEmpty()) throw new IllegalArgumentException("Korisnicko ime korisnika ne sme biti prazno");
	this.korisnickoIme = korisnickoIme;
}

public String getLozinka() {
	return lozinka;
}

public void setLozinka(String lozinka) {
	if(lozinka==null) throw new NullPointerException("Lozinka korisnika ne sme biti null");
    if(lozinka.isEmpty()) throw new IllegalArgumentException("Lozinka korisnika ne sme biti prazna");
	this.lozinka = lozinka;
}

public String getRadnoMesto() {
	return radnoMesto;
}

public void setRadnoMesto(String radnoMesto) {
	if(radnoMesto==null) throw new NullPointerException("Radno mesto korisnika ne sme biti null");
    if(radnoMesto.isEmpty()) throw new IllegalArgumentException("Radno mesto korisnika ne sme biti prazno");
	this.radnoMesto = radnoMesto;
}

@Override
	public String toString() {
		return imePrezime;
	}


}
