package io.benyon.jpajwt.repositories;

import io.benyon.jpajwt.models.BookedTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookedTicketRepository extends JpaRepository<BookedTicket, Long> {
   List <BookedTicket> findAll();
   Optional<BookedTicket> findById(Long id);
   List<BookedTicket> findAllById(Long id);
  
}
