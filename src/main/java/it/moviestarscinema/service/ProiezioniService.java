package it.moviestarscinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.moviestarscinema.model.Proiezioni;
import it.moviestarscinema.repository.ProiezioniRepository;

@Service
public class ProiezioniService {
	
	@Autowired
	ProiezioniRepository proiezioniRepository; 
	
	public List<Proiezioni> getAllProiezioni (){ 
		return proiezioniRepository.findAll(); 
	}
	
	public Proiezioni saveProiezione (Proiezioni proiezione) { 
		return proiezioniRepository.save(proiezione); 
	}
	
	public List<Proiezioni> saveAllProiezioni (List<Proiezioni> proiezioni) { 
		return proiezioniRepository.saveAll(proiezioni); 
	}
	
	public Proiezioni updateProiezione(Proiezioni proiezione) { 
		return proiezioniRepository.save(proiezione); 
	}
	
	public void deleteProiezione (Long id) { 
		proiezioniRepository.deleteById(id);
	}

}
