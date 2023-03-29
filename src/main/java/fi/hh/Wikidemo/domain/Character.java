package fi.hh.Wikidemo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Character {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name, age, gender, race, origin, story;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "locationid")
	private Location home;

	public Character(){
		
	}

	

	public Character(String name, String age, String gender, String race, String origin, String story) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.race = race;
		this.origin = origin;
		this.story = story;
	}




	public Character(String name, String age, String gender, String race, String origin, String story, Location home) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.race = race;
		this.origin = origin;
		this.story = story;
		this.home = home;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public Location getHome() {
		return home;
	}


	public void setHome(Location home) {
		this.home = home;
	}


	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}
	
	

}
