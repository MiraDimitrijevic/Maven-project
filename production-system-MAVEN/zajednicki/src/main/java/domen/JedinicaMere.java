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
	JMID = jMID;
}

public String getNazivJM() {
	return nazivJM;
}

public void setNazivJM(String nazivJM) {
	this.nazivJM = nazivJM;
}

@Override
	public String toString() {
	return nazivJM;
	}
}
