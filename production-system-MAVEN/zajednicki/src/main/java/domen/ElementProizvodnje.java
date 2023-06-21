package domen;

import java.io.Serializable;

public class ElementProizvodnje implements Serializable {
private Proizvodnja proizvodnja;
private long rbr;
private Proizvod proizvod;
private JedinicaMere jedinicaMere;
private double kolicina;

public ElementProizvodnje() {
}


public ElementProizvodnje(Proizvodnja proizvodnja, long rbr, Proizvod proizvod, JedinicaMere jedinicaMere,
		double kolicina) {
	super();
	this.proizvodnja = proizvodnja;
	this.rbr = rbr;
	this.proizvod = proizvod;
	this.jedinicaMere = jedinicaMere;
	this.kolicina = kolicina;
}


public Proizvodnja getProizvodnja() {
	return proizvodnja;
}

public void setProizvodnja(Proizvodnja proizvodnja) {
	this.proizvodnja = proizvodnja;
}

public long getRbr() {
	return rbr;
}

public void setRbr(long rbr) {
	this.rbr = rbr;
}

public Proizvod getProizvod() {
	return proizvod;
}

public void setProizvod(Proizvod proizvod) {
	this.proizvod = proizvod;
}

public JedinicaMere getJedinicaMere() {
	return jedinicaMere;
}

public void setJedinicaMere(JedinicaMere jedinicaMere) {
	this.jedinicaMere = jedinicaMere;
}

public double getKolicina() {
	return kolicina;
}

public void setKolicina(double kolicina) {
	this.kolicina = kolicina;
}


}
