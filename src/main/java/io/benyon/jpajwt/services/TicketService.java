package io.benyon.jpajwt.services;

import io.benyon.jpajwt.models.Ticket;
import io.benyon.jpajwt.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService{
  
  @Autowired
  TicketRepository ticketRepository;
  
  @Bean
  public List<Ticket> getAllTicket(){
    return ticketRepository.findAll();
  }
  
  public Optional getTicketById(Long id){
    return ticketRepository.findById(id);
  }
}
