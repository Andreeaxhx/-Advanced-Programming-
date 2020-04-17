package lab8;

import com.github.javafaker.Faker;

public class Album {
	
public String name;
public int year;
public int id;


public Faker faker = new Faker();

//in aceasta clasa am facut un constructor, gettere si settere astfel incat numele, 
//id-ul artistului si anul aparitiei albumului sa fie generate random

public Album(Faker name, int id, Faker year) {
	super();
	this.name = faker.ancient().titan(); //pentru numele albumului am ales nume ale titanilor
	this.year = faker.number().numberBetween(1950, 2020); //ca data de lansare am ales un numar random intre 1950 si 2020
	this.id = faker.number().numberBetween(1, 5); // aici am ales un numar intre 1 si 5 pentru ca voiam sa vad daca afecteaza
													//in vreun fel apelurile din main, dar nu le afecteaza
}


//in aceeasi maniera ca il clasa artist am procedat si aigi cu constructorul, getterele si setterele
public void setName(Faker faker) {
	this.name = faker.artist().name();
}

public void setId(int id) {
	this.id = id;
}

public void setYear(Faker year) {
	this.year = faker.number().numberBetween(1950, 2020);
}

public String getName() {
	return name;
}

public int getId() {
	return id;
}

public int getYear() {
	return year;
}




@Override
public String toString() {
	return "Name: " + name + ", year: " + year;
}

}
