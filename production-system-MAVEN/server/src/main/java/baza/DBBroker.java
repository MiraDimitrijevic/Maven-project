package baza;
import java.sql.*;

import java.util.ArrayList;

import domen.ElementProizvoda;
import domen.ElementProizvodnje;
import domen.Grad;
import domen.JedinicaMere;
import domen.Korisnik;
import domen.Materijal;
import domen.Pogon;
import domen.Proizvod;
import domen.Proizvodnja;
/**
 * Broker baze podataka izvrsava CRUD operacije nad bazom. 
 * Koristi klase Statement i PreparedStatment kako bi izvrsavao upite.
 * @author Mirjana Dimitrijevic
 *
 */
public class DBBroker {
	/**
	 * Metoda za logovanje korisnika sa odgovarajucim korisnickim imenom 
	 * i lozinkom. Vraca informacije o ulogovanom korisniku koje dobija
	 * iz baze preko definisanog upita, koristeci klase {@link Statement}
	 * i {@link ResultSet} .
     * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @param un Korisnicko ime korisnika.
	 * @param pass Lozinka korisnika.
	 * @return Ulogovani Korisnik ili null, ako su kredencijali pogresni.
	 */
	public Korisnik login(String un, String pass) {
	String upit="SELECT * FROM Korisnik WHERE korisnickoIme='"+un+"' AND lozinka='"+pass+"'";
	try {
		Statement st= Konekcija.getInstance().getCon().createStatement();
		ResultSet rs= st.executeQuery(upit);
		while (rs.next()) {
			Korisnik kor= new Korisnik(rs.getLong(1), rs.getString(2)
					, rs.getString(3), rs.getString(4), rs.getString(5));
			return kor;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return null;
			
	}
	/**
	 * Metoda za registraciju korisnika, sa parametrima koje je uneo pri
	 * popunjavanju forme za registraciju.
	 * Korisnicko ime mora biti jedinstveno, sto se proverava putem metode
	 * {@link zauzetoKorisnickoIme}.
	 * Cuvanje u bazi omoguceno je putem klase {@link PreparedStatement}
	 * i upita definisanog u metodi.
	 * @param korisnik Informacije o korisniku koji se registruje.
     * @throws SQLException greska koja nastaje pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return <ul>
		 * 		<li> true - ako je registracija uspesna. </li>
		 * 		<li> false - ako registracija nije uspesna. </li>
		 * </ul>
	 */
	public boolean register(Korisnik korisnik) throws SQLException {
		String upit= "INSERT INTO korisnik VALUES(?,?,?,?,?)";
		if(zauzetoKorisnickoIme(korisnik.getKorisnickoIme())) return false;
		try {
			PreparedStatement ps= Konekcija.getInstance().getCon().prepareStatement(upit);
			ps.setLong(1, getKorisnikID());
			ps.setString(2, korisnik.getImePrezime());
			ps.setString(3, korisnik.getKorisnickoIme());
			ps.setString(4, korisnik.getLozinka());
			ps.setString(5, korisnik.getRadnoMesto());
			ps.executeUpdate();
			Konekcija.getInstance().getCon().commit();
			return true;
		} catch (SQLException e) {
			Konekcija.getInstance().getCon().rollback();
			e.printStackTrace();
		}
		
		return false;
	}
/**
 * Metoda vraca broj koji je za jedan veci od najveceg identifikatora
 * korisnika koji postoji u bazi.
 * Kreirana je kako bi objektu novog korisnika dodelila jedinstveni 
 * identifikator i tako ispunila ogranicenje pre unosa objekta u bazu podataka.
 * Vraca informaciju o maksimalnom idju korisnika koju dobija
 * iz baze preko definisanog upita, koristeci klase {@link Statement}
 * i {@link ResultSet} .
 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
 * @return Jedinstveni identifikator korisnika.
 */
	private long getKorisnikID() {
		long korisnikID=0;
		String upit="SELECT MAX(korisnikID) FROM korisnik";
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
			korisnikID=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ++korisnikID;
	}
	/**
	 * Metoda proverava da li u bazi vec postoji Korisnik sa zadatim korisnickim imenom.
	 * Kreirana je kako bi se prekinula operacija registracije 
	 * (unosa novog korisnika u bazu), u slucaju da korisnicko ime nije 
	 * jedinstveno.
	 * Koristi klase {@link Statement} i {@link ResultSet}, kao
	 * i definisani upit kako bi iz baze dobila korisnika sa istim
	 * korisnickim imenom.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @param korisnickoIme Korisnicko ime korisnika.
	 * @return Jedinstveni identifikator korisnika.
	 */
	private boolean zauzetoKorisnickoIme(String korisnickoIme) {
		String upit="SELECT * FROM Korisnik WHERE korisnickoIme='"+korisnickoIme+"'";
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
			return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Metoda koja vraca listu materijala iz baze.
	 * Koristi klase {@link Statement} i {@link ResultSet}, kao
	 * i upit definisan u metodi kako bi iz baze dobila listu
	 * svih materijala.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * neadekvatnog upita nad podacima u bazi.
	 * @return lista materijala.
	 */
	public ArrayList<Materijal> vratiMaterijale() {
		String upit= "SELECT * FROM ulaznimaterijal";
		ArrayList<Materijal> lista= new ArrayList<Materijal>();
		
			
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
				Materijal materijal= new Materijal(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			lista.add(materijal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	/**
	 * Metoda koja cuva kreirani materijal.
     * Cuvanje u bazi omoguceno je putem klase {@link PreparedStatement}
	 * i upita definisanog u metodi.
	 * @param materijal Informacije o materijalu koji se cuva.
     * @throws SQLException greska koja nastaje pri pokusaju izvrsenja 
     * @return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean sacuvajMaterijal(Materijal materijal) throws SQLException {
		String upit= "INSERT INTO ulaznimaterijal VALUES(?,?,?,?)";
		try {
			PreparedStatement ps= Konekcija.getInstance().getCon().prepareStatement(upit);
			ps.setLong(1, getMaterijalID());
			ps.setString(2, materijal.getNazivMaterijala());
			ps.setString(3, materijal.getOpisMaterijala());
			ps.setDouble(4, materijal.getKolicinaNaStanju());
			ps.executeUpdate();
			Konekcija.getInstance().getCon().commit();
			return true;
		} catch (SQLException e) {
			Konekcija.getInstance().getCon().rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Metoda vraca broj koji je za jedan veci od najveceg identifikatora
	 * materijala koji postoji u bazi.
	 * Kreirana je kako bi objektu novog materijala dodelila jedinstveni 
	 * identifikator i tako ispunila ogranicenje pre unosa objekta u bazu podataka.
	 * Vraca informaciju o maksimalnom idju materijala koju dobija
	 * iz baze preko definisanog upita, koristeci klase {@link Statement}
	 * i {@link ResultSet} .
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return Jedinstveni identifikator materijala.
	 */
	private long getMaterijalID() {
		long materijalID=0;
		String upit="SELECT MAX(MaterijalID) FROM ulaznimaterijal";
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
			materijalID=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ++materijalID;
	}
	/**
	 * Metoda koja vraca listu pogona iz baze.
	 * Koristi klase {@link Statement} i {@link ResultSet}, kao
	 * i upit definisan u metodi kako bi iz baze dobila listu
	 * svih pogona.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return lista pogona.
	 */
	public ArrayList<Pogon> vratiPogone() {
		String upit= "SELECT * FROM pogon p JOIN grad g ON(p.gradid=g.gradid) JOIN korisnik k ON (k.korisnikID=p.nadlezniID)"
				;
		ArrayList<Pogon> lista= new ArrayList<Pogon>();
		
			
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
				Grad grad= new Grad(rs.getLong(8),rs.getString(9)	);
				Korisnik kor= new Korisnik(rs.getLong(10),rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
			Pogon pogon= new Pogon(rs.getLong(1), rs.getDate(2), grad, rs.getString(4), rs.getString(5), rs.getBoolean(6), kor);
			lista.add(pogon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	/**
	 * Metoda koja vraca listu gradova iz baze.	 
	 * Koristi klase {@link Statement} i {@link ResultSet}, kao
	 * i upit definisan u metodi kako bi iz baze dobila listu
	 * svih gradova.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return lista gradova.
	 */	
	public ArrayList<Grad> vratiGradove() {
		String upit= "SELECT * FROM grad";
		ArrayList<Grad> lista= new ArrayList<Grad>();
		
			
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
				Grad grad= new Grad(rs.getLong(1), rs.getString(2));
			lista.add(grad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	/**
	 * Metoda koja vraca listu korisnika iz baze.
	 * Koristi klase {@link Statement} i {@link ResultSet}, kao
	 * i upit definisan u metodi kako bi iz baze dobila listu
	 * svih korisnika.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return lista korisnika.
	 */	
	public ArrayList<Korisnik> vratiKorisnike() {
		ArrayList<Korisnik> lista= new ArrayList<Korisnik>();
		String upit="SELECT * FROM Korisnik";
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
				Korisnik kor= new Korisnik(rs.getLong(1), rs.getString(2)
						, rs.getString(3), rs.getString(4), rs.getString(5));
lista.add(kor)			;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	/**
	 * Metoda koja cuva kreirani pogon.
	 * Cuvanje u bazi omoguceno je putem klase {@link PreparedStatement}
	 * i upita definisanog u metodi.
	 * @param pogon Informacije o pogonu koji se cuva.
	 * @throws SQLException greska koja nastaje pri pokusaju izvrsenja 
	 * neadekvatnog upita nad podacima u bazi.
	 * @return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean sacuvajPogon(Pogon pogon) throws SQLException {
		String upit= "INSERT INTO pogon VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps= Konekcija.getInstance().getCon().prepareStatement(upit);
			ps.setLong(1, getPogonID());
			ps.setLong(3, pogon.getGrad().getGradID());
			ps.setLong(7, pogon.getKorisnik().getKorisnikID());
		    ps.setDate(2, new Date(pogon.getDatumPocetkaRada().getTime()));
		    ps.setString(4, pogon.getAdresa());
		    ps.setString(5, pogon.getKontakt());
		    ps.setBoolean(6, pogon.isAktivan());
			ps.executeUpdate();
			Konekcija.getInstance().getCon().commit();
			return true;
		} catch (SQLException e) {
			Konekcija.getInstance().getCon().rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Metoda vraca broj koji je za jedan veci od najveceg identifikatora
	 * pogona koji postoji u bazi.
	 * Kreirana je kako bi objektu novog pogona dodelila jedinstveni 
	 * identifikator i tako ispunila ogranicenje pre unosa objekta u bazu podataka.
	 * Vraca informaciju o maksimalnom idju pogona koju dobija
	 * iz baze preko definisanog upita, koristeci klase {@link Statement}
	 * i {@link ResultSet} .
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return Jedinstveni identifikator pogona.
	 */
	private long getPogonID() {
		long pogonID=0;
		String upit="SELECT MAX(PogonID) FROM pogon";
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
			pogonID=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ++pogonID;
	}
	/**
	 * Metoda koja menja podatke o odredjenom pogonu.
	 * Izmena u bazi omogucena je putem klase {@link PreparedStatement}
	 * i upita definisanog u metodi, kome se prosledjuje
	 * identifikator odgovarajuceg pogona i novi podaci koje je potrebno 
	 * uneti.
	 * @param pogonIzmena Informacije o pogonu koji se menja.
	 * @throws SQLException greska koja nastaje pri pokusaju izvrsenja
	 *  neadekvatnog upita nad podacima u bazi.
	 * @return <ul>
		 * 		<li> true - ako je izmena uspesna. </li>
		 * 		<li> false - ako izmena nije uspesna. </li>
		 * </ul>
	 */
	public boolean izmeniPogon(Pogon pogonIzmena) throws SQLException {
		String upit= "UPDATE pogon SET DatumPocetkaRada=?, GradID=?, Adresa=?, Kontakt=?, Aktivan=? ,NadlezniID=? WHERE PogonID=?";
		try {
			PreparedStatement ps= Konekcija.getInstance().getCon().prepareStatement(upit);
			ps.setLong(2, pogonIzmena.getGrad().getGradID());
			ps.setLong(6, pogonIzmena.getKorisnik().getKorisnikID());
		    ps.setDate(1, new Date(pogonIzmena.getDatumPocetkaRada().getTime()));
		    ps.setString(3, pogonIzmena.getAdresa());
		    ps.setString(4, pogonIzmena.getKontakt());
		    ps.setBoolean(5, pogonIzmena.isAktivan());
		    ps.setLong(7, pogonIzmena.getPogonID());
			ps.executeUpdate();
			Konekcija.getInstance().getCon().commit();
			return true;
		} catch (SQLException e) {
			Konekcija.getInstance().getCon().rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Metoda koja vraca listu jedinica mere iz baze.
	 * Koristi klase {@link Statement} i {@link ResultSet}, kao
	 * i upit definisan u metodi kako bi iz baze dobila listu
	 * svih jedinica mere.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return lista jedinica mere.
	 */
	public ArrayList<JedinicaMere> vratiJediniceMere() {
		ArrayList<JedinicaMere> lista= new ArrayList<JedinicaMere>();
		String upit="SELECT * FROM jedinicamere";
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
              JedinicaMere jm= new JedinicaMere(rs.getLong(1), rs.getString(2));
              lista.add(jm);}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;

	}
	/**
	 * Metoda koja cuva kreirani proizvod.
	 * Cuvanje u bazi omoguceno je putem klase {@link PreparedStatement}
	 * i upita definisanog u metodi.
	 * Cuvanje ce biti omoguceno tek onda kada su i svi elementi
	 * proizvoda sacuvani, u suprotnom se izvrsenje transakcije prekida
	 * i nista nece biti sacuvano.
	 * @param proizvod Informacije o proizvodu koji se cuva.
	 * @throws SQLException greska koja nastaje pri pokusaju izvrsenja 
	 * neadekvatnog upita nad podacima u bazi.
	 * @return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean sacuvajProizvod(Proizvod proizvod) throws SQLException {
		String upit= "INSERT INTO proizvod VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps= Konekcija.getInstance().getCon().prepareStatement(upit);
			ps.setLong(1, getProizvodID());
			proizvod.setProizvodID(getProizvodID());
			ps.setLong(8, proizvod.getKorisnik().getKorisnikID());
		    ps.setString(2, proizvod.getNazivProizvoda());
		    ps.setString(3, proizvod.getOpisProizvoda());
		    ps.setDouble(4, proizvod.getKolicinaNaStanju());
		    ps.setBoolean(5, proizvod.isPatent());
		    ps.setInt(6, proizvod.getVekTrajanjaUMesecima());
		    ps.setDate(7, new Date(proizvod.getDatumPocetkaProizvodnje().getTime()));
			ps.executeUpdate();
			if(sacuvajElementeProizvoda(proizvod)) {
			Konekcija.getInstance().getCon().commit();
			return true;}
			else {
				Konekcija.getInstance().getCon().rollback();
				return false;
			}
		} catch (SQLException e) {
			Konekcija.getInstance().getCon().rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Metoda koja cuva listu unetih elemenata proizvoda.
	 * Metoda prolazi kroz listu elemenata proizvoda i dodaje
	 * jedan po jedan.
	 * Cuvanje u bazi omoguceno je putem klase {@link PreparedStatement}
	 * i upita definisanog u metodi.
	 * @param proizvod Informacije o proizvodu koji sadrzi listu
	 * elemenata koju je potrebno sacuvati.
	 * @throws SQLException greska koja nastaje pri pokusaju izvrsenja 
	 * neadekvatnog upita nad podacima u bazi.
	 * @return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	private boolean sacuvajElementeProizvoda(Proizvod proizvod) throws SQLException {
		String upit= "INSERT INTO elementproizvoda VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps= Konekcija.getInstance().getCon().prepareStatement(upit);
		    ArrayList<ElementProizvoda> lista= proizvod.getSastavnica();
		    for (ElementProizvoda elementProizvoda : lista) {
				ps.setLong(1, proizvod.getProizvodID());
				ps.setLong(2, elementProizvoda.getRbr());
				ps.setLong(3, elementProizvoda.getMaterijal().getMaterijalID());
				ps.setLong(4, elementProizvoda.getJedinicaMere().getJMID());
				ps.setDouble(5, elementProizvoda.getKolicina());
                ps.addBatch();
			}
			ps.executeBatch();
			Konekcija.getInstance().getCon().commit();
			return true;
		} catch (SQLException e) {
			Konekcija.getInstance().getCon().rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Metoda vraca broj koji je za jedan veci od najveceg identifikatora
	 * proizvoda koji postoji u bazi.
	 * Kreirana je kako bi objektu novog proizvoda dodelila jedinstveni 
	 * identifikator i tako ispunila ogranicenje pre unosa objekta u bazu podataka.
	 * Vraca informaciju o maksimalnom idju proizvoda koju dobija
	 * iz baze preko definisanog upita, koristeci klase {@link Statement}
	 * i {@link ResultSet} .
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return Jedinstveni identifikator proizvoda.
	 */
	private long getProizvodID() {
		long proizvodID=0;
		String upit="SELECT MAX(proizvodID) FROM proizvod";
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
			proizvodID=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ++proizvodID;
	}
	/**
	 * Metoda koja vraca listu proizvoda iz baze.
	 * Koristi klase {@link Statement} i {@link ResultSet}, kao
	 * i upit definisan u metodi kako bi iz baze dobila listu
	 * svih proizvoda.
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return lista proizvoda.
	 */
	public ArrayList<Proizvod> vratiProizvode() {
		ArrayList<Proizvod> lista= new ArrayList<Proizvod>();
		String upit="SELECT * FROM proizvod p JOIN korisnik k ON(p.korisnikID=k.korisnikID)";
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
				Korisnik kor= new Korisnik(rs.getLong(9),rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
Proizvod pro= new Proizvod(rs.getLong(1), rs.getString(2),  rs.getString(3), rs.getDouble(4), rs.getBoolean(5), rs.getInt(6), rs.getDate(7), kor, null);
           lista.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	/**
	 * Metoda koja brise odredjeni proizvod.
	 * Brisanje iz baze omoguceno je putem klase {@link PreparedStatement}
	 * i upita definisanog u metodi, kom se prosledjuje 
	 * identifikator proizvoda koji je potrebno obrisati.
	 * @param proizvodBris Informacije o proizvodu koji se brise.
	 * @throws SQLException greska koja nastaje pri pokusaju izvrsenja 
	 * neadekvatnog upita nad podacima u bazi.
	 * @return <ul>
		 * 		<li> true - ako je brisanje uspesno. </li>
		 * 		<li> false - ako brisanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean obrisiProizvod(Proizvod proizvodBris) throws SQLException {
		String upit= "DELETE FROM proizvod WHERE proizvodID=?";
		try {
			PreparedStatement ps= Konekcija.getInstance().getCon().prepareStatement(upit);
			ps.setLong(1, proizvodBris.getProizvodID());
			
			ps.executeUpdate();
		
			Konekcija.getInstance().getCon().commit();
			return true;
		
		} catch (SQLException e) {
			Konekcija.getInstance().getCon().rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Metoda koja cuva kreiranu proizvodnju.
	 * Cuvanje u bazi omoguceno je putem klase {@link PreparedStatement}
	 * i upita definisanog u metodi.
	 * Cuvanje ce biti omoguceno tek onda kada su i svi elementi
	 * proizvodnje sacuvani, u suprotnom se izvrsenje transakcije prekida
	 * i nista nece biti sacuvano.
	 * @param proizvodnja Informacije o proizvodnji koja se cuva.
     * @throws SQLException greska koja nastaje pri pokusaju izvrsenja 
	 * neadekvatnog upita nad podacima u bazi.
	 * @return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	public boolean sacuvajProizvodnju(Proizvodnja proizvodnja) throws SQLException {
		String upit= "INSERT INTO proizvodnja VALUES(?,?,?,?,?)";
		proizvodnja.setProizvodnjaID(getProizvodnjaID());

		try {
			PreparedStatement ps= Konekcija.getInstance().getCon().prepareStatement(upit);
			ps.setLong(1, getProizvodnjaID());
			ps.setLong(4, proizvodnja.getPogon().getPogonID());
			ps.setLong(5, proizvodnja.getKorisnik().getKorisnikID());
            ps.setDate(2, new Date(proizvodnja.getDatumVremePocetka().getTime()));
            ps.setDate(3, new Date(proizvodnja.getDatumVremeZavrsetka().getTime()));
			ps.executeUpdate();
			if(sacuvajElementeProizvodnje(proizvodnja)) {
			Konekcija.getInstance().getCon().commit();
			return true;}
			else {
				Konekcija.getInstance().getCon().rollback();
				return false;
			}
		} catch (SQLException e) {
			Konekcija.getInstance().getCon().rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Metoda koja cuva listu unetih elemenata proizvodnje.
	 * Metoda prolazi kroz listu elemenata proizvodnje i dodaje
	 * jedan po jedan.
	 * Cuvanje u bazi omoguceno je putem klase {@link PreparedStatement}
	 * i upita definisanog u metodi.
	 * @param proizvodnja Informacije o proizvodnji koja sadrzi listu
	 * elemenata koju je potrebno sacuvati.
	 * @throws SQLException greska koja nastaje pri pokusaju izvrsenja 
	 * neadekvatnog upita nad podacima u bazi.
	 * @return <ul>
		 * 		<li> true - ako je cuvanje uspesno. </li>
		 * 		<li> false - ako cuvanje nije uspesno. </li>
		 * </ul>
	 */
	private boolean sacuvajElementeProizvodnje(Proizvodnja proizvodnja) throws SQLException {
		String upit= "INSERT INTO elementproizvodnje VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps= Konekcija.getInstance().getCon().prepareStatement(upit);
		    ArrayList<ElementProizvodnje> lista= proizvodnja.getIzlazi();
		    for (ElementProizvodnje elementProizvodnje : lista) {
				ps.setLong(1, proizvodnja.getProizvodnjaID());
				ps.setLong(2, elementProizvodnje.getRbr());
				ps.setLong(3, elementProizvodnje.getProizvod().getProizvodID());
				ps.setLong(4, elementProizvodnje.getJedinicaMere().getJMID());
				ps.setDouble(5, elementProizvodnje.getKolicina());
                ps.addBatch();
			}
			ps.executeBatch();
			Konekcija.getInstance().getCon().commit();
			return true;
		} catch (SQLException e) {
			Konekcija.getInstance().getCon().rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Metoda vraca broj koji je za jedan veci od najveceg identifikatora
	 * proizvodnje koji postoji u bazi.
	 * Kreirana je kako bi objektu nove proizvodnje dodelila jedinstveni 
	 * identifikator i tako ispunila ogranicenje pre unosa objekta u bazu podataka.
	 * Vraca informaciju o maksimalnom idju proizvodnje koju dobija
	 * iz baze preko definisanog upita, koristeci klase {@link Statement}
	 * i {@link ResultSet} .
	 * Baca SQLException pri pokusaju izvrsenja neadekvatnog upita nad podacima u bazi.
	 * @return Jedinstveni identifikator proizvodnje.
	 */
	private long getProizvodnjaID() {
		long proizvodnjaID=0;
		String upit="SELECT MAX(ProizvodnjaID) FROM proizvodnja";
		try {
			Statement st= Konekcija.getInstance().getCon().createStatement();
			ResultSet rs= st.executeQuery(upit);
			while (rs.next()) {
			proizvodnjaID=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ++proizvodnjaID;
	}


}
