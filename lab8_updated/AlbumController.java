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
	
	
	System.out.println("Albums--------------------------");
	while(result.next())
	{
		System.out.println(result.getString("id") + ". " + result.getString("name") + " - " + result.getString("artist_id") + " - " + result.getString("release_year"));
	}
		}catch(SQLException e) {e.printStackTrace();}
	}
	
	//am facut si functia de cautare dupa id-ul artistului care imi lipsea saptamana trecuta
	public void findByArtist(int artistId) {
		try {
		Statement stmt = conn.createStatement();
		
		//se selecteaza toate datele din tabelul "artists"
	ResultSet result = stmt.executeQuery("select * from albums where artist_id=" + artistId); 
	
	while(result.next())
	{
		//si se afiseaza pe ecran
		System.out.println(result.getString("id") + ". " + result.getString("name") + " - " + result.getString("artist_id") + " - " + result.getString("release_year"));	}
		}catch(SQLException e) {e.printStackTrace();}
	}
		
	
	public int firstId() {
		try {
		Statement stmt = conn.createStatement();
		
	ResultSet result = stmt.executeQuery("select id from albums" ); 
	while(result.next())
		return result.getInt("id");

		}catch(SQLException e) {e.printStackTrace();}
		return 0;
	}
	
	public int lastId() {
		try {
		Statement stmt = conn.createStatement();
		
	ResultSet result = stmt.executeQuery("select id from albums order by id desc" ); 
	while(result.next())
		return result.getInt("id");

		}catch(SQLException e) {e.printStackTrace();}
		return 0;
	}

	

}
