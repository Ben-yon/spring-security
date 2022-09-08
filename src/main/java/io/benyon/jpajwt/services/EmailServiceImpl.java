package io.benyon.jpajwt.services;

import io.benyon.jpajwt.models.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{
  @Autowired
  private JavaMailSender javaMailSender;
  
  @Override
  public String sendSimpleMail(EmailDetails emailDetails) {
    try{
      SimpleMailMessage mailMessage= new SimpleMailMessage();
      mailMessage.setFrom("noreply@traintravel.com");
      mailMessage.setTo(emailDetails.getRecipient());
      mailMessage.setText(emailDetails.getMessageBody());
      mailMessage.setSubject(emailDetails.getSubject());
      javaMailSender.send(mailMessage);
      return "Mail sent successfully";
    }catch (Exception e){
      return "Error while sending mail";
  }

  @Override
  public String sendSimpleWithAttachment(EmailDetails emailDetails) {
    
    return null;
  }
}
