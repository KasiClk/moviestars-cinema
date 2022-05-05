package it.moviestarscinema.controllers.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.moviestarscinema.model.Sala;
import it.moviestarscinema.service.SalaService;

@RestController
@SecurityRequirement(name = "bearerAuth") // roba di swagger
@RequestMapping("/api")
public class SalaController {

	Logger logger = LoggerFactory.getLogger(SalaController.class);

	@Autowired
	SalaService salaService;

	@GetMapping("/sale")
	public List<Sala> getAllSala() {
		logger.info("***** INVOCATO GETALLFILMS ******");

		return salaService.getAllSala();
	}

	@DeleteMapping("/eliminaSala")
	public HttpStatus deleteSala(@RequestParam Long idSala) {
		logger.info("***** INVOCATO DELETE FILM ******");

		salaService.deleteFilm(idSala);

		return HttpStatus.OK;
	}

	@PutMapping("/aggiornasala")
	public Sala updateFilm(@RequestBody Sala sala) {
		logger.info("***** INVOCATO AGGIORNA SALA ******");

		return salaService.updateSala(sala);
	}

	@PostMapping("/inserisciSala")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Sala inserisciFilm(@RequestBody Sala sala) {
		logger.info("***** INVOCATO INSERISCI SALA ******");

		return salaService.saveSala(sala);
	}

}
