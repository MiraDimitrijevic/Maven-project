package domen;

import java.io.Serializable;
/**
 * Klasa JedinicaMere predstavlja jedinicu u kojoj se moze meriti
 * proizvod ili materijal. Implementira interfejs Serializable.
 * 
 * Sadrzi jedinstveni identifikator jedinice mere i naziv jedinice mere.
 * 
 **@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class JedinicaMere implements Serializable {
	/**
	 * Jedinstveni identifikator jedinice mere.
	 */
private long JMID;
/**
 *  Naziv jedinice mere. (kg, m, l...)
 */
private String nazivJM;
/**
 * Kreira prazan objekat klase JedinicaMere.
 */
public JedinicaMere() {
}

/**
 * Kreira objekat klase JedinicaMere sa zadatim identifikatorom i nazivom.
 * @param jMID Jedinstveni identifikator jedinice mere.
 * @param nazivJM Tip jedinice mere.
 */
public JedinicaMere(long jMID, String nazivJM) {
	super();
	JMID = jMID;
	this.nazivJM = nazivJM;
}
/**
 * Vraca jedinstveni identifikator jedinice mere.
 * @return Jedinstveni identifikator jedinice mere.
 */
public long getJMID() {
	return JMID;
}
/**
 * Postavlja jedinstveni identifikator jedinice mere.
 * @param jMID Jedinstveni identifikator jedinice mere.
 * @throws IllegalArgumentException kada je id manji od 1.

 */
public void setJMID(long jMID) {
    if(jMID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	JMID = jMID;
}
/**
 * Vraca naziv jedinice mere.
 * @return Tip jedinice mere.
 */
public String getNazivJM() {
	return nazivJM;
}
/**
 * Postavlja naziv jedinice mere.
 * @param nazivJM Tip jedinice mere.
 * @throws IllegalArgumentException kada je naziv jedinice mere prazan string.
 * @throws NullPointerException kada je naziv jedinice mere null.

 */
public void setNazivJM(String nazivJM) {
	 if(nazivJM==null) throw new NullPointerException("Naziv jedinice mere ne sme biti null");
	    if(nazivJM.isEmpty()) throw new IllegalArgumentException("Naziv jedinice mere ne sme biti prazan");

	this.nazivJM = nazivJM;
}

/**
 * Vraca string reprezentaciju Jedinice mere.
 * @return String reprezentacija jedinice mere.
 */
@Override
	public String toString() {
	return nazivJM;
	}
}
