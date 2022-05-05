package it.moviestarscinema.controller.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.moviestarscinema.model.Prenotazione;
import it.moviestarscinema.model.Proiezioni;
import it.moviestarscinema.service.FilmService;
import it.moviestarscinema.service.ProiezioniService;
import it.moviestarscinema.service.SalaService;

@Controller
@RequestMapping("/web")
public class ProiezioniControllerWeb {

	@Autowired
	ProiezioniService proiezioniService;

	@Autowired
	SalaService salaService;

	@Autowired
	FilmService filmService;

	Logger logger = LoggerFactory.getLogger(ProiezioniControllerWeb.class); 
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("sale", salaService.getAllSala());
		model.addObject("films", filmService.getAllFilm());
		model.addObject("proiezioni", proiezioniService.getAllProiezioni());
		return model;
	}

	@GetMapping("/proiezioni")
	public ModelAndView proiezioni() {
		ModelAndView model = new ModelAndView();
		model.setViewName("proiezioni");
		List<Proiezioni> proiezioni = proiezioniService.getAllProiezioni();
		model.addObject("proiezioni", proiezioni);
		return model;
	}

	@PostMapping("/inserisciPrenotazione")
	public ModelAndView aggiungiPrenotazione(Prenotazione prenotazione) {

		logger.info(prenotazione.toString()); // Inserire in Service Layer 
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
}
