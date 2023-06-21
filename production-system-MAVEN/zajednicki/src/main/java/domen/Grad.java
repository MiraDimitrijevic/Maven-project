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
	this.gradID = gradID;
}

public String getNazivGrada() {
	return nazivGrada;
}

public void setNazivGrada(String nazivGrada) {
	this.nazivGrada = nazivGrada;
}

@Override
	public String toString() {
		return nazivGrada;
	}
}
