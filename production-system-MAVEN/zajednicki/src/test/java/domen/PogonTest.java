package domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PogonTest {
Pogon pogon;
Grad grad;
Korisnik korisnik;

	@BeforeEach
	void setUp() throws Exception {
		pogon= new Pogon();
		grad= new Grad();
		korisnik= new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		grad = null;
		korisnik=null;
		pogon=null;
	}

	@Test
	void testSetPogonID() {
		pogon.setPogonID(5L);
		assertEquals(5L, pogon.getPogonID());
	}
	
	@Test
	void testSetDatumPocetkaRada() {
	 long timeMillis=System.currentTimeMillis();
		Date datumPocetkaRada= new Date(timeMillis);
		pogon.setDatumPocetkaRada(datumPocetkaRada);
		assertEquals(datumPocetkaRada, pogon.getDatumPocetkaRada());
	}
	
	@Test
	void testSetGrad() {
		grad= new Grad(1L, "Beograd");
		pogon.setGrad(grad);
		assertEquals(grad, pogon.getGrad());
	}
	
	@Test
	void testSetKorisnik() {
		korisnik= new Korisnik(1L, "Marko Markovic", "marko123","123456","menadzer");
		pogon.setKorisnik(korisnik);
		assertEquals(korisnik, pogon.getKorisnik());
	}
	
	@Test
	void testSetAdresa() {
		pogon.setAdresa("Zmaj Jovina 5");
		assertEquals("Zmaj Jovina 5", pogon.getAdresa());
	}
	
	@Test
	void testSetKontakt() {
		pogon.setKontakt("0611111111");
		assertEquals("0611111111", pogon.getKontakt());
	}
	
	@ParameterizedTest
	@CsvSource({ "true, true", "false, false" })
	void testSetAktivan(boolean value, boolean expected) {
		pogon.setAktivan(value);
		assertEquals(expected, pogon.isAktivan());
	}
	
	@Test
	void testToString() {
		grad.setNazivGrada("Beograd");
		pogon.setGrad(grad);
		pogon.setAdresa("Zmaj Jovina 5");
		assertTrue(pogon.toString().contains(grad.toString()));
		assertTrue(pogon.toString().contains("Zmaj Jovina 5"));
		
	}

}
