package logika;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class Komunikacija {
private Socket s;
private static Komunikacija instance;
public static Komunikacija getInstance() {
	if(instance==null) instance= new Komunikacija();
	return instance;
}

public Komunikacija() {
	try {
		s= new Socket("localhost" ,9000);
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public void posaljiZahtev(KlijentskiZahtev kz) {
	try {
		ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(kz);
		oos.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

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
