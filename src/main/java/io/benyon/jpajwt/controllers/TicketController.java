package io.benyon.jpajwt.controllers;

import io.benyon.jpajwt.models.Ticket;
import io.benyon.jpajwt.repositories.TicketRepository;
import io.benyon.jpajwt.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
  
  @Autowired
  TicketService ticketService;
  
  
  @Autowired
  TicketRepository ticketRepository;
  
  @GetMapping("")
  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
  public List<Ticket> getAllTickets(){
    return ticketService.getAllTicket();
  }
  
//  @PostMapping("/book-ticket")
//  @PreAuthorize("hasRole('USER')")
//  public ResponseEntity<?> bookTicket(@Valid @RequestBody BookTicketRequest bookTicketRequest){
//    Ticket ticket = new Ticket(
//      bookTicketRequest.getOrigin(),
//      bookTicketRequest.getDestination(),
//      bookTicketRequest.getTicketType(),
//      bookTicketRequest.getDateOfDeparture(),
//      bookTicketRequest.getDateOfArrival(),
//      bookTicketRequest.getSeatNumber()
//    );
//    ticketRepository.save(ticket);
//    
//    return ResponseEntity.ok(new MessageResponse("Ticket booked successfully!"));
//  }
  
  @GetMapping(value = "/{ticketId}")
  public Optional getTicketById(@PathVariable @NotNull Long ticketId){
    return this.ticketService.getTicketById(ticketId); 
  }
  
}
