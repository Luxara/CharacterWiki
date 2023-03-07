package fi.hh.Wikidemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.Wikidemo.domain.Character;
import fi.hh.Wikidemo.domain.CharacterRepository;

@Controller
public class WikiController {
	@RequestMapping(value="/index", method=RequestMethod.GET)
		public String mainPage(Model model){
			return "index";
	}
	
	@Autowired
	private CharacterRepository chararepository;
	
	@RequestMapping(value="/characterlist", method=RequestMethod.GET)
		public String showCharacters(Model model){
			model.addAttribute("characters", chararepository.findAll());
			return "characterlist";
	}
	
	@RequestMapping(value="/add")
		public String AddCharacter(Model model){
			model.addAttribute("newCharacter", new Character());
			return "addCharacter";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
		public String deleteCharacter(@PathVariable("id") Long id, Model model){
			chararepository.deleteById(id);
			return "redirect:../characterlist";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model){
	model.addAttribute("editableCharacter", chararepository.findById(id));
	return "editCharacter";
}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
		public String saveCharacter(Character character){
			chararepository.save(character);
			return "redirect:characterlist";
	}
}
