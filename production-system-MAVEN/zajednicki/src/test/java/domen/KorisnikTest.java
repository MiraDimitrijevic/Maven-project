package domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	void testSetKorisnikIDNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->korisnik.setKorisnikID(-111L));
	}

	@Test
	void testSetImePrezime() {
		korisnik.setImePrezime("Marko Markovic");
		assertEquals("Marko Markovic", korisnik.getImePrezime());
	}
	
	@Test
	void testSetImePrezimeNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->korisnik.setImePrezime(""));
	}
	
	@Test
	void testSetImePrezimeNull() {
		assertThrows(NullPointerException.class, ()->korisnik.setImePrezime(null));
	}
	
	@Test
	void testSetKorisnickoIme() {
		korisnik.setKorisnickoIme("marko123");
		assertEquals("marko123", korisnik.getKorisnickoIme());
	}
	
	@Test
	void testSetKorisnickoImeNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->korisnik.setKorisnickoIme(""));
	}
	
	@Test
	void testSetKorisnickoImeNull() {
		assertThrows(NullPointerException.class, ()->korisnik.setKorisnickoIme(null));
	}
	
	
	@Test
	void testSetLozinka() {
		korisnik.setLozinka("marko123");
		assertEquals("marko123", korisnik.getLozinka());
	}
	
	@Test
	void testSetLozinkaNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->korisnik.setLozinka(""));
	}
	
	@Test
	void testSetLozinkaNull() {
		assertThrows(NullPointerException.class, ()->korisnik.setLozinka(null));
	}
	
	
	@Test
	void testSetRadnoMesto() {
		korisnik.setRadnoMesto("menadzer");
		assertEquals("menadzer", korisnik.getRadnoMesto());
	}
	
	@Test
	void testSetRadnoMestoNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->korisnik.setRadnoMesto(""));
	}
	
	@Test
	void testSetRadnoMestoNull() {
		assertThrows(NullPointerException.class, ()->korisnik.setRadnoMesto(null));
	}
	
	@Test
	void testToString() {
		korisnik.setImePrezime("Marko Markovic");
		assertTrue(korisnik.toString().contains("Marko Markovic"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"marko123, 15, marko123, 15, true",
		"marko123, 15, marko, 15, false",
		"marko123, 15, marko123, 17, false",
		"marko123, 15, marko, 17, false"
	})
	void testEquals(String ki1, long id1,
			String ki2, long id2, boolean isti) {
		korisnik.setKorisnickoIme(ki1);
		korisnik.setKorisnikID(id1);
		
		Korisnik korisnik2= new Korisnik();
		korisnik2.setKorisnickoIme(ki2);
		korisnik2.setKorisnikID(id2);
		
		assertEquals(isti, korisnik.equals(korisnik2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(korisnik.equals(null));
	}
	
	@Test
	void testEqualsIsti() {
		assertTrue(korisnik.equals(korisnik));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(korisnik.equals(new Exception()));
	}
	
	
}
