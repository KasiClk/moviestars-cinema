package it.moviestarscinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.moviestarscinema.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
	public List<Sala> findSalaByCitta (String citta) ; 
}
