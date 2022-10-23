package com.premukkoji.user;

import com.premukkoji.user.domain.Role;
import com.premukkoji.user.domain.User;
import com.premukkoji.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Snow", "johnsnow", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John Doe", "johndoe", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John Smith", "johnsmith", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John Carry", "johncarry", "1234", new ArrayList<>()));

			userService.addRoleToUser("johnsnow", "ROLE_USER");
			userService.addRoleToUser("johndoe", "ROLE_MANAGER");
			userService.addRoleToUser("johnsmith", "ROLE_ADMIN");
			userService.addRoleToUser("johncarry", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("johncarry", "ROLE_ADMIN");
			userService.addRoleToUser("johncarry", "ROLE_USER");
		};
	}
}
