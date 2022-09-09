package io.benyon.jpajwt.services;

import io.benyon.jpajwt.models.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService{
  @Autowired
  private JavaMailSender javaMailSender;
  
  @Override
  public String sendSimpleMail(EmailDetails emailDetails) {
    try {
      SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setFrom("noreply@traintravel.com");
      mailMessage.setTo(emailDetails.getRecipient());
      mailMessage.setText(emailDetails.getMessageBody());
      mailMessage.setSubject(emailDetails.getSubject());
      javaMailSender.send(mailMessage);
      return "Mail sent successfully";
    } catch (Exception e) {
      return "Error while sending mail";
    }
  }

  @Override
  public String sendSimpleWithAttachment(EmailDetails emailDetails) {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper;
    try{
      mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
      mimeMessageHelper.setFrom("noreply@traintravel.com");
      mimeMessageHelper.setTo(emailDetails.getRecipient());
      mimeMessageHelper.setText(emailDetails.getSubject());

      FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
      mimeMessageHelper.addAttachment(file.getFilename(), file);
      javaMailSender.send(mimeMessage);
      return "Mail sent successfully";
    }catch (MessagingException e){
      return "Error while sending mail";
    }
  }

}
