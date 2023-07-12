package domen;

import java.io.Serializable;
/**
 * Klasa Grad predstavlja odredjeni grad u Srbiji. Implementira interfejs Serializable.
 * 
 * Sadrzi jedinstveni identifikator grada i naziv grada.
 * 
 **@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class Grad implements Serializable{
	/**
	 * Jedinstveni identifikator grada.
	 */
private long gradID;
/**
 * Naziv grada.
 */
private String nazivGrada;
/**
 * Kreira prazan objekat klase Grad.
 */
public Grad() {
}

/**
 * Kreira objekat klase Grad sa zadatim identifikatorom i nazivom.
 * @param gradID Jedinstveni identifikator grada.
 * @param nazivGrada Naziv grada.
 */
public Grad(long gradID, String nazivGrada) {
	super();
	this.gradID = gradID;
	this.nazivGrada = nazivGrada;
}

/**
 * Vraca jedinstveni identifikator grada.
 * @return Jedinstveni identifikator grada.
 */
public long getGradID() {
	return gradID;
}
/**
 * Postavlja jedinstveni identifikator grada.
 * @param gradID Jedinstveni identifikator grada.
 * @throws IllegalArgumentException kada je id manji od 1.
 */
public void setGradID(long gradID) {
     if(gradID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	this.gradID = gradID;
}
/**
 * Vraca naziv grada.
 * @return Naziv grada.
 */
public String getNazivGrada() {
	return nazivGrada;
}
/**
 * Postavlja naziv grada.
 * @param nazivGrada Naziv grada.
 * @throws IllegalArgumentException kada je naziv grada prazan string.
 * @throws NullPointerException kada je naziv grada null.

 */
public void setNazivGrada(String nazivGrada) {
    if(nazivGrada==null) throw new NullPointerException("Naziv grada ne sme biti null");
    if(nazivGrada.isEmpty()) throw new IllegalArgumentException("Naziv grada ne sme biti prazan");

	this.nazivGrada = nazivGrada;
}
/**
 * Vraca string reprezentaciju Grada.
 * @return String reprezentacija grada.
 */
@Override
	public String toString() {
		return nazivGrada;
	}
}
