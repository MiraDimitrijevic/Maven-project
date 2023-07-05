package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Klasa PokreniServer pokrece server na portu 9000, osluskuje klijente
 * i omogucava im da se povezu na server, ostvarivsi komunikaciju sa njim. Nasledjuje klasu Thread.
 * Sadrzi serverski soket {link ServerSocket}.
 * @see Thread
 * @author Mirjana Dimitrijevic
 *
 */
public class PokreniServer extends Thread {
	/**
	 * Serverski Soket koji sve vreme od trenutka pokretanja osluskuje.
	 */
ServerSocket ss;
/**
 * Metoda run specificna je za niti, pokrece se kada se pokrene i nit.
 * Ovde, metoda pokrece serverski soket na portu 9000, i ceka da klijent
 * ostvari komunikaciju. Osluskuje sve vreme, komunikaciju moze ostvartiti
 * vise klijenta.
 *  Svaki put kad klijent ostvari komunikaciju, kreira se nova instanca
 *  klase ObradaKlijentskihZahteva koja za svakog klijenta posebno
 *  obradjuje zahteve koje on salje i salje mu odgovarajuce odgovore.
 *  Baca IOException Kada soket ne moze da osluskuje na portu 9000 (kada je port zauzet).
 *  
 */
@Override
	public void run() {
		try {
			ss= new ServerSocket(9000);
			while (true) {
Socket s= ss.accept();
System.out.println("Klijent se povezao!");
ObradaKlijentskihZahteva nit= new ObradaKlijentskihZahteva(s);
nit.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
