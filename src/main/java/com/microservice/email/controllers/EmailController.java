package com.microservice.email.controllers;

import com.microservice.email.dtos.EmailDto;
import com.microservice.email.models.EmailModel;
import com.microservice.email.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    private final EmailService emailservice;

    public EmailController(EmailService emailservice) {
        this.emailservice = emailservice;
    }

    @PostMapping("/seding-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);

        this.emailservice.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);

    }
}
