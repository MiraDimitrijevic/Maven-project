package domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProizvodTest {
Proizvod proizvod;
ArrayList<ElementProizvoda> sastavnica;
Korisnik korisnik;
	@BeforeEach
	void setUp() throws Exception {
		proizvod= new Proizvod();
		sastavnica= new ArrayList<ElementProizvoda>();
		korisnik= new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		proizvod=null;
		sastavnica=null;
		korisnik=null;
	}


	@Test
	void testSetProizvodID() {
		proizvod.setProizvodID(5L);
		assertEquals(5L, proizvod.getProizvodID());
	}


	@Test
	void testSetNaziv() {
		proizvod.setNazivProizvoda("vaza");
		assertEquals("vaza", proizvod.getNazivProizvoda());
	}
	

	@Test
	void testSetOpis() {
		proizvod.setOpisProizvoda("nedostupno");
		assertEquals("nedostupno", proizvod.getOpisProizvoda());
	}
	
	@Test
	void testSetKolicina() {
		proizvod.setKolicinaNaStanju(14);
		assertEquals(14, proizvod.getKolicinaNaStanju());
	}
	
	@ParameterizedTest
	@CsvSource({ "true, true", "false, false" })
	void testSetPatent(boolean value, boolean expected) {
		proizvod.setPatent(value);
		assertEquals(expected, proizvod.isPatent());
	}
	
	@Test
	void testSetVekTrajanja() {
		proizvod.setVekTrajanjaUMesecima(14);
		assertEquals(14, proizvod.getVekTrajanjaUMesecima());
	}
	
	@Test
	void testSetKorisnik() {
		korisnik= new Korisnik(1L, "Marko Markovic", "marko123","123456","menadzer");
		proizvod.setKorisnik(korisnik);
		assertEquals(korisnik, proizvod.getKorisnik());
	}
	
	@Test
	void testSetDatumPocetkaProizvodnje() {
	 long timeMillis=System.currentTimeMillis();
		Date datumPocetkaProizv= new Date(timeMillis);
		proizvod.setDatumPocetkaProizvodnje(datumPocetkaProizv);
		assertEquals(datumPocetkaProizv, proizvod.getDatumPocetkaProizvodnje());
	}
	@Test
	void testSetSastavnica() {
		ElementProizvoda ep= new ElementProizvoda();
		sastavnica.add(ep);
		proizvod.setSastavnica(sastavnica);
		assertEquals(sastavnica, proizvod.getSastavnica());
	}
	

	@Test
	void testToString() {
		proizvod.setNazivProizvoda("vaza");
		assertTrue(proizvod.toString().contains("vaza"));
	}
	
	
}
