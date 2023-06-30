package domen;

import java.io.Serializable;

public class Materijal implements Serializable {
private long materijalID;
private String nazivMaterijala;
private String opisMaterijala;
private double kolicinaNaStanju;

public Materijal() {
}

public Materijal(long materijalID, String nazivMaterijala, String opisMaterijala, double kolicinaNaStanju) {
	super();
	this.materijalID = materijalID;
	this.nazivMaterijala = nazivMaterijala;
	this.opisMaterijala = opisMaterijala;
	this.kolicinaNaStanju = kolicinaNaStanju;
}

@Override
	public String toString() {
return nazivMaterijala;
	}

public long getMaterijalID() {
	return materijalID;
}

public void setMaterijalID(long materijalID) {
	this.materijalID = materijalID;
}

public String getNazivMaterijala() {
	return nazivMaterijala;
}

public void setNazivMaterijala(String nazivMaterijala) {
	this.nazivMaterijala = nazivMaterijala;
}

public String getOpisMaterijala() {
	return opisMaterijala;
}

public void setOpisMaterijala(String opisMaterijala) {
	this.opisMaterijala = opisMaterijala;
}

public double getKolicinaNaStanju() {
	return kolicinaNaStanju;
}

public void setKolicinaNaStanju(double kolicinaNaStanju) {
	this.kolicinaNaStanju = kolicinaNaStanju;
}


}
