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
	if(proizvodnja==null) throw new NullPointerException("Proizvodnja ne sme biti null");

	this.proizvodnja = proizvodnja;
}

public long getRbr() {
	return rbr;
}

public void setRbr(long rbr) {
    if(rbr<=0) throw new IllegalArgumentException("Kao redni broj moze se dodeliti samo pozitivan ceo broj.");
	this.rbr = rbr;
}

public Proizvod getProizvod() {
	return proizvod;
}

public void setProizvod(Proizvod proizvod) {
	if(proizvod==null) throw new NullPointerException("Proizvod ne sme biti null");

	this.proizvod = proizvod;
}

public JedinicaMere getJedinicaMere() {
	return jedinicaMere;
}

public void setJedinicaMere(JedinicaMere jedinicaMere) {
	if(jedinicaMere==null) throw new NullPointerException("Jedinica mere ne sme biti null");

	this.jedinicaMere = jedinicaMere;
}

public double getKolicina() {
	return kolicina;
}

public void setKolicina(double kolicina) {
    if(kolicina<0) throw new IllegalArgumentException("Kolicina ne moze biti manja od 0.");
	this.kolicina = kolicina;
}


}
