package io.benyon.jpajwt;

import io.benyon.jpajwt.repositories.UserRepository;
import io.benyon.jpajwt.repositories.repositories.RoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JpaJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaJwtApplication.class, args);
	}

}
