package lab8;

public class Main{
	
	public static void main(String[] args) {
		
		//am creat toate obiectele necesare
		Database d1 = Database.getDatabase();
		d1.connect();
		
		ArtistController a1 = new ArtistController();
		//a1.create("6ix9ine", "America");
		//a1.create("Vali Vijelie", "Romania");
		//a1.create("Jessie J", "Anglia");
		
		AlbumController aa1 = new AlbumController();
		aa1.create("Dummy Boy", 5, 2018);
		
	}
}