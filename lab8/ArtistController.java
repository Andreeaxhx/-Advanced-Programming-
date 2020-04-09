package lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
	
	Connection conn = Database.returnConn();
	
	
	public void create(String name, String country) {
		
		try {

	Statement stmt = conn.createStatement();

		//se insereaza datele
	stmt.executeUpdate("INSERT INTO artists( name, country) VALUES ('" + name + "', '" + country + "')" );
		
		//se selecteaza toate datele din tabelul "artists"
	ResultSet result = stmt.executeQuery("select * from artists"); 
	
	while(result.next())
	{
		//si se afiseaza pe ecran
		System.out.println(result.getString("id") + ". " + result.getString("name") + " - " + result.getString("country"));
	}
		}catch(SQLException e) {e.printStackTrace();}
	}

	
}
