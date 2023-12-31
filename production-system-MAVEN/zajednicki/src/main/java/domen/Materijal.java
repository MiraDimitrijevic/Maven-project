package domen;

import java.io.Serializable;
import java.util.Objects;
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
 * @throws IllegalArgumentException kada je id manji od 1.
 */

public void setMaterijalID(long materijalID) {
    if(materijalID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");

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
 * @throws IllegalArgumentException kada je naziv materijala prazan string.
 * @throws NullPointerException kada je naziv materijala null.
 */

public void setNazivMaterijala(String nazivMaterijala) {
	if(nazivMaterijala==null) throw new NullPointerException("Naziv materijala ne sme biti null");
    if(nazivMaterijala.isEmpty()) throw new IllegalArgumentException("Naziv materijala ne sme biti prazan");
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
 * @throws IllegalArgumentException kada je opis materijala prazan string.
 * @throws NullPointerException kada je opis materijala null.
 */

public void setOpisMaterijala(String opisMaterijala) {
	if(opisMaterijala==null) throw new NullPointerException("Opis materijala ne sme biti null");
    if(opisMaterijala.isEmpty()) throw new IllegalArgumentException("Opis materijala ne sme biti prazan");
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
 * @throws IllegalArgumentException kada je kolicina manja od 0.
 */
public void setKolicinaNaStanju(double kolicinaNaStanju) {
    if(kolicinaNaStanju<0) throw new IllegalArgumentException("Kolicina ne moze biti manja od 0.");

	this.kolicinaNaStanju = kolicinaNaStanju;
}
/**
 * Poredi dva materijala prema identifikatoru i nazivu.
 * 
 * @return 
 * <ul>
 * 		<li> true - ako je unet isti objekat ili ako su id i naziv materijala isti. </li>
 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase Materijal. </li>
 * </ul>
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Materijal other = (Materijal) obj;
	return materijalID == other.materijalID && Objects.equals(nazivMaterijala, other.nazivMaterijala);
}




}
