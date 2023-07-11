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
    if(materijalID<=0) throw new IllegalArgumentException("Kao ID moze se dodeliti samo pozitivan ceo broj.");

	this.materijalID = materijalID;
}

public String getNazivMaterijala() {
	return nazivMaterijala;
}

public void setNazivMaterijala(String nazivMaterijala) {
	if(nazivMaterijala==null) throw new NullPointerException("Naziv materijala ne sme biti null");
    if(nazivMaterijala.isEmpty()) throw new IllegalArgumentException("Naziv materijala ne sme biti prazan");
	this.nazivMaterijala = nazivMaterijala;
}

public String getOpisMaterijala() {
	return opisMaterijala;
}

public void setOpisMaterijala(String opisMaterijala) {
	if(opisMaterijala==null) throw new NullPointerException("Opis materijala ne sme biti null");
    if(opisMaterijala.isEmpty()) throw new IllegalArgumentException("Opis materijala ne sme biti prazan");
	this.opisMaterijala = opisMaterijala;
}

public double getKolicinaNaStanju() {
	return kolicinaNaStanju;
}

public void setKolicinaNaStanju(double kolicinaNaStanju) {
    if(kolicinaNaStanju<0) throw new IllegalArgumentException("Kolicina ne moze biti manja od 0.");

	this.kolicinaNaStanju = kolicinaNaStanju;
}


}
