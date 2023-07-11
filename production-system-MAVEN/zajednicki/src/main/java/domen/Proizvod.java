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
    if(proizvodID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	this.proizvodID = proizvodID;
}

public String getNazivProizvoda() {
	return nazivProizvoda;
}

public void setNazivProizvoda(String nazivProizvoda) {
	if(nazivProizvoda==null) throw new NullPointerException("Naziv proizvoda ne sme biti null");
    if(nazivProizvoda.isEmpty()) throw new IllegalArgumentException("Naziv proizvoda ne sme biti prazan");
	this.nazivProizvoda = nazivProizvoda;
}

public String getOpisProizvoda() {
	return opisProizvoda;
}

public void setOpisProizvoda(String opisProizvoda) {
	if(opisProizvoda==null) throw new NullPointerException("Opis proizvoda ne sme biti null");
    if(opisProizvoda.isEmpty()) throw new IllegalArgumentException("Opis proizvoda ne sme biti prazno");
	this.opisProizvoda = opisProizvoda;
}

public double getKolicinaNaStanju() {
	return kolicinaNaStanju;
}

public void setKolicinaNaStanju(double kolicinaNaStanju) {
    if(kolicinaNaStanju<0) throw new IllegalArgumentException("Kolicina ne moze biti manja od 0.");

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
    if(vekTrajanjaUMesecima<=0) throw new IllegalArgumentException("Vek trajanja ne moze biti kraci od 1 meseca.");

	this.vekTrajanjaUMesecima = vekTrajanjaUMesecima;
}

public Date getDatumPocetkaProizvodnje() {
	return datumPocetkaProizvodnje;
}

public void setDatumPocetkaProizvodnje(Date datumPocetkaProizvodnje) {
	if(datumPocetkaProizvodnje==null) throw new NullPointerException("Datum pocetka proizvodnje proizvoda ne sme biti null");
    if(datumPocetkaProizvodnje.after(new Date())) throw new IllegalArgumentException("Datum pocetka proizvodnje proizvoda ne moze biti posle danasnjeg datuma");
	this.datumPocetkaProizvodnje = datumPocetkaProizvodnje;
}

public Korisnik getKorisnik() {
	return korisnik;
}

public void setKorisnik(Korisnik korisnik) {
	if(korisnik==null) throw new NullPointerException("Korisnik ne sme biti null");

	this.korisnik = korisnik;
}

public ArrayList<ElementProizvoda> getSastavnica() {
	return sastavnica;
}

public void setSastavnica(ArrayList<ElementProizvoda> sastavnica) {
	if(sastavnica==null) throw new NullPointerException("Lista elemenata proizvoda ne sme biti null");
    if(sastavnica.size()==0) throw new IllegalArgumentException("Lista elemenata proizvoda ne moze biti prazna");
	this.sastavnica = sastavnica;
}


}
