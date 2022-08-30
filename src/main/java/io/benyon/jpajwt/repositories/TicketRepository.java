package io.benyon.jpajwt.repositories;

import io.benyon.jpajwt.models.Ticket;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
  @Override
  List<Ticket> findAll();

  @Override
  Optional<Ticket> findById(Long aLong);

  @Override
  void deleteById(Long aLong);
  
}