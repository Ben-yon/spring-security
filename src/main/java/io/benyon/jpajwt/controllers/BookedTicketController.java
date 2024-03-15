package io.benyon.jpajwt.controllers;


import io.benyon.jpajwt.models.BookedTicket;
import io.benyon.jpajwt.models.EmailDetails;
import io.benyon.jpajwt.models.Ticket;
import io.benyon.jpajwt.payloads.request.BookTicketRequest;
import io.benyon.jpajwt.payloads.response.MessageResponse;
import io.benyon.jpajwt.repositories.BookedTicketRepository;
import io.benyon.jpajwt.services.BookedTicketService;
import io.benyon.jpajwt.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 54600)
@RestController
@RequestMapping("/api/bookedTickets/")
public class BookedTicketController {

  @Autowired
  BookedTicketService bookedTicketService;

  @Autowired
  BookedTicketRepository bookedTicketRepository;

  @Autowired
  EmailService emailService;

  @GetMapping("")
  @PreAuthorize("hasRole('ADMIN')")
  public List<BookedTicket> getAllBookedTickets() {
    return bookedTicketService.getAllBookedTickets();
  }

  @PostMapping("/book-ticket")
  public ResponseEntity<?> BookTicket(@Valid @RequestBody BookTicketRequest bookTicketRequest) {
    BookedTicket bookedTicket = new BookedTicket(
      bookTicketRequest.getTicket().getId(),
      bookTicketRequest.getCustomerName(),
      bookTicketRequest.getCustomerAddress(),
      bookTicketRequest.getCustomerEmail(),
      bookTicketRequest.getBookDate()
    );
    bookedTicketRepository.save(bookedTicket);
    EmailDetails emailDetails = new EmailDetails("no-reply@trainservice.com", bookedTicket.getCustomerEmail(), 
      "Ticket has been booked", "Booked Ticket","");
    emailService.sendSimpleMail(emailDetails);
    return ResponseEntity.ok(new MessageResponse("Ticket booked successfully!"));
  }
}
