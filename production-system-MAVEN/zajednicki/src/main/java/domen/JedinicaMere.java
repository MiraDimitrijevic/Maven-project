package domen;

import java.io.Serializable;

public class JedinicaMere implements Serializable {
private long JMID;
private String nazivJM;

public JedinicaMere() {
}

public JedinicaMere(long jMID, String nazivJM) {
	super();
	JMID = jMID;
	this.nazivJM = nazivJM;
}

public long getJMID() {
	return JMID;
}

public void setJMID(long jMID) {
    if(jMID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	JMID = jMID;
}

public String getNazivJM() {
	return nazivJM;
}

public void setNazivJM(String nazivJM) {
	 if(nazivJM==null) throw new NullPointerException("Naziv jedinice mere ne sme biti null");
	    if(nazivJM.isEmpty()) throw new IllegalArgumentException("Naziv jedinice mere ne sme biti prazan");

	this.nazivJM = nazivJM;
}

@Override
	public String toString() {
	return nazivJM;
	}
}
