package domen;

import java.io.Serializable;
/**
 * Klasa Materijal predstavlja ulaz procesa proizvodnje. Implementira interfejs Serializable.
 * 
 * Sadrzi jedinstveni identifikator materijala, naziv materijala, njegov opis i kolicinu
 * koja se nalazi na stanju.
 * 
 **@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class Materijal implements Serializable {
	/**
	 * Jedinstveni identifikator materijala.
	 */
private long materijalID;
/**
 * Naziv materijala.
 */
private String nazivMaterijala;
/**
 * Detaljniji opis materijala.
 */
private String opisMaterijala;
/**
 * Kolicina materijala koja se nalazi u magacinu preduzeca.
 */
private double kolicinaNaStanju;
/**
 * Kreira prazan objekat klase Materijal.
 */
public Materijal() {
}
/**
 * Kreira objekat klase Materijal, sa odgovarajucim identifikatorom, nazivom tog materijala,
 * njegovim opisom i kolicinom na stanju.
 * @param materijalID Identifikator materijala.
 * @param nazivMaterijala Naziv materijala. 
 * @param opisMaterijala Opis materijala.
 * @param kolicinaNaStanju Kolicina materijala na stanju.
 */
public Materijal(long materijalID, String nazivMaterijala, String opisMaterijala, double kolicinaNaStanju) {
	super();
	this.materijalID = materijalID;
	this.nazivMaterijala = nazivMaterijala;
	this.opisMaterijala = opisMaterijala;
	this.kolicinaNaStanju = kolicinaNaStanju;
}

/**
 * Vraca string reprezentaciju Materijala.
 * @return String reprezentacija materijala.
 */
@Override
	public String toString() {
return nazivMaterijala;
	}

/**
 * Vraca jedinstveni identifikator materijala.
 * @return Jedinstveni identifikator materijala.
 */

public long getMaterijalID() {
	return materijalID;
}
/**
 * Postavlja jedinstveni identifikator materijala.
 * @param materijalID Jedinstveni identifikator materijala.
 */

public void setMaterijalID(long materijalID) {
	this.materijalID = materijalID;
}
/**
 * Vraca naziv materijala.
 * @return Naziv materijala.
 */

public String getNazivMaterijala() {
	return nazivMaterijala;
}
/**
 * Postavlja naziv materijala.
 * @param nazivMaterijala Naziv materijala.
 */

public void setNazivMaterijala(String nazivMaterijala) {
	this.nazivMaterijala = nazivMaterijala;
}
/**
 * Vraca opis materijala.
 * @return Opis materijala.
 */

public String getOpisMaterijala() {
	return opisMaterijala;
}
/**
 * Postavlja opis materijala.
 * @param opisMaterijala Opis materijala.
 */

public void setOpisMaterijala(String opisMaterijala) {
	this.opisMaterijala = opisMaterijala;
}
/**
 * Vraca kolicinu materijala koja se nalazi na stanju u magacinu.
 * @return Kolicina materijala na stanju.
 */

public double getKolicinaNaStanju() {
	return kolicinaNaStanju;
}
/**
 * Postavlja kolicinu materijala koja se nalazi na stanju u magacinu.
 * @param kolicinaNaStanju Kolicina materijala na stanju.
 */
public void setKolicinaNaStanju(double kolicinaNaStanju) {
	this.kolicinaNaStanju = kolicinaNaStanju;
}


}
