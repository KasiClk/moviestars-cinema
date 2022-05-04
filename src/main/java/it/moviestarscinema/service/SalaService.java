package it.moviestarscinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.moviestarscinema.model.Film;
import it.moviestarscinema.model.Sala;
import it.moviestarscinema.repository.SalaRepository;

@Service 
public class SalaService {

	@Autowired
	SalaRepository salaRepository; 
	
	public List<Sala> getAllSala (){ 
		
		return salaRepository.findAll(); 
	}
	
	public List<Sala> getSalaByNomeCitta (String citta) { 
		return salaRepository.findSalaByCitta(citta); 
	}
	
	public Sala getSalaById (Long id) { 
		return salaRepository.findById(id).get();
	}
	
	public Sala saveSala (Sala sala) { 
		
		return salaRepository.save(sala); 
	}
	
	public List<Sala> saveAllSala (List<Sala> sale) { 
		return salaRepository.saveAll(sale); 
	}
	
	public Sala updateSala(Sala sala) { 
		
		return salaRepository.save(sala); 
	}
	
	public void deleteFilm (Long id) { 
		
		salaRepository.deleteById(id);
	}
	
}
