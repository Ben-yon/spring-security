package io.benyon.jpajwt.services;

import io.benyon.jpajwt.models.BookedTicket;
import io.benyon.jpajwt.repositories.BookedTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedTicketService {
  
  @Autowired
  BookedTicketRepository bookedTicketRepository;
  
  @Bean
  public List<BookedTicket> getAllBookedTickets(){
    return bookedTicketRepository.findAll();
  }
  
}
