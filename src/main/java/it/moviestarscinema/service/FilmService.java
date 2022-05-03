package it.moviestarscinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.moviestarscinema.model.Film;
import it.moviestarscinema.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired
	FilmRepository filmRepository; 
	
	public List<Film> getAllFilm (){ 
		return filmRepository.findAll(); 
	}
	
	public Film saveFilm (Film film) { 
		return filmRepository.save(film); 
	}
	
	public Film updateFilm(Film film) { 
		return filmRepository.save(film); 
	}
	
	public void deleteFilm (Long id) { 
		filmRepository.deleteById(id);
	}
	
	

}
