package transfer;

import java.io.Serializable;
/**
 * Klasa Klijentski zahtev predstavlja zahtev za izvrsenje odredjene sistemske 
 * operacije, a implementira interfejs Serializable.
 * 
 * Sadrzi redni broj operacije koju je potrebno izvrsiti i objekat koji se salje
 * serveru, kako bi se ova operacija mogla izvrsiti.
 * 
 * @see Serializable
 * @author Mirjana Dimitrijevic
 * 
 *
 */
public class KlijentskiZahtev implements Serializable {
/**
 * Redni broj sistemske operacije koja ce se izvrsiti.
 */
private int operacija;
/**
 * Objekat koji se salje serveru, zavisi od prirode operacije i neophodan je
 * kako bi se ona izvrsila.
 */
private Object parametar;
/**
 * Kreira prazan objekat zahteva za izvrsenje sistemske operacije.
 */
public KlijentskiZahtev() {
}  


/**
 * Kreira objekat klijentskog zahteva sa zadatom operacijom i parametrom zahteva.
 * @param operacija Redni broj operacije koju je potrebno izvrsiti.
 * @param parametar Ojekat koji se salje kako bi se operacija izvrsila.
 */
 
public KlijentskiZahtev(int operacija, Object parametar) {
	super();
	this.operacija = operacija;
	this.parametar = parametar;
}

/**
 * Vraca objekat koji se salje serveru kako bi se sistemska operacija izvrsila.
 * @return Objekat koji je neophodan za ivrsenje odredjene sistemske operacije.
 */


public Object getParametar() {
	return parametar;
}

/**
 * Postavlja redni broj operacije sistema.
 * @param operacija Redni broj sistemske operacije koji zadajemo.
 */

public void setOperacija(int operacija) {
	this.operacija = operacija;
}



/**
 * Postavlja objekat koji se salje serveru kako bi se sistemska operacija izvrsila.
 * @param parametar Objekat koji se zadaje kako bi ivrsenje odredjene sistemske operacije bilo omoguceno.
 */

public void setParametar(Object parametar) {
	this.parametar = parametar;
}

/**
 * Vraca redni broj operacije sistema.
 * @return Redni broj sistemske operacije.
 */

public int getOperacija() {
	return operacija;
}




}
