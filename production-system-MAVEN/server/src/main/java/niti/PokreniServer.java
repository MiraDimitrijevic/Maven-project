package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PokreniServer extends Thread {
ServerSocket ss;

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
