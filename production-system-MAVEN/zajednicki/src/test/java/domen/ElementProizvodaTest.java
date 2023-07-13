package domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElementProizvodaTest {
ElementProizvoda elementProizvoda;
JedinicaMere jedinicaMere;
Proizvod proizvod;
Materijal materijal;
	@BeforeEach
	void setUp() throws Exception {
		elementProizvoda = new  ElementProizvoda();
		proizvod= new Proizvod();
		jedinicaMere= new JedinicaMere();
		materijal= new Materijal();
	}

	@AfterEach
	void tearDown() throws Exception {
		elementProizvoda=null;
		proizvod=null;
		jedinicaMere=null;
		materijal=null;
	}

	@Test
	void testSetRBR() {
		elementProizvoda.setRbr(5L);
		assertEquals(5L, elementProizvoda.getRbr());
	}
	
	@Test
	void testSetRBRNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->elementProizvoda.setRbr(-111L));
	}
	
	@Test
	void testSetKolicina() {
		elementProizvoda.setKolicina(11.6);
		assertEquals(11.6, elementProizvoda.getKolicina());
	}
	
	@Test
	void testSetKolicinaNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->elementProizvoda.setKolicina(-3));
	}
	
	
	@Test
	void testSetProizvod() {
		proizvod= new Proizvod();
		elementProizvoda.setProizvod(proizvod);
		assertEquals(proizvod, elementProizvoda.getProizvod());
	}
	
	@Test
	void testSetProizvodNull() {
		assertThrows(NullPointerException.class, ()->elementProizvoda.setProizvod(null));
	}
	
	
	@Test
	void testSetJM() {
		jedinicaMere= new JedinicaMere();
		elementProizvoda.setJedinicaMere(jedinicaMere);
		assertEquals(jedinicaMere, elementProizvoda.getJedinicaMere());
	}
	
	@Test
	void testSetJMNull() {
		assertThrows(NullPointerException.class, ()->elementProizvoda.setJedinicaMere(null));
	}
	
	
	
	@Test
	void testSetMaterijal() {
		materijal= new Materijal();
		elementProizvoda.setMaterijal(materijal);
		assertEquals(materijal, elementProizvoda.getMaterijal());
	}
	@Test
	void testSetMaterijalNull() {
		assertThrows(NullPointerException.class, ()->elementProizvoda.setMaterijal(null));
	}

}
