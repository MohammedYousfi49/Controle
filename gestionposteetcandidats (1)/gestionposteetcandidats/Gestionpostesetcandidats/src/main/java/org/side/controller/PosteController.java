package org.side.controller;

import java.time.LocalDate;
import java.util.List;

import org.side.entities.Poste;
import org.side.entities.PosteDto;
import org.side.service.PosteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
public class PosteController {
	private final PosteService posteService;

	public PosteController(PosteService posteService) {
		this.posteService = posteService;
	}

	@GetMapping("/postes")
	public String listPostes(Model model) {
		List<Poste> postes = posteService.getAllPostes();
		model.addAttribute("postes", postes);
		return "Postes/index";
	}

	@GetMapping("/postes/new")
	public String createPosteForm(Model model) {
		Poste poste = new Poste();
		model.addAttribute("poste", poste);
		return "Postes/create";
	}

	@PostMapping("/postes")
	public String savePoste(@ModelAttribute("poste") Poste poste) {
		posteService.savePoste(poste);
		return "redirect:/postes";
	}

	@GetMapping("/edit/{id}")
	public String editPoste(@PathVariable Long id, Model model) {
		Poste poste = posteService.getPosteById(id);
		if (poste == null) {
			model.addAttribute("errorMessage", "Poste not found with ID: " + id);
			return "error"; // Redirect to an error page or display an error message
		}
		model.addAttribute("poste", poste);
		return "Postes/edit";
	}

	@PostMapping("/postes/{id}")
	public String updatePoste(@PathVariable long id, @ModelAttribute("poste") Poste poste) {
		Poste existingPoste = posteService.getPosteById(id);
		if (existingPoste == null) {
			// Handle the case where the Poste does not exist
			return "redirect:/error"; // Redirect to an error page
		}
		existingPoste.setTitre(poste.getTitre());
		existingPoste.setDescription(poste.getDescription());
		existingPoste.setDateFinCandidature(poste.getDateFinCandidature());
		posteService.updatePoste(existingPoste);
		return "redirect:/postes"; // Redirect to the list of postes
	}

	@GetMapping("/delete")
	public String deletePoste(@RequestParam long id) {
		posteService.deletePosteById(id);
		return "redirect:/postes";
	}
}
