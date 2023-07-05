package transfer;

import java.io.Serializable;
/**
 * Klasa Serverski odgovor predstavlja odgovor servera nakon sto je izvrsio 
 * odredjenu sistemsku operaciju, a implementira interfejs Serializable.
 * 
 * Sadrzi objekat koji predstavlja odgovor sistema klijentu nakon izvrsene
 * operacije, i odgovarajucu poruku koju sistem salje.
 * 
 *@see Serializable
 * @author Mirjana Dimitrijevic
 *
 */
public class ServerskiOdgovor implements Serializable{
/**
 * Objekat koji stize do klijenta, predstavlja odgovor na odredjeni zahtev
 * i zavisi od prirode sistemske operacije.	
 */
private	Object odgovor;
/**
 * Poruka koja se eventualno salje klijentu nakon izvrsene sistemske operacije.
 */
private	String poruka;
	
	
/**
 * Kreira prazan objekat odgovora servera klijentu.
 */
public ServerskiOdgovor() {
}


/**
 * Kreira objekat serverskog odgovora sa zadatim objektom koji je klijent
 * trazio u zahtevu i porukom.
 * @param odgovor Objekat koji zelimo da posaljemo klijentu u odgovoru.
 * @param poruka Odgovarajuca poruka koju zelimo da prosledimo klijentu uz odgovor.
 */
 
public ServerskiOdgovor(Object odgovor, String poruka) {
	super();
	this.odgovor = odgovor;
	this.poruka = poruka;
}

/**
 * Vraca objekat koji se salje klijentu nakon sto se sistemska operacija izvrsila.
 * @return Objekat koji se salje klijentu nakon izvrsenja odredjene operacije.
 */


public Object getOdgovor() {
	return odgovor;
}

/**
 * Postavlja objekat koji zelimo da posaljemo klijentu nakon sto se sistemska operacija izvrsila.
 * @param odgovor Objekat koji je potrebno poslati klijentu nakon izvrsenja odredjene operacije.
 */

public void setOdgovor(Object odgovor) {
	this.odgovor = odgovor;
}


/**
 * Vraca poruku koja se eventualno salje klijentu uz odgovor nakon sto se sistemska operacija izvrsila.
 * @return Poruka koja se salje klijentu nakon izvrsenja odredjene operacije.
 */

public String getPoruka() {
	return poruka;
}

/**
 * Postavlja poruku koju je potrebno poslati klijentu uz odgovor nakon sto se sistemska operacija izvrsila.
 * @param poruka Poruka koja se salje klijentu nakon izvrsenja odredjene operacije.
 */

public void setPoruka(String poruka) {
	this.poruka = poruka;
}




}
