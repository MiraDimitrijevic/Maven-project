package domen;

import java.io.Serializable;

public class ElementProizvoda implements Serializable{
private Proizvod proizvod;
private long rbr;
private Materijal materijal;
private JedinicaMere jedinicaMere;
private double kolicina;

public ElementProizvoda() {
}

public ElementProizvoda(Proizvod proizvod, long rbr, Materijal materijal, JedinicaMere jedinicaMere, double kolicina) {
	super();
	this.proizvod = proizvod;
	this.rbr = rbr;
	this.materijal = materijal;
	this.jedinicaMere = jedinicaMere;
	this.kolicina = kolicina;
}

public Proizvod getProizvod() {
	return proizvod;
}

public void setProizvod(Proizvod proizvod) {
	this.proizvod = proizvod;
}

public long getRbr() {
	return rbr;
}

public void setRbr(long rbr) {
	this.rbr = rbr;
}

public Materijal getMaterijal() {
	return materijal;
}

public void setMaterijal(Materijal materijal) {
	this.materijal = materijal;
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
