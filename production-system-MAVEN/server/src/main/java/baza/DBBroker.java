package baza;
import java.sql.*;

import domen.Korisnik;
public class DBBroker {

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

}
