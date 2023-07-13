package domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JedinicaMereTest {
JedinicaMere jedinicaMere;
	@BeforeEach
	void setUp() throws Exception {
		jedinicaMere= new JedinicaMere();
	}

	@AfterEach
	void tearDown() throws Exception {
		jedinicaMere= null;
	}

	@Test
	void testSetJMID() {
		jedinicaMere.setJMID(5L);
		assertEquals(5L, jedinicaMere.getJMID());
	}
	
	@Test
	void testSetJMIDNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->jedinicaMere.setJMID(-111L));
	}
	@Test
	void testSetNazivJM() {
		jedinicaMere.setNazivJM("kg");
		assertEquals("kg", jedinicaMere.getNazivJM());
	}
	
	@Test
	void testSetNazivJMNedozvoljenaVrednost() {
		assertThrows(IllegalArgumentException.class, ()->jedinicaMere.setNazivJM(""));
	}
	
	@Test
	void testSetNazivJMNull() {
		assertThrows(NullPointerException.class, ()->jedinicaMere.setNazivJM(null));
	}
	
	
	
	@Test
	void testSettoString() {
		jedinicaMere.setNazivJM("kg");
		assertTrue(jedinicaMere.toString().contains("kg"));
	}

}
