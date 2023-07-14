package logika;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baza.Konekcija;
import domen.ElementProizvoda;
import domen.ElementProizvodnje;
import domen.Grad;
import domen.JedinicaMere;
import domen.Korisnik;
import domen.Materijal;
import domen.Pogon;
import domen.Proizvod;
import domen.Proizvodnja;

class KontrolerTest {
Kontroler kontroler;
	@BeforeEach
	void setUp() throws Exception {
		kontroler.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		kontroler=null;
	}

	@Test
	void testLogin() {
		Korisnik korisnik= new Korisnik(7, "Marko Markovic", "marko123", "12349876", "menadzer");
	    kontroler.getInstance().register(korisnik);
	    Korisnik korisnikUlogovani=kontroler.getInstance().login(korisnik.getKorisnickoIme(), korisnik.getLozinka());
	    kontroler.getInstance().obrisiKorisnika(korisnikUlogovani.getKorisnikID());
	    assertEquals(korisnik.getKorisnickoIme(), korisnikUlogovani.getKorisnickoIme());
	    assertEquals(korisnik.getLozinka(), korisnikUlogovani.getLozinka());
	    assertEquals(korisnik.getImePrezime(), korisnikUlogovani.getImePrezime());
	    assertEquals(korisnik.getRadnoMesto(), korisnikUlogovani.getRadnoMesto());
	}
	
	@Test
	void testLoginKorisnikNePostoji() {
		Korisnik korisnik= new Korisnik(7, "Marko Markovic", "marko123", "12349876", "menadzer");
	    Korisnik korisnikUlogovani=kontroler.getInstance().login(korisnik.getKorisnickoIme(), korisnik.getLozinka());
	    assertEquals(null, korisnikUlogovani);
	  
	}

	@Test
	void testLoginKorisnikNull() {
	    Korisnik korisnikUlogovani=kontroler.getInstance().login(null, null);
	    assertEquals(null, korisnikUlogovani);  
	}
	@Test
	void testRegister() {
		long id= kontroler.getInstance().getKorisnikID();
		Korisnik korisnik= new Korisnik(id, "Marko Markovic", "marko123", "12349876", "menadzer");
	    boolean uspesno= kontroler.getInstance().register(korisnik);
	    ArrayList<Korisnik> korisnici= kontroler.getInstance().vratiKorisnike();
	    kontroler.getInstance().obrisiKorisnika(id);
	   assertEquals(true, uspesno);
	   assertTrue(korisnici.contains(korisnik));
	}
	
	@Test
	void testRegisterZauzetoKorisnickoIme() {
		long id= kontroler.getInstance().getKorisnikID();
		Korisnik korisnik1= new Korisnik(id, "Petar Petrovic", "petar123", "12349876", "menadzer");
	    boolean uspesno1= kontroler.getInstance().register(korisnik1);
		Korisnik korisnik2= new Korisnik(++id, "Petar Petrovic", "petar123", "12349876", "menadzer");
	    boolean uspesno2= kontroler.getInstance().register(korisnik2);
	    ArrayList<Korisnik> korisnici= kontroler.getInstance().vratiKorisnike();
	    kontroler.getInstance().obrisiKorisnika(--id);
	    kontroler.getInstance().obrisiKorisnika(++id);
	   assertEquals(false, uspesno2);
	   assertFalse(korisnici.contains(korisnik2));

	}
	
	@Test
	void testObrisiKorisnika() {
		long id= kontroler.getInstance().getKorisnikID();
		Korisnik korisnik= new Korisnik(id, "Marko Markovic", "marko123", "12349876", "menadzer");
	    kontroler.getInstance().register(korisnik);
	    boolean uspesno=kontroler.getInstance().obrisiKorisnika(id);
	    ArrayList<Korisnik> korisnici= kontroler.getInstance().vratiKorisnike();
	    assertEquals(true, uspesno);
	   assertFalse(korisnici.contains(korisnik));
	}
	
	@Test
	void testObrisiKorisnikaNePostoji() {
		
	    boolean uspesno=kontroler.getInstance().obrisiKorisnika(15);
	    assertEquals(true, uspesno);
	}
	
	
	@Test
	void testSacuvajMaterijal() {
		long id= kontroler.getInstance().getMaterijalID();
		Materijal materijal= new Materijal(id, "glina", "nedostupan", 34);
	    boolean uspesno= kontroler.getInstance().sacuvajMaterijal(materijal);
	    ArrayList<Materijal> materijali= kontroler.getInstance().vratiMaterijale();
	    kontroler.getInstance().obrisiMaterijal(id);
	   assertEquals(true, uspesno);
	   assertTrue(materijali.contains(materijal));
	}
	
	
	@Test
	void testObrisiMaterijal() {
		long id= kontroler.getInstance().getMaterijalID();
		Materijal materijal= new Materijal(id, "glina", "nedostupan", 34);
        kontroler.getInstance().sacuvajMaterijal(materijal);
	 boolean uspesno=kontroler.getInstance().obrisiMaterijal(id);
	    ArrayList<Materijal> materijali= kontroler.getInstance().vratiMaterijale();
	   assertEquals(true, uspesno);
	   assertFalse(materijali.contains(materijal));
	}
	
