package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * Klasa Proizvod predstavlja izlaz procesa proizvodnje, odnosno
 * proizvod koji se proizvodi u preduzecu. Implementira interfejs Serializable.
 * 
 * Sadrzi jedinstveni identifikator proizvoda, naziv proizvoda, njegov opis i kolicinu
 * koja se nalazi na stanju, podatak o tome da li proizvod preduzeca predstavlja patent,
 * vek trajanja proizvoda izrazen u mesecima, datum pocetka proizvodnje proizvoda, 
 * informacije o Korisniku koji je uneo proizvod u sistem, kao i listu svih elemenata
 * proizvoda koji su potrebni za njegovu proizvodnju.
 * 
 **@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class Proizvod implements Serializable{
	/**
	 * Jedinstveni identifikator proizvoda.
	 */
private long proizvodID;
/**
 * Naziv proizvoda.
 */
private String nazivProizvoda;
/**
 * Detaljan opis proizvoda.
 */
private String opisProizvoda;
/**
 * Kolicina proizvoda koja se nalazi u magacinu.
 */
private double kolicinaNaStanju;
/**
 * Informacija o tome da li proizvod preduzeca predstavlja patent.
 */
private boolean patent;
/**
 * Vek trajanja proizvoda izrazen u mesecima.
 */
private int vekTrajanjaUMesecima;
/**
 * Datum kada je preduzece pocelo sa proizvodnjom proizvoda, odnosno datum kada
 * su podaci o proizvodu uneti u sistem.
 */
private Date datumPocetkaProizvodnje;
/**
 * Informacije o Korisniku koji je uneo podatke o proizvodu u sistem.
 */
private Korisnik korisnik;
/**
 * Lista svih elemenata proizvoda neophodnih za njegovu proizvodnju,
 * implementirana preko ArrayList klase.
 */
private ArrayList<ElementProizvoda> sastavnica;

/**
 * Kreira prazan objekat klase Proizvod.
 */
public Proizvod() {
}
/**
 * Kreira objekat klase Proizvod, sa zadatim identifikatorom, nazivom, opisom,
 * kolicinom proizvoda u magacinu, podatku o tome da li je proizvod patentiran ili nije, 
 * informacijom o veku trajanja proizvoda izrazenom u mesecima, datumom kada je proizvod
 * poceo da se proizvodi u preduzecu, korisnikom koji ga je uneo u sistem, kao i listom
 * svih materijala koji ulaze u sastav proizvoda.
 * @param proizvodID Jedinstveni identifikator proizvoda.
 * @param nazivProizvoda Naziv proizvoda.
 * @param opisProizvoda Opis proizvoda.
 * @param kolicinaNaStanju Kolicina proizvoda na skladistu.
 * @param patent Podatak o tome da li je proizvod patentiran.
 * @param vekTrajanjaUMesecima Vek trajanja proizvoda izrazen u mesecima.
 * @param datumPocetkaProizvodnje Datum kada je proizvod poceo da se proizvodi u preduzecu.
 * @param korisnik Informacije o Korisniku koji je uneo proizvod u sistem. 
 * @param sastavnica Lista svih elemenata nephodnih za proizvodnju proizvoda. 
 */
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
/**
 * Vraca string reprezentaciju Proizvoda.
 * @return String reprezentacija proizvoda.
 */
@Override
	public String toString() {
		return nazivProizvoda;
	}
/**
 * Vraca jedinstveni identifikator proizvoda.
 * @return Jedinstveni identifikator proizvoda.
 */
public long getProizvodID() {
	return proizvodID;
}
/**
 * Postavlja jedinstveni identifikator proizvoda.
 * @param proizvodID Jedinstveni identifikator proizvoda.
 * @throws IllegalArgumentException kada je id manji od 1.

 */
public void setProizvodID(long proizvodID) {
    if(proizvodID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	this.proizvodID = proizvodID;
}
/**
 * Vraca naziv proizvoda.
 * @return Naziv proizvoda.
 */
public String getNazivProizvoda() {
	return nazivProizvoda;
}
/**
 * Postavlja naziv proizvoda.
 * @param nazivProizvoda Naziv proizvoda.
 * @throws IllegalArgumentException kada je naziv proizvoda prazan string.
 * @throws NullPointerException kada je naziv proizvoda null.
 */
public void setNazivProizvoda(String nazivProizvoda) {
	if(nazivProizvoda==null) throw new NullPointerException("Naziv proizvoda ne sme biti null");
    if(nazivProizvoda.isEmpty()) throw new IllegalArgumentException("Naziv proizvoda ne sme biti prazan");
	this.nazivProizvoda = nazivProizvoda;
}
/**
 * Vraca opis proizvoda.
 * @return Opis proizvoda.
 */
public String getOpisProizvoda() {
	return opisProizvoda;
}
/**
 * Postavlja opis proizvoda.
 * @param opisProizvoda Opis proizvoda.
 * @throws IllegalArgumentException kada je opis proizvoda prazan string.
 * @throws NullPointerException kada je opis proizvoda null.
 */
public void setOpisProizvoda(String opisProizvoda) {
	if(opisProizvoda==null) throw new NullPointerException("Opis proizvoda ne sme biti null");
    if(opisProizvoda.isEmpty()) throw new IllegalArgumentException("Opis proizvoda ne sme biti prazno");
	this.opisProizvoda = opisProizvoda;
}
/**
 * Vraca kolicinu proizvoda koja se nalazi na skladistu.
 * @return Kolicina proizvoda na stanju.
 */
public double getKolicinaNaStanju() {
	return kolicinaNaStanju;
}
/**
 * Postavlja kolicinu proizvoda koja se nalazi na skladistu.
 * @param kolicinaNaStanju Kolicina proizvoda na stanju.
 * @throws IllegalArgumentException kada je kolicina manja od 0.

 */
public void setKolicinaNaStanju(double kolicinaNaStanju) {
    if(kolicinaNaStanju<0) throw new IllegalArgumentException("Kolicina ne moze biti manja od 0.");

	this.kolicinaNaStanju = kolicinaNaStanju;
}
/**
 * Vraca podatak o tome da li je proizvod patent.
 * @return <ul>
	 * 		<li> true - ako je proizvod preduzeca patent. </li>
	 * 		<li> false - ako proizvod nije patent. </li>
	 * </ul> */
public boolean isPatent() {
	return patent;
}
/**
 * Postavlja podatak o tome da li je proizvod patent, ili ne.
 * @param patent Podatak o patentu.
 */
public void setPatent(boolean patent) {
	this.patent = patent;
}
/**
 * Vraca vek trajanja proizvoda u mesecima.
 * @return Vek trajanja proizvoda izrazen u mesecima.
 */
public int getVekTrajanjaUMesecima() {
	return vekTrajanjaUMesecima;
}
/**
 * Postavlja vek trajanja proizvoda u mesecima.
 * @param vekTrajanjaUMesecima Vek trajanja proizvoda izrazen u mesecima.
 * @throws IllegalArgumentException kada je vek trajanja proizvoda kraci od jednog meseca.

 */
public void setVekTrajanjaUMesecima(int vekTrajanjaUMesecima) {
    if(vekTrajanjaUMesecima<=0) throw new IllegalArgumentException("Vek trajanja ne moze biti kraci od 1 meseca.");

	this.vekTrajanjaUMesecima = vekTrajanjaUMesecima;
}
/**
 * Vraca datum pocetka proizvodnje proizvoda, tj. onaj datum kada je proizvod dodat u bazu.
 * @return Datum pocetka proizvodnje proizvoda.
 */
public Date getDatumPocetkaProizvodnje() {
	return datumPocetkaProizvodnje;
}
/**
 * Postavlja datum pocetka proizvodnje proizvoda, tj. onaj datum kada je proizvod dodat u bazu.
 * @param datumPocetkaProizvodnje Datum pocetka proizvodnje proizvoda.
 * @throws IllegalArgumentException kada je datum pocetka proizvodnje proizvoda datum kasniji u odnosu na danasnji datum.
 * @throws NullPointerException kada je datum pocetka proizvodnje proizvoda null.
 */
public void setDatumPocetkaProizvodnje(Date datumPocetkaProizvodnje) {
	if(datumPocetkaProizvodnje==null) throw new NullPointerException("Datum pocetka proizvodnje proizvoda ne sme biti null");
    if(datumPocetkaProizvodnje.after(new Date())) throw new IllegalArgumentException("Datum pocetka proizvodnje proizvoda ne moze biti posle danasnjeg datuma");
	this.datumPocetkaProizvodnje = datumPocetkaProizvodnje;
}
/**
 * Vraca informacije o Korisniku koji je uneo proizvod u sistem.
 * @return Korisnik koji je uneo proizvod u sistem.
 */
public Korisnik getKorisnik() {
	return korisnik;
}
/**
 * Postavlja informacije o Korisniku koji je uneo proizvod u sistem.
 * @param korisnik Korisnik koji je uneo proizvod u sistem.
  * @throws NullPointerException kada je korisnik nadlezan za proizvod null.

 */
public void setKorisnik(Korisnik korisnik) {
	if(korisnik==null) throw new NullPointerException("Korisnik ne sme biti null");

	this.korisnik = korisnik;
}
/**
 * Vraca sve Elemente Proizvoda koji su neophodni za proizvodnju istog.
 * @return Lista elemenata proizvoda potrebnih za njegovu proizvodnju.
 */
public ArrayList<ElementProizvoda> getSastavnica() {
	return sastavnica;
}
/**
 * Postavlja sve Elemente Proizvoda koji su neophodni za proizvodnju istog.
 * @param sastavnica Lista elemenata proizvoda potrebnih za njegovu proizvodnju.
 * @throws IllegalArgumentException kada je lista elemenata proizvoda prazna.
 * @throws NullPointerException kada je lista elemenata proizvoda null.
 * 
 */
public void setSastavnica(ArrayList<ElementProizvoda> sastavnica) {
	if(sastavnica==null) throw new NullPointerException("Lista elemenata proizvoda ne sme biti null");
    if(sastavnica.size()==0) throw new IllegalArgumentException("Lista elemenata proizvoda ne moze biti prazna");
	this.sastavnica = sastavnica;
}


}
