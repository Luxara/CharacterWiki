package fi.hh.Wikidemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.Wikidemo.domain.Character;
import fi.hh.Wikidemo.domain.CharacterRepository;
import fi.hh.Wikidemo.domain.Location;
import fi.hh.Wikidemo.domain.LocationRepository;
import fi.hh.Wikidemo.domain.User;
import fi.hh.Wikidemo.domain.UserRepository;

@SpringBootApplication
public class WikidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikidemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(CharacterRepository chararepository, LocationRepository locationrepository, UserRepository userrepository) {
		return (args) ->{
			
			locationrepository.save(new Location("Lolesantana","The best place to be!"));
			locationrepository.save(new Location("Eden city","The future is now!"));
			
			Character character1 = new Character("Hanako","???","Female","Vampire","Feudal Japan", "Hanako is a proud vampire of japanese origin", locationrepository.findByName("Lolesantana").get(0));
			Character character2 = new Character("Freya","???","Female","Vampire","Ancient Norway","Freya is a viking vampire whos well traveled.", locationrepository.findByName("Lolesantana").get(0));
			
			chararepository.save(character1);
			chararepository.save(character2);
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
		};
	}
}
