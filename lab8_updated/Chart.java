package lab8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// in clasa Chart am construit o functie care introduce in tabela charts un loc in clasament si un album

public class Chart {
	Connection con = Database.returnConn();
	public void create(int rank, String albumName)
	{
		try {
		
			Statement stmt = con.createStatement();
	
			String sqlInsert = "insert into charts" + " (rank, album_name)" + " values ('" + rank + "', '" + albumName + "')";
		
			stmt.executeUpdate(sqlInsert);
	// apoi sfiseaza continutul tabelei
			
			ResultSet result = stmt.executeQuery("select * from charts");
			
			while (result.next()) {
				System.out.println(result.getInt("id") + ". " + result.getString("rank") + " - " + result.getString("album_name") );	
			}
	
		} catch (SQLException e) {e.printStackTrace();}
	}
}
