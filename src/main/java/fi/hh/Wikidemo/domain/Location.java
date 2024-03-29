package fi.hh.Wikidemo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity (name="locations")
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long locationid;
	
	
	@Size(min=1, max=250, message="")
	@NotEmpty(message="Cannot be empty.")
	private String name;
	private String text;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="home")
	@JsonIgnore
	private List<Character> characters;
	
	public Location() {
		
	}
	
	public Location(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}

	

	public Long getLocationid() {
		return locationid;
	}

	public void setLocationid(Long locationid) {
		this.locationid = locationid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
	
	

}
