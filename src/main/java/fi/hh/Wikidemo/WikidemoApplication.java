package fi.hh.Wikidemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.Wikidemo.domain.Character;
import fi.hh.Wikidemo.domain.CharacterRepository;

@SpringBootApplication
public class WikidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikidemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(CharacterRepository chararepository) {
		return (args) ->{
			
			Character character1 = new Character("Hanako","???","Female","Vampire","Feudal Japan","Lolesantana","Hanako is a fierce vampire from feudal Japan!");
			Character character2 = new Character("Freya","???","Female","Vampire","Ancient Norway","Lolesantana","Freya is a viking vampire whos well traveled.");
			
			chararepository.save(character1);
			chararepository.save(character2);
		};
	}
}
