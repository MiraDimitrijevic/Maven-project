package niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import domen.Korisnik;
import domen.Materijal;
import domen.Pogon;
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
