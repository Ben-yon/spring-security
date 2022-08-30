package io.benyon.jpajwt.controllers;

import io.benyon.jpajwt.models.Ticket;
import io.benyon.jpajwt.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
  
  @Autowired
  TicketService ticketService;
  
  @GetMapping("")
  public List<Ticket> getAllTickets(){
    return ticketService.getAllTicket();
  }
  
  @PostMapping("/book-ticket")
  public void bookTicket(){
    
  }
}
