package logika;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
/**
 *Klasa Komunikacija uspostavlja komunikaciju klijenta sa serverom.
 *U pitanju je singlton, sadrzi i objekat komunikacija. 
 * @author Mirjana Dimitrijevic
 *
 */
public class Komunikacija {
	/**
	 * Soket za komunikaciju sa serverom.
	 */
private Socket s;	
/**
 * Instanca klase Komunikacija.
 */
private static Komunikacija instance;
/**
 * Vraca instancu klase Komunikacija.
 * Singlton klasa moze imati samo jedan objekat, pa tako pri svakom 
 * instanciranju ove klase, ta instanca pokazuje na jednu i jedinu
 * instancu koja je kreirana kada se ova metoda prvi put pozvala.
 * @return Instanca klase Komunikacija.
 */
public static Komunikacija getInstance() {
	if(instance==null) instance= new Komunikacija();
	return instance;
}
/**
 * Kreira objekat klase Komunikacija, i otvara soket na portu 9000,
 * cime se omogucava razmena podataka sa serverom.
 
 * @throws IOException kada je port 9000 zauzet.
 */
public Komunikacija() {
	try {
		s= new Socket("localhost" ,9000);
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
/**
 * Salje zahtev serveru.
 * Koristi klasu {@link ObjectOutputStream} za slanje zahteva.
 * @param kz Zahtev klijenta koji se salje serveru.
 * @throws IOException ako klijentski zahtev nije serijalizovan.
 */
public void posaljiZahtev(KlijentskiZahtev kz) {
	try {
		ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(kz);
		oos.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
/**
 * Prima odgovor od servera.
 * Koristi klasu {@link ObjectInputStream} za prijem odgovora.
 * 
 * @throws IOException kada se desi greska u toku deserijalizacije serverskog odgovora.
 * @throws ClassNotFoundException u slucaju da klasa ServerskiOdgovor nije pronadjena. 
 * @return Serverski odgovor koji je procitan.
 */
public ServerskiOdgovor primiOdgovor() {
	try {
		ObjectInputStream ois= new ObjectInputStream(s.getInputStream());
		return (ServerskiOdgovor) ois.readObject();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return null;
}
}
