package domen;

import java.io.Serializable;
/**
 * Klasa ElementProizvodnje predstavlja element koji se proizvodi u odredjenoj seriji proizvodnje. Implementira interfejs Serializable.
 * 
 * Sastoji se od proizvoda koji se proizvodi, kolicine proizvoda koja
 * se proizvodi, jedinice mere u kojoj je kolicina izrazena, proizvodnje
 * u ciji sastav ovaj element ulazi i jedinstvenog rednog broja elementa te proizvodnje.
 * 
 **@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class ElementProizvodnje implements Serializable {
	/**
	 * Proizvodnja u koju je element ukljucen.
	 */
private Proizvodnja proizvodnja;
/**
 * Jedinstveni redni broj elementa proizvodnje.
 */
private long rbr;
/**
 * Proizvod na koji se ovaj element odnosi.
 */
private Proizvod proizvod;
/**
 * Jedinica mere u kojoj je kolicina proizvoda izrazena.
 */
private JedinicaMere jedinicaMere;
/**
 *Kolicina proizvoda koji se proizvodi u ovoj proizvodnji.
 */
private double kolicina;
/**
 * Kreira prazan objekat klase ElementProizvodnje.
 */
public ElementProizvodnje() {
}
/**
 * Kreira objekat klase ElementProizvodnje, sa zadatim proizvodom, rednim brojem elementa,
 * proizvodnjom kojoj element pripada, jedinicom mere u kojoj je izrazena kolicina proizvoda, i kolicinom 
 * proizvoda koji se proizvodi u seriji.
 * @param proizvodnja Proizvodnja kojoj element pripada.
 * @param rbr Redni broj elementa u seriji.
 * @param proizvod Proizvod koji se proizvodi.
 * @param jedinicaMere Jedinica mere u kojoj se kolicina proizvoda izrazava.
 * @param kolicina Kolicina proizvoda koja je rezultat procesa definisane proizvodnje.
 */

public ElementProizvodnje(Proizvodnja proizvodnja, long rbr, Proizvod proizvod, JedinicaMere jedinicaMere,
		double kolicina) {
	super();
	this.proizvodnja = proizvodnja;
	this.rbr = rbr;
	this.proizvod = proizvod;
	this.jedinicaMere = jedinicaMere;
	this.kolicina = kolicina;
}

/**
 * Vraca proizvodnju kojoj element pripada.
 * @return Proizvodnja na koju se element odnosi.
 */
public Proizvodnja getProizvodnja() {
	return proizvodnja;
}
/**
 * Postavlja proizvodnju kojoj element pripada.
 * @param proizvodnja Proizvodnja na koju se element odnosi.
 */
public void setProizvodnja(Proizvodnja proizvodnja) {
	if(proizvodnja==null) throw new NullPointerException("Proizvodnja ne sme biti null");

	this.proizvodnja = proizvodnja;
}
/**
 * Vraca redni broj proizvoda u definisanoj proizvodnji.
 * @return Redni broj elementa specificirane proizvodnje.
 */
public long getRbr() {
	return rbr;
}
/**
 * Postavlja redni broj proizvoda u definisanoj proizvodnji.
 * @param rbr Redni broj elementa specificirane proizvodnje.
 */
public void setRbr(long rbr) {
    if(rbr<=0) throw new IllegalArgumentException("Kao redni broj moze se dodeliti samo pozitivan ceo broj.");
	this.rbr = rbr;
}
/**
 * Vraca proizvod koji se proizvodi u seriji.
 * @return Proizvod na koji se element odnosi.
 */
public Proizvod getProizvod() {
	return proizvod;
}
/**
 * Postavlja proizvod koji se proizvodi u seriji.
 * @param proizvod Proizvod na koji se element odnosi.
 */
public void setProizvod(Proizvod proizvod) {
	if(proizvod==null) throw new NullPointerException("Proizvod ne sme biti null");

	this.proizvod = proizvod;
}
/**
 * Vraca jedinicu mere u kojoj je izrazena kolicina proizvoda koja predstavlja izlaz procesa proizvodnje.
 * @return Jedinica mere u kojoj je izrazena kolicina proizvoda.
 */
public JedinicaMere getJedinicaMere() {
	return jedinicaMere;
}
/**
 * Postavlja jedinicu mere u kojoj je izrazena kolicina proizvoda koja predstavlja izlaz procesa proizvodnje.
 * @param jedinicaMere Jedinica mere u kojoj je izrazena kolicina proizvoda.
 */
public void setJedinicaMere(JedinicaMere jedinicaMere) {
	if(jedinicaMere==null) throw new NullPointerException("Jedinica mere ne sme biti null");

	this.jedinicaMere = jedinicaMere;
}
/**
 * Vraca kolicinu proizvoda koja predstavlja izlaz procesa proizvodnje.
 * @return Kolicina proizvoda.
 */
public double getKolicina() {
	return kolicina;
}
/**
 * Postavlja kolicinu proizvoda koja predstavlja izlaz procesa proizvodnje.
 * @param kolicina Kolicina proizvoda.
 */
public void setKolicina(double kolicina) {
    if(kolicina<0) throw new IllegalArgumentException("Kolicina ne moze biti manja od 0.");
	this.kolicina = kolicina;
}


}
