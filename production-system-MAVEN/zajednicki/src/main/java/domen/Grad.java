package domen;

import java.io.Serializable;

public class Grad implements Serializable{
private long gradID;
private String nazivGrada;

public Grad() {
}

public Grad(long gradID, String nazivGrada) {
	super();
	this.gradID = gradID;
	this.nazivGrada = nazivGrada;
}

public long getGradID() {
	return gradID;
}

public void setGradID(long gradID) {
     if(gradID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");
	this.gradID = gradID;
}

public String getNazivGrada() {
	return nazivGrada;
}

public void setNazivGrada(String nazivGrada) {
    if(nazivGrada==null) throw new NullPointerException("Naziv grada ne sme biti null");
    if(nazivGrada.isEmpty()) throw new IllegalArgumentException("Naziv grada ne sme biti prazan");

	this.nazivGrada = nazivGrada;
}

@Override
	public String toString() {
		return nazivGrada;
	}
}
