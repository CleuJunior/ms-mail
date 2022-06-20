package com.microservice.email.services;

import com.microservice.email.enums.StatusEmail;
import com.microservice.email.models.EmailModel;
import com.microservice.email.repositories.EmailRepository;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;

    public EmailService(final EmailRepository emailRepository, final JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }


    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            this.emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        }
        catch(MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        finally {
            return this.emailRepository.save(emailModel);
        }
    }
}
