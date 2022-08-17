package io.benyon.jpajwt.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @NotBlank
  @Size(max = 50)
  private String from;
  
  @NotBlank
  @Size(max = 50)
  private String destination;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinTable(name = "user")
  private String user;
  
  @NotBlank
  @Size(max = 15)
  private String ticket_type;
  
  
  
}
