package domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProizvodnjaTest {
	Proizvodnja proizvodnja;
	ArrayList<ElementProizvodnje> izlazi;
	Korisnik korisnik;
	Pogon pogon;
	@BeforeEach
	void setUp() throws Exception {
		proizvodnja= new Proizvodnja();
		pogon= new Pogon();
		korisnik= new Korisnik();
		izlazi= new ArrayList<ElementProizvodnje>();
				
	}

	@AfterEach
	void tearDown() throws Exception {
		proizvodnja=null;
		pogon=null;
		izlazi=null;
		korisnik=null;
	}
	@Test
	void testSetProizvodnjaID() {
		proizvodnja.setProizvodnjaID(5L);
		assertEquals(5L, proizvodnja.getProizvodnjaID());
	}
	
	@Test
	void testSetDatumVremePocetkaProizvodnje() {
	 long timeMillis=System.currentTimeMillis();
		Date datumVremePocetkaProizv= new Date(timeMillis);
		proizvodnja.setDatumVremePocetka(datumVremePocetkaProizv);
		assertEquals(datumVremePocetkaProizv, proizvodnja.getDatumVremePocetka());
	}
	
	@Test
	void testSetDatumVremeZavrsetkaProizvodnje() {
	 long timeMillis=System.currentTimeMillis();
		Date datumVremeZavrsetkaProizv= new Date(timeMillis);
		proizvodnja.setDatumVremeZavrsetka(datumVremeZavrsetkaProizv);
		assertEquals(datumVremeZavrsetkaProizv, proizvodnja.getDatumVremeZavrsetka());
	}
	
	
	@Test
	void testSetKorisnik() {
		korisnik= new Korisnik(1L, "Marko Markovic", "marko123","123456","menadzer");
		proizvodnja.setKorisnik(korisnik);
		assertEquals(korisnik, proizvodnja.getKorisnik());
	}
	
	@Test
	void testSetPogoon() {
		pogon= new Pogon();
		proizvodnja.setPogon(pogon);
		assertEquals(pogon, proizvodnja.getPogon());
	}
	
	
	@Test
	void testSetIzlazi() {
		ElementProizvodnje ep= new ElementProizvodnje();
		izlazi.add(ep);
		proizvodnja.setIzlazi(izlazi);
		assertEquals(izlazi, proizvodnja.getIzlazi());
	}
	
	
	
	
	
	
	
	
	
}
