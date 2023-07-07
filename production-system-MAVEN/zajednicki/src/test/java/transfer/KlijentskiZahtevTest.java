package transfer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import konstante.Operacije;

class KlijentskiZahtevTest {
	KlijentskiZahtev klijentskiZahtev;
	Object param;
	
	@BeforeEach
	void setUp() throws Exception {
		klijentskiZahtev= new KlijentskiZahtev();
		 param= new Object();
	}

	@AfterEach
	void tearDown() throws Exception {
		klijentskiZahtev=null;
		param=null;
	}

	@Test
	void testSetOperacija() {
		klijentskiZahtev.setOperacija(Operacije.LOGIN);
		assertEquals(Operacije.LOGIN, klijentskiZahtev.getOperacija());
	}

	@Test
	void testSetParametar() {
		klijentskiZahtev.setParametar(param);
		assertEquals(param, klijentskiZahtev.getParametar());
	}
}
