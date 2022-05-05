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
import it.moviestarscinema.model.Proiezioni;
import it.moviestarscinema.service.ProiezioniService;

@RestController
@SecurityRequirement(name = "bearerAuth") // roba di swagger
@RequestMapping("/api")
public class ProiezioniController {

	Logger logger = LoggerFactory.getLogger(ProiezioniController.class);

	@Autowired
	ProiezioniService proiezioniService;

	@GetMapping("/proiezioni")
	public List<Proiezioni> getAllProiezioni() {
		logger.info("***** INVOCATO GETALLPROIEZIONI ******");

		return proiezioniService.getAllProiezioni();
	}

	@DeleteMapping("/eliminaProiezione")
	public HttpStatus deleteProiezione(@RequestParam Long idProiezione) {
		logger.info("***** INVOCATO DELETE PROIEZIONE ******");

		proiezioniService.deleteProiezione(idProiezione);

		return HttpStatus.OK;
	}

	@PutMapping("/aggiornaProiezione")
	public Proiezioni updateProiezione(@RequestBody Proiezioni proiezione) {
		logger.info("***** INVOCATO AGGIORNA PROIEZIONE ******");

		return proiezioniService.updateProiezione(proiezione);
	}

	@PostMapping("/inserisciProiezione")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Proiezioni inserisciProiezione(@RequestBody Proiezioni proiezione) {
		logger.info("***** INVOCATO INSERISCI SALA ******");

		return proiezioniService.saveProiezione(proiezione);
	}

}