	@Test
	void testObrisiMaterijalNePostoji() {
	
	 boolean uspesno=kontroler.getInstance().obrisiMaterijal(15);
	   assertEquals(true, uspesno);
	}
	
	
	@Test
	void testSacuvajPogon() {
		long id= kontroler.getInstance().getPogonID();
		Korisnik korisnik= new Korisnik(3, "Nevena Zaric", "nevenaZ", "nevena123", "menadzer");
		Grad grad= new Grad(1, "Beograd");
		 Date datum = new GregorianCalendar(2023, Calendar.JULY, 11).getTime();
        Pogon pogon= new Pogon(id, datum, grad, "Zmaj Jovina 2", "0112345998", true, korisnik);
	    boolean uspesno= kontroler.getInstance().sacuvajPogon(pogon);
	    ArrayList<Pogon> pogoni= kontroler.getInstance().vratiPogone();
	    kontroler.getInstance().obrisiPogon(id);
	   assertEquals(true, uspesno);
	   assertTrue(pogoni.contains(pogon));
	}
	
	
	@Test
	void testObrisiPogon() {
		long id= kontroler.getInstance().getPogonID();
		Korisnik korisnik= new Korisnik(3, "Nevena Zaric", "nevenaZ", "nevena123", "menadzer");
		Grad grad= new Grad(1, "Beograd");
		 Date datum = new GregorianCalendar(2023, Calendar.JULY, 11).getTime();
        Pogon pogon= new Pogon(id, datum, grad, "Zmaj Jovina 2", "0112345998", true, korisnik);
	     kontroler.getInstance().sacuvajPogon(pogon);
	    boolean uspesno= kontroler.getInstance().obrisiPogon(id);
	    ArrayList<Pogon> pogoni= kontroler.getInstance().vratiPogone();
	    assertEquals(true, uspesno);
	   assertFalse(pogoni.contains(pogon));
	}
	
	@Test
	void testObrisiPogonNePostoji() {
	
	 boolean uspesno=kontroler.getInstance().obrisiPogon(15);
	   assertEquals(true, uspesno);
	}
	@Test
	void testIzmeniPogon() {
		long id= kontroler.getInstance().getPogonID();
		Korisnik korisnik= new Korisnik(3, "Nevena Zaric", "nevenaZ", "nevena123", "menadzer");
		Grad grad= new Grad(1, "Beograd");
		 Date datum = new GregorianCalendar(2023, Calendar.JULY, 11).getTime();
        Pogon pogon= new Pogon(id, datum, grad, "Zmaj Jovina 2", "0112345998", true, korisnik);
	     kontroler.getInstance().sacuvajPogon(pogon);
	        Pogon pogonIzmenjen= new Pogon(id, datum, grad, "Vuka Karadzica 8", "0112345980", false, korisnik);
	     boolean uspesno= kontroler.getInstance().izmeniPogon(pogonIzmenjen);
	    kontroler.getInstance().obrisiPogon(id);
	   assertEquals(true, uspesno);
	}
	
	@Test
	void testSacuvajProizvod() {
		long id= kontroler.getInstance().getProizvodID();
		Korisnik korisnik= new Korisnik(3, "Nevena Zaric", "nevenaZ", "nevena123", "menadzer");
		 Date datum = new GregorianCalendar(2023, Calendar.JULY, 11).getTime();
		 Materijal materijal= new Materijal(1, "glina", "nedostupan", 13);
		 JedinicaMere jm= new JedinicaMere(1, "kg");
		 ElementProizvoda ep= new ElementProizvoda(null, 1, materijal, jm, 2);
		 ArrayList<ElementProizvoda> lista= new ArrayList<ElementProizvoda>();
		 lista.add(ep);
		 Proizvod proizvod= new Proizvod(id, "vaza", "nedostupan.", 7, false, 4, datum, korisnik, lista);
	    boolean uspesno= kontroler.getInstance().sacuvajProizvod(proizvod);
	    ArrayList<Proizvod> proizvodi= kontroler.getInstance().vratiProizvode();
	    kontroler.getInstance().obrisiProizvod(proizvod);
	   assertEquals(true, uspesno);
	   assertTrue(proizvodi.contains(proizvod));
	}
	
