package domen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGenerator.Simple;
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
	void testSetProizvodnjaIDNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->proizvodnja.setProizvodnjaID(-111L));
	}
	
	@Test
	void testSetDatumVremePocetkaProizvodnje() {
	 long timeMillis=System.currentTimeMillis();
		Date datumVremePocetkaProizv= new Date(timeMillis);
		proizvodnja.setDatumVremePocetka(datumVremePocetkaProizv);
		assertEquals(datumVremePocetkaProizv, proizvodnja.getDatumVremePocetka());
	}
	
	@Test
	void testSetDatumVremePocetkaProizvodnjeNull() {
		assertThrows(NullPointerException.class, ()->proizvodnja.setDatumVremePocetka(null));
	}
	
	@Test
	void testSetDatumVremePocetkaProizvodnjeNedozvoljenaVrednost() {
		 Date datumVremePocetkaProizv = new GregorianCalendar(2023, Calendar.AUGUST, 11).getTime();
		assertThrows(IllegalArgumentException.class, ()->proizvodnja.setDatumVremePocetka(datumVremePocetkaProizv));
	}
	
	
	@Test
	void testSetDatumVremeZavrsetkaProizvodnje() {
		 Date datumVremePocetkaProizv = new GregorianCalendar(2023, Calendar.MAY, 11).getTime();
         proizvodnja.setDatumVremePocetka(datumVremePocetkaProizv);
	    long timeMillis=System.currentTimeMillis();
		Date datumVremeZavrsetkaProizv= new Date(timeMillis);
		proizvodnja.setDatumVremeZavrsetka(datumVremeZavrsetkaProizv);
	    assertEquals(datumVremeZavrsetkaProizv, proizvodnja.getDatumVremeZavrsetka());
	}

	@Test
	void testSetDatumVremeZavrsetkaProizvodnjeNull() {
		assertThrows(NullPointerException.class, ()->proizvodnja.setDatumVremeZavrsetka(null));
	}
	
	@Test
	void testSetDatumVremeZavrsetkaProizvodnjeNedozvoljenaVrednost() {
		 Date datumVremePocetkaProizv = new GregorianCalendar(2023, Calendar.JULY, 11).getTime();
		 Date datumVremeZavrsetkaProizv = new GregorianCalendar(2023, Calendar.JULY, 9).getTime();
         proizvodnja.setDatumVremePocetka(datumVremePocetkaProizv);
		assertThrows(IllegalArgumentException.class, ()->proizvodnja.setDatumVremeZavrsetka(datumVremeZavrsetkaProizv));
	}
	
	
	@Test
	void testSetKorisnik() {
		korisnik= new Korisnik(1L, "Marko Markovic", "marko123","123456","menadzer");
		proizvodnja.setKorisnik(korisnik);
		assertEquals(korisnik, proizvodnja.getKorisnik());
	}
	
	@Test
	void testSetKorisnikNull() {
		assertThrows(NullPointerException.class, ()->proizvodnja.setKorisnik(null));
	}
	
	
	@Test
	void testSetPogoon() {
		pogon= new Pogon();
		proizvodnja.setPogon(pogon);
		assertEquals(pogon, proizvodnja.getPogon());
	}
 
	@Test
	void testSetPogonNull() {
		assertThrows(NullPointerException.class, ()->proizvodnja.setPogon(null));
	}
	
	
	@Test
	void testSetIzlazi() {
		ElementProizvodnje ep= new ElementProizvodnje();
		izlazi.add(ep);
		proizvodnja.setIzlazi(izlazi);
		assertEquals(izlazi, proizvodnja.getIzlazi());
	}
	
	@Test
	void testSetIzlaziNull() {
		assertThrows(NullPointerException.class, ()->proizvodnja.setIzlazi(null));
	}
	
	@Test
	void testSetIzlaziNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->proizvodnja.setIzlazi(new ArrayList<>()));
	}

	
	
	
	
	
	
	
	
	
}
