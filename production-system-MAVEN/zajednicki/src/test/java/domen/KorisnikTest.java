package domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KorisnikTest {
Korisnik korisnik;
	@BeforeEach
	void setUp() throws Exception {
		korisnik= new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		korisnik= null;
	}

	@Test
	void testSetKorisnikID() {
		korisnik.setKorisnikID(5L);
		assertEquals(5L, korisnik.getKorisnikID());
	}

	@Test
	void testSetImePrezime() {
		korisnik.setImePrezime("Marko Markovic");
		assertEquals("Marko Markovic", korisnik.getImePrezime());
	}
	
	@Test
	void testSetKorisnickoIme() {
		korisnik.setKorisnickoIme("marko123");
		assertEquals("marko123", korisnik.getKorisnickoIme());
	}
	
	@Test
	void testSetLozinka() {
		korisnik.setLozinka("marko123");
		assertEquals("marko123", korisnik.getLozinka());
	}
	
	@Test
	void testSetRadnoMesto() {
		korisnik.setRadnoMesto("menadzer");
		assertEquals("menadzer", korisnik.getRadnoMesto());
	}
	
	@Test
	void testToString() {
		korisnik.setImePrezime("Marko Markovic");
		assertTrue(korisnik.toString().contains("Marko Markovic"));
	}
	
	
}
