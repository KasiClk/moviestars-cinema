package it.moviestarscinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.moviestarscinema.model.Sala;
import it.moviestarscinema.repository.SalaRepository;

@Service 
public class SalaService {

	@Autowired
	SalaRepository salaRepository; 
	
	public List<Sala> getAllSala (){ 
		
		return salaRepository.findAll(); 
	}
	
	public Sala saveSala (Sala sala) { 
		
		return salaRepository.save(sala); 
	}
	
	public Sala updateSala(Sala sala) { 
		
		return salaRepository.save(sala); 
	}
	
	public void deleteFilm (Long id) { 
		
		salaRepository.deleteById(id);
	}
}
