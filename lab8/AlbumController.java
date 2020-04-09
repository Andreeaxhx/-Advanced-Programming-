package lab8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
	
	//in mod similar ca in clasa ArtistController
	Connection conn = Database.returnConn();
	
	
	public void create(String name, int artistId, int releaseYear) {
		
		try {
	Statement stmt = conn.createStatement();
	
	stmt.executeUpdate("INSERT INTO albums( name, artist_id, release_year) VALUES ('" + name + "', '" + artistId + "', '" + releaseYear + "')" );
	
	ResultSet result = stmt.executeQuery("select * from albums"); 
	
	while(result.next())
	{
		System.out.println(result.getString("id") + ". " + result.getString("name") + " - " + result.getString("artist_id") + " - " + result.getString("release_year"));
	}
		}catch(SQLException e) {e.printStackTrace();}
	}

	

}
