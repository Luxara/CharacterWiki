package fi.hh.Wikidemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.Wikidemo.domain.Character;
import fi.hh.Wikidemo.domain.CharacterRepository;
import fi.hh.Wikidemo.domain.Location;
import fi.hh.Wikidemo.domain.LocationRepository;

@SpringBootApplication
public class WikidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikidemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(CharacterRepository chararepository, LocationRepository locationrepository) {
		return (args) ->{
			
			locationrepository.save(new Location("Lolesantana","The best place to be!"));
			locationrepository.save(new Location("Eden city","The future is now!"));
			
			Character character1 = new Character("Hanako","???","Female","Vampire","Feudal Japan", "Hanako is a proud vampire of japanese origin", locationrepository.findByName("Lolesantana").get(0));
			Character character2 = new Character("Freya","???","Female","Vampire","Ancient Norway","Freya is a viking vampire whos well traveled.", locationrepository.findByName("Lolesantana").get(0));
			
			chararepository.save(character1);
			chararepository.save(character2);
		};
	}
}
