package domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradTest {
private Grad grad;
	@BeforeEach
	void setUp() throws Exception {
		 grad= new Grad();
	}

	@AfterEach
	void tearDown() throws Exception {
		grad= null;
	}

	@Test
	void testSetGradID() {
		grad.setGradID(5L);
		assertEquals(5L, grad.getGradID());
	}
	
	@Test
	void testSetNazivGrada() {
		grad.setNazivGrada("Beograd");
		assertEquals("Beograd", grad.getNazivGrada());
	}
	
	@Test
	void testToString() {
		grad.setNazivGrada("Beograd");
		assertTrue(grad.toString().contains("Beograd"));
	}
	

}
