package io.benyon.jpajwt.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "bookedTicket")
public class BookedTicket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 50)
  private String customerName;

  @NotBlank
  @Size(max = 115)
  private String customerAddress;

  @NotBlank
  @Size(max = 50)
  private String customerEmail;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "ticket_id")
  private Ticket ticket;

  private Date bookDate;

  public BookedTicket() {
  }
  
  public BookedTicket(Long id, String customerName, String customerAddress, String customerEmail, Date bookDate) {
    this.id = id;
    this.customerName = customerName;
    this.customerAddress = customerAddress;
    this.customerEmail = customerEmail;
    this.bookDate = bookDate;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public Date getBookDate() {
    return bookDate;
  }

  public void setBookDate(Date bookDate) {
    this.bookDate = bookDate;
  }
}
