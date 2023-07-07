package transfer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServerskiOdgovorTest {
ServerskiOdgovor serverskiOdgovor;
Object odgovor;

	@BeforeEach
	void setUp() throws Exception {
		odgovor= new Object();
		serverskiOdgovor= new ServerskiOdgovor();
	}

	@AfterEach
	void tearDown() throws Exception {
		serverskiOdgovor=null;
		odgovor=null;
	}

	@Test
	void testSetPoruka() {
		serverskiOdgovor.setPoruka("poruka");
		assertEquals("poruka", serverskiOdgovor.getPoruka());
	}

	@Test
	void testSetOdgovor() {
		serverskiOdgovor.setOdgovor(odgovor);
		assertEquals(odgovor, serverskiOdgovor.getOdgovor());
	}
}
