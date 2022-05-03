package it.moviestarscinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.moviestarscinema.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
