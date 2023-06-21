package baza;
import java.sql.*;

public class Konekcija {
	private static Konekcija instance;
	private Connection con;
	public static Konekcija getInstance() {
		if(instance==null) instance= new Konekcija();
		return instance;
	}
	
	public Connection getCon() {
		return con;
	}
	
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
