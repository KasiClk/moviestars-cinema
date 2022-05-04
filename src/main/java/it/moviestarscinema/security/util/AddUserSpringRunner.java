package it.moviestarscinema.security.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.moviestarscinema.security.model.Role;
import it.moviestarscinema.security.model.Roles;
import it.moviestarscinema.security.model.User;
import it.moviestarscinema.security.repository.RoleRepository;
import it.moviestarscinema.security.repository.UserRepository;

@Component
public class AddUserSpringRunner implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

		Role role_admin = new Role();
		role_admin.setRoleName(Roles.ROLE_ADMIN);
		User user_admin = new User();
		Set<Role> roles = new HashSet<>();
		roles.add(role_admin);
		user_admin.setUserName("admin");
		user_admin.setPassword(bCrypt.encode("admin"));
		user_admin.setEmail("admin@domain.com");
		user_admin.setRoles(roles);
		user_admin.setActive(true);

		roleRepository.save(role_admin);
		userRepository.save(user_admin);
		
		
		User user_uimple = new User();
		Role role_user = new Role();
		role_user.setRoleName(Roles.ROLE_USER);
		Set<Role> roles_user = new HashSet<>();
		
		roles_user.add(role_user);
		user_uimple.setUserName("user");
		user_uimple.setPassword(bCrypt.encode("user"));
		user_uimple.setEmail("admin@domain.com");
		user_uimple.setRoles(roles_user);
		user_uimple.setActive(true);

		roleRepository.save(role_user);
		userRepository.save(user_uimple);

		
		
		
		

	}

}
