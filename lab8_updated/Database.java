package lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/musicalbums";

	static final String USER = "dba"; //am memorat userul intr-o variabila desi nu cred ca era necesar
	static final String PASS = "sql"; //la fel pentru parola
	
	static Connection conn; //obiect de tip Connection
	
	
	static Database database = new Database(); //am creatun obiect de tip Database
	private Database(){} //si am declarat constructorul privat
	
	//functia getDatabase() care returneaza obiectul propriu-zis database pentru ca nu poate fi initializat (singletone class)
	public static Database getDatabase(){
		return database;
	}
	
	//in functia connect se realizeaza conexiunea
	public void connect()
	{
		try {
	
		conn = DriverManager.getConnection(DB_URL, USER, PASS); //se realizeaza conexiunea
		
		System.out.println("Connection established!"); //afisam si mesjaul
		
		} catch(Exception exc) {exc.printStackTrace();}
		
		
	}
	
	//aici am creat functia care returneaza obiectul de tip Connection ca sa nu mai fie nevoie sa il creez in cele doua clase
	public static Connection returnConn() {
		return conn;
	}

}
