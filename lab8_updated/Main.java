package lab8;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Main{
	
	public static void main(String[] args) {
		
		//am creat toate obiectele necesare
		Database d1 = Database.getDatabase();
		d1.connect();
		
		Faker f1 = new Faker();
		Faker f2 = new Faker();
		Faker f3 = new Faker();
		
		ArtistController a1 = new ArtistController();
		
		//am stocat primul si ultimul id in cele doua variabile de mai jos
		int firstIdArtist = a1.firstId();
		int lastIdArtist = a1.lastId();
		//pentru a le putea folosi in generarea unui id random pe care urmeaza sa il atibui unui album
		int id = f1.number().numberBetween(firstIdArtist, lastIdArtist);
		
		Artist artist = new Artist(f1, f2);
		Album album = new Album(f1, id, f2);
		
		String name = artist.getName();
		String country = artist.getCountry();
		
		
		//a1.findByName("Titian");
		
		AlbumController aa1 = new AlbumController();
		
		String nameAlbum = album.getName();
		int year = album.getYear();
		
		
		//aa1.findByArtist(155);
		
		Chart chart = new Chart();
		
		// am facut acelasi lucru si pentru albume pentru ca voiam sa generez un loc in clasament in functie de cate albume
		// sunt in total in clasament, insa am renuntat la idee pentru ca nu functiona tocmai bine
		int firstIdAlbum = aa1.firstId();
		int lastIdAlbum = aa1.lastId();
		int rank = f1.number().numberBetween(firstIdAlbum, lastIdAlbum);
		
		for(int i=1; i<20; i++)
		{
			a1.create(name, country);
			aa1.create(nameAlbum, a1.getId(artist.getName()), year);
			chart.create(i, album.getName()); // asa ca am ales sa setez locul in clasament al unui album in functie de variabila i
			
			//mai departe am atribuit unui obiect de tip artist un nume si o tara
			artist.setName(f1);
			artist.setCountry(f1);
			//pe care le-am stocat mai apoi in naem si country pentru a le folosi in functia create de mai sus
			name=artist.getName();
			country=artist.getCountry();
			
			//in aceeasi maniera am procedat si pentru obiectul de tip album
			album.setName(f1);
			album.setId(id);
			album.setYear(f1);
			nameAlbum=album.getName();
			id=f1.number().numberBetween(firstIdArtist, lastIdArtist);
			year=album.getYear();
			
		}
		
		
		 
	}
}