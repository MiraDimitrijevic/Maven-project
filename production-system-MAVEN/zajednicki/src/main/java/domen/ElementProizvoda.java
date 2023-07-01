package domen;

import java.io.Serializable;
/**
 * Klasa ElementProizvoda predstavlja element koji ulazi u sastav proizvoda. Implementira interfejs Serializable.
 * 
 * Sastoji se od materijala od koga se proizvod proizvodi, kolicine materijala koja
 * ulazi u sastav proizvoda, jedinice mere u kojoj je kolicina izrazena, proizvoda
 * u ciji sastav ovaj element ulazi i jedinstvenog rednog broja elementa u sastavu tog proizvoda.
 * 
 **@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class ElementProizvoda implements Serializable{
	/**
	 * Proizvod u cijem je sastavu ovaj element.
	 */
private Proizvod proizvod;
/**
 * Jedinstveni redni broj elementa u sastavnici proizvoda.
 */
private long rbr;
/**
 * Materijal na koji se ovaj element odnosi.
 */
private Materijal materijal;
/**
 * Jedinica mere u kojoj je kolicina materijala izrazena.
 */
private JedinicaMere jedinicaMere;
/**
 *Kolicina materijala potrebna za proizvodnju.
 */
private double kolicina;
/**
 * Kreira prazan objekat klase ElementProizvoda.
 */
public ElementProizvoda() {
}
/**
 * Kreira objekat klase ElementProizvoda, sa zadatim proizvodom, rednim brojem elementa,
 * materijalom, jedinicom mere u kojoj je izrazena kolicina materijala, i kolicinom 
 * materijala potrebnom za proizvodnju.
 * @param proizvod Proizvod ciji je objekat element.
 * @param rbr Redni broj elementa u sastavnici proizvoda.
 * @param materijal Materijal koji element predstavlja.
 * @param jedinicaMere Jedinica mere u kojoj se kolicina materijala izrazava.
 * @param kolicina Kolicina materijala potrebna za proizvodnju proizvoda.
 */
public ElementProizvoda(Proizvod proizvod, long rbr, Materijal materijal, JedinicaMere jedinicaMere, double kolicina) {
	super();
	this.proizvod = proizvod;
	this.rbr = rbr;
	this.materijal = materijal;
	this.jedinicaMere = jedinicaMere;
	this.kolicina = kolicina;
}
/**
 * Vraca proizvod ciji je objekat element.
 * @return Proizvod na koji se element odnosi.
 */
public Proizvod getProizvod() {
	return proizvod;
}
/**
 * Postavlja proizvod ciji je objekat element.
 * @param proizvod Proizvod na koji se element odnosi.
 */
public void setProizvod(Proizvod proizvod) {
	this.proizvod = proizvod;
}
/**
 * Vraca redni broj elementa u sastavnici proizvoda.
 * @return Redni broj elementa specificiranog proizvoda.
 */
public long getRbr() {
	return rbr;
}
/**
 * Postavlja redni broj elementa u sastavnici proizvoda.
 * @param rbr Redni broj elementa specificiranog proizvoda.
 */
public void setRbr(long rbr) {
	this.rbr = rbr;
}
/**
 * Vraca materijal na koji se element proizvoda odnosi.
 * @return Materijal elementa proizvoda.
 */
public Materijal getMaterijal() {
	return materijal;
}
/**
 * Postavlja materijal na koji se element proizvoda odnosi.
 * @param materijal Materijal elementa proizvoda.
 */
public void setMaterijal(Materijal materijal) {
	this.materijal = materijal;
}
/**
 * Vraca jedinicu mere u kojoj je izrazena kolicina materijala potrebna za proizvodnju.
 * @return Jedinica mere u kojoj je izrazena kolicina materijala.
 */
public JedinicaMere getJedinicaMere() {
	return jedinicaMere;
}
/**
 * Postavlja jedinicu mere u kojoj je izrazena kolicina materijala potrebna za proizvodnju.
 * @param jedinicaMere Jedinica mere u kojoj je izrazena kolicina materijala.
 */
public void setJedinicaMere(JedinicaMere jedinicaMere) {
	this.jedinicaMere = jedinicaMere;
}
/**
 * Vraca kolicinu materijala potrebnog za proizvodnju odredjenog proizvoda.
 * @return Kolicina materijala.
 */
public double getKolicina() {
	return kolicina;
}
/**
 * Postavlja kolicinu materijala potrebnog za proizvodnju odredjenog proizvoda.
 * @param kolicina Kolicina materijala.
 */
public void setKolicina(double kolicina) {
	this.kolicina = kolicina;
}


}
