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
	if(proizvod==null) throw new NullPointerException("Proizvod ne sme biti null");

	this.proizvod = proizvod;
}

public long getRbr() {
	return rbr;
}

public void setRbr(long rbr) {
    if(rbr<=0) throw new IllegalArgumentException("Kao redni broj moze se dodeliti samo pozitivan ceo broj.");
	this.rbr = rbr;
}

public Materijal getMaterijal() {
	return materijal;
}

public void setMaterijal(Materijal materijal) {
	if(materijal==null) throw new NullPointerException("Materijal ne sme biti null");

	this.materijal = materijal;
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