	@Test
	void testObrisiProizvod() {
		long id= kontroler.getInstance().getProizvodID();
		Korisnik korisnik= new Korisnik(3, "Nevena Zaric", "nevenaZ", "nevena123", "menadzer");
		 Date datum = new GregorianCalendar(2023, Calendar.JULY, 11).getTime();
		 Materijal materijal= new Materijal(1, "glina", "nedostupan", 13);
		 JedinicaMere jm= new JedinicaMere(1, "kg");
		 ElementProizvoda ep= new ElementProizvoda(null, 1, materijal, jm, 2);
		 ArrayList<ElementProizvoda> lista= new ArrayList<ElementProizvoda>();
		 lista.add(ep);
		 Proizvod proizvod= new Proizvod(id, "vaza", "nedostupan.", 7, false, 4, datum, korisnik, lista);
	   kontroler.getInstance().sacuvajProizvod(proizvod);
	   boolean uspesno= kontroler.getInstance().obrisiProizvod(proizvod);
	    ArrayList<Proizvod> proizvodi= kontroler.getInstance().vratiProizvode();
	   assertEquals(true, uspesno);
	   assertFalse(proizvodi.contains(proizvod));

	}
	
	@Test
	void testObrisiNepostojeciProizvod() {
		Korisnik korisnik= new Korisnik(3, "Nevena Zaric", "nevenaZ", "nevena123", "menadzer");
		 Date datum = new GregorianCalendar(2023, Calendar.JULY, 11).getTime();
		 Materijal materijal= new Materijal(1, "glina", "nedostupan", 13);
		 JedinicaMere jm= new JedinicaMere(1, "kg");
		 ElementProizvoda ep= new ElementProizvoda(null, 1, materijal, jm, 2);
		 ArrayList<ElementProizvoda> lista= new ArrayList<ElementProizvoda>();
		 lista.add(ep);
		 Proizvod proizvod= new Proizvod(14, "vaza", "nedostupan.", 7, false, 4, datum, korisnik, lista);
	   boolean uspesno= kontroler.getInstance().obrisiProizvod(proizvod);
	   assertEquals(true, uspesno);
	}
	
	@Test
	void testSacuvajProizvodnju() {
		long id= kontroler.getInstance().getProizvodnjaID();
		Korisnik korisnik= new Korisnik(3, "Nevena Zaric", "nevenaZ", "nevena123", "menadzer");
		 Date datum = new GregorianCalendar(2023, Calendar.JULY, 11).getTime();
		 Date datum2 = new GregorianCalendar(2023, Calendar.JULY, 13).getTime();
		 Materijal materijal= new Materijal(1, "glina", "nedostupan", 13);
		 JedinicaMere jm= new JedinicaMere(1, "kg");
		 Proizvod proizvod= new Proizvod(1, "vaza", "nedostupan.", 7, false, 4, datum, korisnik, null);
		 ElementProizvodnje ep= new ElementProizvodnje(null, 1, proizvod, jm, 2);
		 Grad grad= new Grad(1, "Beograd");
        Pogon pogon= new Pogon(2, datum, grad, "Zmaj Jovina 2", "0112345998", true, korisnik);
		 ArrayList<ElementProizvodnje> lista= new ArrayList<ElementProizvodnje>();
		 lista.add(ep);
	   Proizvodnja proizvodnja = new Proizvodnja(id, datum, datum2, pogon, korisnik, lista);
		 boolean uspesno= kontroler.getInstance().sacuvajProizvodnju(proizvodnja);
	    kontroler.getInstance().obrisiProizvodnju(id);
	   assertEquals(true, uspesno);
	}
	
	@Test
	void testObrisiProizvodnju() {
		long id= kontroler.getInstance().getProizvodnjaID();
		Korisnik korisnik= new Korisnik(3, "Nevena Zaric", "nevenaZ", "nevena123", "menadzer");
		 Date datum = new GregorianCalendar(2023, Calendar.JULY, 11).getTime();
		 Date datum2 = new GregorianCalendar(2023, Calendar.JULY, 13).getTime();
		 Materijal materijal= new Materijal(1, "glina", "nedostupan", 13);
		 JedinicaMere jm= new JedinicaMere(1, "kg");
		 Proizvod proizvod= new Proizvod(1, "vaza", "nedostupan.", 7, false, 4, datum, korisnik, null);
		 ElementProizvodnje ep= new ElementProizvodnje(null, 1, proizvod, jm, 2);
		 Grad grad= new Grad(1, "Beograd");
        Pogon pogon= new Pogon(2, datum, grad, "Zmaj Jovina 2", "0112345998", true, korisnik);
		 ArrayList<ElementProizvodnje> lista= new ArrayList<ElementProizvodnje>();
		 lista.add(ep);
	   Proizvodnja proizvodnja = new Proizvodnja(id, datum, datum2, pogon, korisnik, lista);
		 kontroler.getInstance().sacuvajProizvodnju(proizvodnja);
		 boolean uspesno=  kontroler.getInstance().obrisiProizvodnju(id);
	   assertEquals(true, uspesno);
	}
	
	@Test
	void testObrisiProizvodnjuNePostoji() {
	
	 boolean uspesno=kontroler.getInstance().obrisiProizvodnju(15);
	   assertEquals(true, uspesno);
	}

}
