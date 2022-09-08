package io.benyon.jpajwt.models;


public class EmailDetails {
  private String sender;
  private String recipient;
  private String messageBody;
  private String subject;

  
  public EmailDetails(String sender, String recipient, String messageBody, String subject, String attachment) {
    this.sender = sender;
    this.recipient = recipient;
    this.messageBody = messageBody;
    this.subject = subject;
    this.attachment = attachment;
  }

  private String attachment;

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public String getMessageBody() {
    return messageBody;
  }

  public void setMessageBody(String messageBody) {
    this.messageBody = messageBody;
  }

  public String getAttachment() {
    return attachment;
  }

  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }
}
