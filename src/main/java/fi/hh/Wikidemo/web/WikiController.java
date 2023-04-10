package fi.hh.Wikidemo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.Wikidemo.domain.Character;
import fi.hh.Wikidemo.domain.CharacterRepository;
import fi.hh.Wikidemo.domain.Location;
import fi.hh.Wikidemo.domain.LocationRepository;

@Controller
public class WikiController {
	@RequestMapping(value="/index", method=RequestMethod.GET)
		public String mainPage(Model model){
			return "index";
	}
	
	@Autowired
	private CharacterRepository chararepository;
	
	@Autowired
	private LocationRepository locationrepository;
	
	
	@RequestMapping(value="/characterlist", method=RequestMethod.GET)
		public String showCharacters(Model model){
			model.addAttribute("characters", chararepository.findAll());
			return "characterlist";
	}
	
	@RequestMapping(value="/add")
	@PreAuthorize("hasAuthority('ADMIN')")
		public String AddCharacter(Model model){
			model.addAttribute("newCharacter", new Character());
			model.addAttribute("locations", locationrepository.findAll());
			return "addCharacter";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
		public String deleteCharacter(@PathVariable("id") Long id, Model model){
			chararepository.deleteById(id);
			return "redirect:../characterlist";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editCharacter(@PathVariable("id") Long id, Model model){
	model.addAttribute("editableCharacter", chararepository.findById(id));
	model.addAttribute("locations", locationrepository.findAll());
	return "editCharacter";
}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
		public String saveCharacter(@Valid @ModelAttribute("newCharacter") Character character,BindingResult bindingResult, Model model){
			
			if(bindingResult.hasErrors()){
				model.addAttribute("locations", locationrepository.findAll());
				return "addCharacter";
			}
			
			chararepository.save(character);
			return "redirect:characterlist";
	}
	
	@RequestMapping(value="/locationlist", method=RequestMethod.GET)
	public String showLocations(Model model){
		model.addAttribute("locations", locationrepository.findAll());
		return "locationlist";
	}
	
	@RequestMapping(value="/addLocation")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String AddLocation(Model model){
		model.addAttribute("newLocation", new Location());
		return "addLocation";
	}

	@RequestMapping(value="/deleteLocation/{locationid}", method=RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteLocation(@PathVariable("locationid") Long locationid, Model model){
		locationrepository.deleteById(locationid);
		return "redirect:../locationlist";
	}

	@RequestMapping(value="/editLocation/{locationid}", method=RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editLocation(@PathVariable("locationid") Long locationid, Model model){
		model.addAttribute("editableLocation", locationrepository.findById(locationid));
		return "editLocation";
	}
	
	@RequestMapping(value="/saveLocation", method=RequestMethod.POST)
	public String saveLocation(@Valid @ModelAttribute("newLocation") Location location, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "addLocation";
		}
		locationrepository.save(location);
		return "redirect:locationlist";
	}
}
