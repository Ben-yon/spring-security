package io.benyon.jpajwt.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotBlank
  @Size(max = 50)
  private String origin;
  
  @NotBlank
  @Size(max = 50)
  private String destination;
  
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;
  
  @OneToMany(mappedBy = "ticket", fetch = FetchType.EAGER)
  private Set<BookedTicket> bookedTickets;
  
  @NotBlank
  @Size(max = 15)
  private String ticketType;
  
  private Date dateOfDeparture;
  
  private Date dateOfArrival;

  @NotBlank
  private String seatNumber;



  public Ticket(){}

  public Ticket(String origin, String destination, String ticketType, Date dateOfDeparture, Date dateOfArrival, String seatNumber) {
    this.origin = origin;
    this.destination = destination;
    this.ticketType = ticketType;
    this.dateOfDeparture = dateOfDeparture;
    this.dateOfArrival = dateOfArrival;
    this.seatNumber = seatNumber;
  }

  public Date getDateOfDeparture() {
    return dateOfDeparture;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public void setDateOfDeparture(Date dateOfDeparture) {
    this.dateOfDeparture = dateOfDeparture;
  }

  public Date getDateOfArrival() {
    return dateOfArrival;
  }
  public void setDateOfArrival(Date dateOfArrival) {
    this.dateOfArrival = dateOfArrival;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }


  public String getTicketType() {
    return ticketType;
  }

  public void setTicket_type(String ticketType) {
    this.ticketType = ticketType;
  }
}
