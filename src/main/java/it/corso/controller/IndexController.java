package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Utente;
import it.corso.service.UtenteService;
import jakarta.validation.Valid;

//localhost:8080
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping
	public String getPage(
			Model model){
		Utente utente = new Utente();
//		utente.setNome("Laura");
//		utente.setEta(45);
//		utente.setUsername("ciao");
//		utente.setPassword("abc");
		
		model.addAttribute("utente", utente);
		return "index";
	}
	
	@PostMapping // per gestire le richieste che arrivano col metodo post
	public String formManager(
		@Valid // io ti salvo l'attributo nel model, il form fa tutto il lavoro, i olo recupero dal model con tutti i set ma prima devi validarmi (validation) il tutto con le annotazioni che ti ho indicato nel model utente
		@ModelAttribute("utente") Utente utente,
		BindingResult result) { // quando verrà invocato il metodo con richiesta metodo post, si andrà a cercare nel registro model ciò che è associato alla chiave utente e, quindi il nome, username e password, e lo recupera 
		if(result.hasErrors())
			return "index";
		utenteService.registrazioneUtente(utente);
		return "redirect:/";
	}
}
