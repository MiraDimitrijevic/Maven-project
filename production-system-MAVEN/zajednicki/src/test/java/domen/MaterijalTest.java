package domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaterijalTest {
Materijal materijal;
	@BeforeEach
	void setUp() throws Exception {
		materijal= new Materijal();
	}

	@AfterEach
	void tearDown() throws Exception {
		materijal= null;
	}
	

	@Test
	void testSetMaterijalID() {
		materijal.setMaterijalID(5L);
		assertEquals(5L, materijal.getMaterijalID());
	}
	
	@Test
	void testSetMaterijalIDNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->materijal.setMaterijalID(-111L));
	}
	
	@Test
	void testSetNaziv() {
		materijal.setNazivMaterijala("glina");
		assertEquals("glina", materijal.getNazivMaterijala());
	}
	
	@Test
	void testSetNazivMaterijalaNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->materijal.setNazivMaterijala(""));
	}
	
	@Test
	void testSetNazivMaterijalaNull() {
		assertThrows(NullPointerException.class, ()->materijal.setNazivMaterijala(null));
	}
	
	@Test
	void testSetOpis() {
		materijal.setOpisMaterijala("opis trenutno nije dostupan");
		assertEquals("opis trenutno nije dostupan", materijal.getOpisMaterijala());
	}
	
	@Test
	void testSetOpisMaterijalaNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->materijal.setOpisMaterijala(""));
	}
	
	@Test
	void testSetOpisMaterijalaNull() {
		assertThrows(NullPointerException.class, ()->materijal.setOpisMaterijala(null));
	}
	
	@Test
	void testSetKolicina() {
		materijal.setKolicinaNaStanju(11.6);
		assertEquals( 11.6,materijal.getKolicinaNaStanju());
	}
	
	@Test
	void testSetKolicinaMaterijalaNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->materijal.setKolicinaNaStanju(-3));
	}
	
	@Test
	void testToString() {
		materijal.setNazivMaterijala("glina");
		assertTrue(materijal.toString().contains("glina"));
	}

}
