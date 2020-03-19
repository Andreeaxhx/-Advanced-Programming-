package lab5;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CatalogUtil {
	

	public static void save(Catalog catalog)  //metoda save (care cred ca face ce trebuie pentru ca dupa executie imi creeaza un file in path ul pe care il specific
	 throws IOException {
		 try{
			 FileOutputStream fs = new FileOutputStream(catalog.getPath()); //serializarea obiectului catalog
			 ObjectOutputStream os = new ObjectOutputStream(fs);
				 
			 os.writeObject(catalog); 
			 
			 os.close();
			 
			 System.out.println(catalog); //am afisat obiectul catalog doar ca sa-mi dau seama mai usor daca apeleaza corect metoda save
			 
				 } catch (FileNotFoundException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
					 
				 } catch (IOException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
				 } 
		 }
	 
	 public static Catalog load(String path) //metoda load (care nu merge - de asta am si comentat apelul ei
	 throws InvalidCatalogException, ClassNotFoundException, IOException { 
		 try{
			 FileInputStream fi = new FileInputStream(path); //in aceeasi idee ca mai sus, doar ca de data asta clasele sunt folosite pentru citire
			 ObjectInputStream os = new ObjectInputStream(fi); 
			 
			 Document doc1 = (Document)os.readObject();
			 Document doc2 = (Document)os.readObject();
			 
			 os.close();
			 
			 System.out.println(doc1);
			 System.out.println(doc2);
			 
		 } catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} ObjectInputStream os = null;
		return (Catalog)os.readObject();
	}
	 
	 public static void view(Document doc) //metoda view (care merge - deschide documentul specificat în path)
			 throws IOException, InvalidCatalogException, ClassNotFoundException {
			    
			        File file = new File("C:\\Users\\Asus\\eclipse-workspace\\lab5\\andreea.txt"); //constructorul cu path-ul dat ca argument
			        
			        if(!Desktop.isDesktopSupported()){ //se verifica daca sistemul de operare suporta clasa Desktop
			            System.out.println("Desktop is not supported");
			            return;
			        }
			        
			        Desktop desktop = Desktop.getDesktop();
			        if(file.exists()) desktop.open(file); //se deschide documentul doar daca acesta exista
			        
	 }
	 
	}
