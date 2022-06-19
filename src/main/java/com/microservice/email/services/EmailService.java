package com.microservice.email.services;

import com.microservice.email.models.EmailModel;
import com.microservice.email.repositories.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    public EmailService(final EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }


    public void sendEmail(EmailModel emailModel) {
    }
}
