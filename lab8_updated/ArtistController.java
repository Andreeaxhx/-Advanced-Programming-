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
	System.out.println("Artists-------------------");
	while(result.next())
	{
		//si se afiseaza pe ecran
		System.out.println(result.getString("id") + ". " + result.getString("name") + " - " + result.getString("country"));
	}
		}catch(SQLException e) {e.printStackTrace();}
	}

	//am facut si functia de cautare dupa nume care imi lipsea saptamana trecuta
	public void findByName(String name) {
		try {
		Statement stmt = conn.createStatement();
		
		//se selecteaza toate datele din tabelul "artists"
	ResultSet result = stmt.executeQuery("select * from artists where name='" + name + "'" ); 
	
	while(result.next())
	{
		//si se afiseaza pe ecran

		System.out.println(result.getString("id") + ". " + result.getString("name") + " - " + result.getString("country"));	}
		}catch(SQLException e) {e.printStackTrace();}
	}
	
	//funtia firstId care returneaza id-ul primului artist gasit in tabela artists
	public int firstId() {
		try {
		Statement stmt = conn.createStatement();
		
	ResultSet result = stmt.executeQuery("select id from artists" ); 
	while(result.next())
		return result.getInt("id");

		}catch(SQLException e) {e.printStackTrace();}
		return 0;
	}
	
	//funtia lastId care returneaza id-ul ultimului artist gasit in tabela artists
	//(practic, ea returneaza tot primul artist, dar din lista de artisti ordonata descrescator dupa id)
	public int lastId() {
		try {
		Statement stmt = conn.createStatement();
		
	ResultSet result = stmt.executeQuery("select id from artists order by id desc" ); 
	while(result.next())
		return result.getInt("id");

		}catch(SQLException e) {e.printStackTrace();}
		return 0;
	}
	
	//am mai creat o functie care creturneaza id-ul unui artist dat ca parametru
	public int getId(String name)
    {
        try {

            Statement stmt = conn.createStatement();

            ResultSet result = stmt.executeQuery("select id from artists where name like '" + name + "'");
            while (result.next())
                return result.getInt("id");

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return -1;
    }
}