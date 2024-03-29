package lab5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable{
	private String name;
	private String path;
	
	private List <Document> documents = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Catalog(String name, String path /*, List<Document> documents*/) {
		super();
		this.name = name;
		this.path = path;
		//this.documents = documents;
	}

	@Override
	public String toString() {
		return "Catalog: name=" + name + ", path=" + path + ", documents=" + documents + "]";
	}
	
	public void add(Document doc) {
		 documents.add(doc);
		 }
	
	public Document findById(String id) {
		for (Document doc : documents) {
			 if (doc.getId().equals(id)) {
			 return doc;
			 }
			 }
			 return null;

		 }


}
