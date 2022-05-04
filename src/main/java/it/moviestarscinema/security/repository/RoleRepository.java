package it.moviestarscinema.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.moviestarscinema.security.model.Role;
import it.moviestarscinema.security.model.Roles;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByRoleName(Roles role);
}
