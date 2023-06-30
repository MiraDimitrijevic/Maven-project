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

public class ObradaKlijentskihZahteva extends Thread{
Socket s;

public ObradaKlijentskihZahteva(Socket s) {
	this.s = s;
}

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

public void posaljiOdgovor(ServerskiOdgovor so) {
	try {
		ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(so);
		oos.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

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
