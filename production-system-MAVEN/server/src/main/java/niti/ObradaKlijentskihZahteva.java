package niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
