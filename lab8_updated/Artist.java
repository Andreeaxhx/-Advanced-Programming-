package lab8;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Artist {
	
public String name;
public String country;


public Faker faker = new Faker(new Locale("YOUR_LOCALE"));

//in aceasta clasa am facut un constructor, gettere si settere astfel incat numele si tara artistului sa fie generate random

public Artist(Faker name, Faker country) {
	super();
	this.name = faker.artist().name();//genereaza un nume de artist (care cam rar se intampla sa fie chiar muzician)
	this.country = faker.country().name();//genereaza un nume de tara
}

//setterele le folosesc ca sa atribui obiectelor noi create valori

public void setName(Faker faker) {
	this.name = faker.artist().name(); 
}
public void setCountry(Faker faker) {
	this.country = faker.country().name();
}

public String getName() {
	return name;
}
public String getCountry() {
	return country;
}

//toString ul a ramas de cand testam constructorul
@Override
public String toString() {
	return "Name: " + name + ", country: " + country;
}

}
