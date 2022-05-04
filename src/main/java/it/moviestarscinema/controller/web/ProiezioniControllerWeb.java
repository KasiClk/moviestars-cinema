package it.moviestarscinema.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.moviestarscinema.model.Proiezioni;
import it.moviestarscinema.service.ProiezioniService;

@Controller
@RequestMapping("/web")
public class ProiezioniControllerWeb {
	
	@Autowired
	ProiezioniService proiezioniService;
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");	
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
}
