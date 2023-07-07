package domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElementProizvodnjeTest {

	ElementProizvodnje elementProizvodnje;
	JedinicaMere jedinicaMere;
	Proizvod proizvod;
	Proizvodnja proizvodnja;
		@BeforeEach
		void setUp() throws Exception {
			elementProizvodnje = new  ElementProizvodnje();
			proizvod= new Proizvod();
			jedinicaMere= new JedinicaMere();
			 proizvodnja = new Proizvodnja();
		}

		@AfterEach
		void tearDown() throws Exception {
			elementProizvodnje=null;
			proizvod=null;
			jedinicaMere=null;
			proizvodnja=null;
		}

		@Test
		void testSetRBR() {
			elementProizvodnje.setRbr(5L);
			assertEquals(5L, elementProizvodnje.getRbr());
		}
		
		@Test
		void testSetKolicina() {
			elementProizvodnje.setKolicina(11.6);
			assertEquals(11.6, elementProizvodnje.getKolicina());
		}
		
		@Test
		void testSetProizvod() {
			proizvod= new Proizvod();
			elementProizvodnje.setProizvod(proizvod);
			assertEquals(proizvod, elementProizvodnje.getProizvod());
		}
		
		@Test
		void testSetJM() {
			jedinicaMere= new JedinicaMere();
			elementProizvodnje.setJedinicaMere(jedinicaMere);
			assertEquals(jedinicaMere, elementProizvodnje.getJedinicaMere());
		}
		
		
		@Test
		void testSetProizvodnja() {
			proizvodnja= new Proizvodnja();
			elementProizvodnje.setProizvodnja(proizvodnja);
			assertEquals(proizvodnja, elementProizvodnje.getProizvodnja());
		}


}
