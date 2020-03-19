package lab5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
	private String id;
	private String name;
	private String location; //filename or web page
	
	private Map <String, Object> tags = new HashMap<String, Object>() 
	
	{{
		put("author", 1);
		put("title", 2);
		put("year", 3);
	}};
	
	
	public Document(String id, String name, String location /*, Map<String, Object> tags*/) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		//this.tags = tags;
	}
	
	
	public void setData(String id, String name, String location, Map<String, Object> tags) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.tags = tags;
	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public Map<String, Object> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", location=" + location + ", tags=" + tags + "]";
	}
	
	
	
}