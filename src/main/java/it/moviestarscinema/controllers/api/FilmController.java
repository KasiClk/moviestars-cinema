package it.moviestarscinema.controllers.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.moviestarscinema.model.Film;
import it.moviestarscinema.service.FilmService;

@RestController
@RequestMapping("/api")
public class FilmController {

	Logger logger = LoggerFactory.getLogger(FilmController.class);

	@Autowired
	FilmService filmService;

	@GetMapping("/films")
	public List<Film> getAllFilms() {
		logger.info("***** INVOCATO GETALLFILMS ******");

		return filmService.getAllFilm();
	}

	@DeleteMapping("/eliminaFilm")
	public HttpStatus deleteFilm(@RequestParam Long idFIlm) {
		logger.info("***** INVOCATO DELETE FILM ******");

		filmService.deleteFilm(idFIlm);

		return HttpStatus.OK;
	}

	@PutMapping("/aggiornafilm")
	public Film updateFilm(@RequestBody Film film) {
		logger.info("***** INVOCATO AGGIORNA FILM ******");

		return filmService.updateFilm(film);
	}

	@PostMapping("/inserisciFilm")
	public Film inserisciFilm(@RequestBody Film film) {
		logger.info("***** INVOCATO INSERISCI FILM ******");

		return filmService.saveFilm(film);
	}

}
