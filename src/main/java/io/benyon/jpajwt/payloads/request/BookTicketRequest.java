package io.benyon.jpajwt.payloads.request;

import java.util.Date;

public class BookTicketRequest {

  private String origin;
  private Date dateOfDeparture;
  private String destination;
  private Date dateOfArrival;
    
  private String seatNumber;
  private String ticketType;

  public String getTicketType() {
    return ticketType;
  }

  public void setTicketType(String ticketType) {
    this.ticketType = ticketType;
  }

  public Date getDateOfDeparture() {
    return dateOfDeparture;
  }

  public void setDateOfDeparture(Date dateOfDeparture) {
    this.dateOfDeparture = dateOfDeparture;
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

  public Date getDateOfArrival() {
    return dateOfArrival;
  }

  public void setDateOfArrival(Date dateOfArrival) {
    this.dateOfArrival = dateOfArrival;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }
}
