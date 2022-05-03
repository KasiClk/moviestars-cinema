package it.moviestarscinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.moviestarscinema.model.Film;
import it.moviestarscinema.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

}
