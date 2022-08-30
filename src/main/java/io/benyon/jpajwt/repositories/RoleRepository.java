package io.benyon.jpajwt.repositories;

import io.benyon.jpajwt.models.ERole;
import io.benyon.jpajwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Integer>{ 
  Optional<Role> findByName(ERole name);
}
