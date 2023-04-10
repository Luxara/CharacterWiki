package fi.hh.Wikidemo.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.hh.Wikidemo.domain.Character;
import fi.hh.Wikidemo.domain.CharacterRepository;
import fi.hh.Wikidemo.domain.Location;
import fi.hh.Wikidemo.domain.LocationRepository;

@RestController
public class RestWikiController {
	
	@Autowired
	CharacterRepository characterRepository;
	@Autowired
	LocationRepository locationRepository;
	
	@CrossOrigin(origins = "*") //CrossOrigin access for own client side testing purposes
	@GetMapping("/characters")
	public Iterable<Character> getCharacters(){
		return characterRepository.findAll();
	}
	
	@CrossOrigin(origins = "*") //CrossOrigin access for own client side testing purposes
	@GetMapping("/characters/{id}")
	public Optional<Character> findCharacter(@PathVariable Long id){
		return characterRepository.findById(id);
	}
	
	@PostMapping("character")
	Character addNewCharacter(@RequestBody Character newCharacter){
		return characterRepository.save(newCharacter);
	}
	
	@PutMapping("/characters/{id}")
	Character editCharacter(@RequestBody Character editedCharacter, @PathVariable Long id){
		editedCharacter.setId(id);
		return characterRepository.save(editedCharacter);
	}
	
	@DeleteMapping("/characters/{id}")
	public Iterable <Character> deleteCharacter(@PathVariable Long id){
		characterRepository.deleteById(id);
		return characterRepository.findAll();
	}
	
	
	@GetMapping("/locations")
	public Iterable<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	@GetMapping("/locations/{id}")
	public Optional<Location> findLocation(@PathVariable Long id){
		return locationRepository.findById(id);
	}
	
	@PostMapping("location")
	Location addnewLocation(@RequestBody Location newLocation){
		return locationRepository.save(newLocation);
	}
	
	@PutMapping("/locations/{id}")
	Location editLocation(@RequestBody Location editedLocation, @PathVariable Long id){
		editedLocation.setLocationid(id);
		return locationRepository.save(editedLocation);
	}
	
	@DeleteMapping("/locations/{id}")
	public Iterable <Location> deleteLocation(@PathVariable Long id){
		locationRepository.deleteById(id);
		return locationRepository.findAll();
	}
}
