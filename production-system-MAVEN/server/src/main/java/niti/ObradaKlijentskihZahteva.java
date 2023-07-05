package niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import domen.Grad;
import domen.JedinicaMere;
import domen.Korisnik;
import domen.Materijal;
import domen.Pogon;
import domen.Proizvod;
import domen.Proizvodnja;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
/**
 * Klasa ObradaKlijentskihZahteva omogucuje komunikaciju sa svakim klijentom
 * ponaosob. Obradjuje njihove zahteve i kreira i salje odgovrajajuce odgovore. Nasledjuje klasu Thread.
 * Sadrzi soket {link Socket}.
 * @see Thread
 * @author Mirjana Dimitrijevic
 *
 */
public class ObradaKlijentskihZahteva extends Thread{
	/**
	 * Soket sluzi za komunikaciju izmedju klijenta i servera.
	 */
Socket s;

/**
 * Kreira objekat klase ObradaKlijentskihZahteva na osnovu zadatog
 * soketa.
 * @param s Soket za uspostavljanje komunikacije izmedju servera i nekog klijenta.
 */
public ObradaKlijentskihZahteva(Socket s) {
	this.s = s;
}
/**
 * Metoda run specificna je za niti, pokrece se kada se pokrene i nit.
 * Ova metoda sve vreme osluskuje da li je stigao zahtev od klijenta
 * za koji je soket i kreiran. Kada zahtev stigne, kreira se odgovor,
 * a zatim se na osnovu sistemske operacije koju je korisnik pokrenuo,
 * odgovoru dodeljuju odredjeni objekti. Metoda sve vreme komunicira
 * sa Kontrolerom koji izvrsava sistemske operacije. Na samom kraju,
 * odgovor se salje klijentu.
 */
@Override
	public void run() {
	while (true) {
		KlijentskiZahtev kz= primiZahtev();
		ServerskiOdgovor so= new ServerskiOdgovor();
		switch (kz.getOperacija()) {
		case Operacije.LOGIN:
			HashMap<String, String> mapa=(HashMap<String, String>) kz.getParametar();
			String un= mapa.get("a");
			String pass= mapa.get("b");
			Korisnik kor= Kontroler.getInstance().login(un,pass);
			so.setOdgovor(kor);
			break;
		case Operacije.REGISTRACIJA:
			Korisnik korisnik= (Korisnik) kz.getParametar();
			boolean uspesnoReg=Kontroler.getInstance().register(korisnik);
			System.out.println(uspesnoReg);
			so.setOdgovor(uspesnoReg);
			break;
		case Operacije.PRIKAZI_SVE_MATERIJALE:
			ArrayList<Materijal> materijali= Kontroler.getInstance().vratiMaterijale();
			so.setOdgovor(materijali);
			break;
		case Operacije.SACUVAJ_MATERIJAL:
			Materijal materijal= (Materijal) kz.getParametar();
			boolean uspesnoMat= Kontroler.getInstance().sacuvajMaterijal(materijal);
			so.setOdgovor(uspesnoMat);
			break;
		case Operacije.PRIKAZI_SVE_POGONE:
			ArrayList<Pogon> pogoni= Kontroler.getInstance().vratiPogone();
			so.setOdgovor(pogoni);
			break;
		case Operacije.PRIKAZI_SVE_KORISNIKE:
			ArrayList<Korisnik> korisnici= Kontroler.getInstance().vratiKorisnike();
			so.setOdgovor(korisnici);
			break;
		case Operacije.PRIKAZI_SVE_GRADOVE:
			ArrayList<Grad> gradovi= Kontroler.getInstance().vratiGradove();
			so.setOdgovor(gradovi);
			break;
		case Operacije.SACUVAJ_POGON:
			Pogon pogon= (Pogon) kz.getParametar();
			boolean uspesnoPogon= Kontroler.getInstance().sacuvajPogon(pogon);
			so.setOdgovor(uspesnoPogon);
			break;
		case Operacije.IZMENI_POGON:
			Pogon pogonIzmena= (Pogon) kz.getParametar();
			boolean uspesnoIzmeniPogon=Kontroler.getInstance().izmeniPogon(pogonIzmena);
			so.setOdgovor(uspesnoIzmeniPogon);
			break;
		case Operacije.PRIKAZI_SVE_JM:
			ArrayList<JedinicaMere> jms= Kontroler.getInstance().vratiJediniceMere();
			so.setOdgovor(jms);
			break;
			
		case Operacije.SACUVAJ_PROIZVOD:
			Proizvod proizvod= (Proizvod) kz.getParametar();
			boolean uspesnoSacuvajProizvod= Kontroler.getInstance().sacuvajProizvod(proizvod);
			so.setOdgovor(uspesnoSacuvajProizvod);
			break;
		case Operacije.PRIKAZI_SVE_PROIZVODE:
			ArrayList<Proizvod> proizvodi= Kontroler.getInstance().vratiProizvode();
			so.setOdgovor(proizvodi);
			break;
			
		case Operacije.OBRISI_PROIZVOD:
			Proizvod proizvodBris= (Proizvod) kz.getParametar();
			boolean uspesnoObrisanProizvod= Kontroler.getInstance().obrisiProizvod(proizvodBris);
			so.setOdgovor(uspesnoObrisanProizvod);
			break;
		case Operacije.SACUVAJ_PROIZVODNJU:
			Proizvodnja proizvodnja= (Proizvodnja) kz.getParametar();
			boolean uspesnoSacProizvodnja= Kontroler.getInstance().sacuvajProizvodnju(proizvodnja);
			so.setOdgovor(uspesnoSacProizvodnja);
			break;
		}
		posaljiOdgovor(so);
	}
	}
/**
 * Salje odgovor klijentu.
 * Koristi klasu {@link ObjectOutputStream} za slanje odgovora.
 * @param so Serverski odgovor koji se salje klijentu.
 * Baca IOException ako serverski odgovor nije serijalizovan.
 */
public void posaljiOdgovor(ServerskiOdgovor so) {
	try {
		ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(so);
		oos.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
/**
 * Prima zahtev od klijenta.
 * Koristi klasu {@link ObjectInputStream} za prijem zahteva.
 * 
 * Baca IOException kada se desi greska u toku deserijalizacije klijentskog zahteva.
 * Baca ClassNotFoundException u slucaju da klasa KlijentskiZahtev nije pronadjena. 
 * @return Klijentski zahtev koji je procitan.
 */
public KlijentskiZahtev primiZahtev() {
	try {
		ObjectInputStream ois= new ObjectInputStream(s.getInputStream());
		return (KlijentskiZahtev) ois.readObject();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return null;
}


}
