package baza;
import java.sql.*;
import java.util.ArrayList;

import domen.Grad;
import domen.Korisnik;
import domen.Materijal;
import domen.Pogon;
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


}
