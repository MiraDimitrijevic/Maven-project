package domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	void testSetProizvodIDNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->proizvod.setProizvodID(-111L));
	}

	@Test
	void testSetNaziv() {
		proizvod.setNazivProizvoda("vaza");
		assertEquals("vaza", proizvod.getNazivProizvoda());
	}
	
	@Test
	void testSetNazivNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->proizvod.setNazivProizvoda(""));
	}
	
	@Test
	void testSetNazivNull() {
		assertThrows(NullPointerException.class, ()->proizvod.setNazivProizvoda(null));
	}
	

	@Test
	void testSetOpis() {
		proizvod.setOpisProizvoda("nedostupno");
		assertEquals("nedostupno", proizvod.getOpisProizvoda());
	}
	
	@Test
	void testSetOpisNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->proizvod.setOpisProizvoda(""));
	}
	
	@Test
	void testSetOpisNull() {
		assertThrows(NullPointerException.class, ()->proizvod.setOpisProizvoda(null));
	}
	
	@Test
	void testSetKolicina() {
		proizvod.setKolicinaNaStanju(14);
		assertEquals(14, proizvod.getKolicinaNaStanju());
	}
	
	@Test
	void testSetKolicinaNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->proizvod.setKolicinaNaStanju(-3));
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
	void testSetVekTrajanjaNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->proizvod.setVekTrajanjaUMesecima(-3));
	}
	
	@Test
	void testSetKorisnik() {
		korisnik= new Korisnik(1L, "Marko Markovic", "marko123","123456","menadzer");
		proizvod.setKorisnik(korisnik);
		assertEquals(korisnik, proizvod.getKorisnik());
	}
	
	@Test
	void testSetKorisnikNull() {
		assertThrows(NullPointerException.class, ()->proizvod.setKorisnik(null));
	}
	
	@Test
	void testSetDatumPocetkaProizvodnje() {
	 long timeMillis=System.currentTimeMillis();
		Date datumPocetkaProizv= new Date(timeMillis);
		proizvod.setDatumPocetkaProizvodnje(datumPocetkaProizv);
		assertEquals(datumPocetkaProizv, proizvod.getDatumPocetkaProizvodnje());
	}
	
	@Test
	void testSetDatumPocetkaProizvodnjeNull() {
		assertThrows(NullPointerException.class, ()->proizvod.setDatumPocetkaProizvodnje(null));
	}
	
	@Test
	void testSetDatumPocetkaProizvodnjeNedozvoljenaVrednost() {
		 Date datumVremePocetkaProizv = new GregorianCalendar(2023, Calendar.AUGUST, 11).getTime();
		assertThrows(IllegalArgumentException.class, ()->proizvod.setDatumPocetkaProizvodnje(datumVremePocetkaProizv));
	}
	
	@Test
	void testSetSastavnica() {
		ElementProizvoda ep= new ElementProizvoda();
		sastavnica.add(ep);
		proizvod.setSastavnica(sastavnica);
		assertEquals(sastavnica, proizvod.getSastavnica());
	}
	
	@Test
	void testSetSastavnicaNull() {
		assertThrows(NullPointerException.class, ()->proizvod.setSastavnica(null));
	}
	
	@Test
	void testSetSastavnicaNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->proizvod.setSastavnica(new ArrayList<>()));
	}

	@Test
	void testToString() {
		proizvod.setNazivProizvoda("vaza");
		assertTrue(proizvod.toString().contains("vaza"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"vaza, 15, vaza, 15, true",
		"vaza, 15, sveca, 15, false",
		"vaza, 15, vaza, 17, false",
		"vaza, 15, sveca, 17, false"
	})
	void testEquals(String pn1, long id1,
			String pn2, long id2, boolean isti) {
		proizvod.setNazivProizvoda(pn1);
		proizvod.setProizvodID(id1);
		Proizvod proizvod2= new Proizvod();
		proizvod2.setNazivProizvoda(pn2);
		proizvod2.setProizvodID(id2);
		assertEquals(isti, proizvod.equals(proizvod2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(proizvod.equals(null));
	}
	
	@Test
	void testEqualsIsti() {
		assertTrue(proizvod.equals(proizvod));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(proizvod.equals(new Exception()));
	}
}
