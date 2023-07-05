package baza;
import java.sql.*;
/**
 *Klasa Konekcija uspostavlja konekciju sa bazom podataka.
 *U pitanju je singlton, sadrzi i objekat konekcija. 
 * @author Mirjana Dimitrijevic
 *
 */
public class Konekcija {
	/**
	 * Instanca klase Konekcija.
	 */
	private static Konekcija instance;
	/**
	 * Sesija sa bazom podataka sa kojom smo konetovani.
	 */
	private Connection con;
	/**
	 * Vraca instancu klase Konekcija.
	 * Singlton klasa moze imati samo jedan objekat, pa tako pri svakom 
	 * instanciranju ove klase, ta instanca pokazuje na jednu i jedinu
	 * instancu koja je kreirana kada se ova metoda prvi put pozvala.
	 * @return Instanca klase Konekcija.
	 */
	public static Konekcija getInstance() {
		if(instance==null) instance= new Konekcija();
		return instance;
	}
	/**
	 * Vraca konekciju sa bazom podataka.
	 *  @return Konekcija sa bazom.
	 */
	public Connection getCon() {
		return con;
	}
	/**
	 * Kreira objekat klase Konekcija, i uspostavlja konekciju sa bazom.
	 * Konekcija se uspostavlja uz pomoc {@link DriverManager} klase,
	 * koji pomaze u povezivanju drivera i baze podataka, uz pomoc
	 * putanje do baze, korisnickog imena i lozinke.
	 * Baca SQLException kada parametri za povezivanje sa bazom nisu ispravni.
	 */
	public Konekcija() {
		String url="jdbc:mysql://localhost:3306/maven-project";
		try {
			con=DriverManager.getConnection(url, "root", "");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
