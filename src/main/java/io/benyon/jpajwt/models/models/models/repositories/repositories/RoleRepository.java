package io.benyon.jpajwt.models.models.models.repositories.repositories;

import io.benyon.jpajwt.models.ERole;
import io.benyon.jpajwt.models.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional <Role> findByName(ERole name);
}
