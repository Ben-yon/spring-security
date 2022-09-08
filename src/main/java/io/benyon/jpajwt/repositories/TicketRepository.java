package io.benyon.jpajwt.repositories;

import io.benyon.jpajwt.models.Ticket;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
  List<Ticket> findAll();
  Optional<Ticket> findById(Long id);
  List<Ticket> findAllById(Iterable<Long> longs);

  void deleteById(Long id);
  
}