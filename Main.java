package lab5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*cateva dintre paginile care m-au ajutat in "compunerea" codului (pe langa curs si toate materialele auxiliare de pe pagina laboratorului)
 * https://www.youtube.com/watch?v=YHu32fQ0A2Y
 * https://stackoverflow.com/questions/22459639/how-to-load-serialized-objects-in-java-by-parts
 * https://www.javatpoint.com/how-to-open-a-file-in-java
 * bineinteles, am preluat anumite secvente de cod doar dupa ce le-am inteles, si (cred ca) le-am adaptat corect problemei
 * */

public class Main {
	
	 public static void main(String[] args) throws IOException, InvalidCatalogException, ClassNotFoundException {

		 Document d1 = new Document("12", "Andreea", "Bt");
		 
		 Catalog c1 = new Catalog("articol", "C:\\Users\\Asus\\eclipse-workspace\\lab5\\textfile.txt");
		 CatalogUtil.save(c1);
		 //CatalogUtil.load("C:\\\\Users\\\\Asus\\\\eclipse-workspace\\\\lab5\\\\textfile.txt");
		 CatalogUtil.view(d1);
	 }

}
