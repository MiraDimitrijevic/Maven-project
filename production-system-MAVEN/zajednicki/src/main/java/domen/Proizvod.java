package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Proizvod implements Serializable{
private long proizvodID;
private String nazivProizvoda;
private String opisProizvoda;
private double kolicinaNaStanju;
private boolean patent;
private int vekTrajanjaUMesecima;
private Date datumPocetkaProizvodnje;
private Korisnik korisnik;
private ArrayList<ElementProizvoda> sastavnica;

public Proizvod() {
}

public Proizvod(long proizvodID, String nazivProizvoda, String opisProizvoda, double kolicinaNaStanju, boolean patent,
		int vekTrajanjaUMesecima, Date datumPocetkaProizvodnje, Korisnik korisnik,
		ArrayList<ElementProizvoda> sastavnica) {
	super();
	this.proizvodID = proizvodID;
	this.nazivProizvoda = nazivProizvoda;
	this.opisProizvoda = opisProizvoda;
	this.kolicinaNaStanju = kolicinaNaStanju;
	this.patent = patent;
	this.vekTrajanjaUMesecima = vekTrajanjaUMesecima;
	this.datumPocetkaProizvodnje = datumPocetkaProizvodnje;
	this.korisnik = korisnik;
	this.sastavnica = sastavnica;
}

@Override
	public String toString() {
		return nazivProizvoda;
	}

public long getProizvodID() {
	return proizvodID;
}

public void setProizvodID(long proizvodID) {
	this.proizvodID = proizvodID;
}

public String getNazivProizvoda() {
	return nazivProizvoda;
}

public void setNazivProizvoda(String nazivProizvoda) {
	this.nazivProizvoda = nazivProizvoda;
}

public String getOpisProizvoda() {
	return opisProizvoda;
}

public void setOpisProizvoda(String opisProizvoda) {
	this.opisProizvoda = opisProizvoda;
}

public double getKolicinaNaStanju() {
	return kolicinaNaStanju;
}

public void setKolicinaNaStanju(double kolicinaNaStanju) {
	this.kolicinaNaStanju = kolicinaNaStanju;
}

public boolean isPatent() {
	return patent;
}

public void setPatent(boolean patent) {
	this.patent = patent;
}

public int getVekTrajanjaUMesecima() {
	return vekTrajanjaUMesecima;
}

public void setVekTrajanjaUMesecima(int vekTrajanjaUMesecima) {
	this.vekTrajanjaUMesecima = vekTrajanjaUMesecima;
}

public Date getDatumPocetkaProizvodnje() {
	return datumPocetkaProizvodnje;
}

public void setDatumPocetkaProizvodnje(Date datumPocetkaProizvodnje) {
	this.datumPocetkaProizvodnje = datumPocetkaProizvodnje;
}

public Korisnik getKorisnik() {
	return korisnik;
}

public void setKorisnik(Korisnik korisnik) {
	this.korisnik = korisnik;
}

public ArrayList<ElementProizvoda> getSastavnica() {
	return sastavnica;
}

public void setSastavnica(ArrayList<ElementProizvoda> sastavnica) {
	this.sastavnica = sastavnica;
}


}
