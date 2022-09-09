package io.benyon.jpajwt.services;

import io.benyon.jpajwt.models.EmailDetails;

public interface EmailService {
  String sendSimpleMail(EmailDetails emailDetails);

  String sendSimpleWithAttachment(EmailDetails emailDetails);
}
