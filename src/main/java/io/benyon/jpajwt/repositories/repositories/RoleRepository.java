package io.benyon.jpajwt.repositories.repositories;

import io.benyon.jpajwt.models.ERole;
import io.benyon.jpajwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional <Role> findByName(ERole name);
}
