package com.microservice.email.consumer;

import com.microservice.email.dtos.EmailDto;
import com.microservice.email.models.EmailModel;
import com.microservice.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    final EmailService emailservice;

    public EmailConsumer(final EmailService emailservice) {
        this.emailservice = emailservice;
    }


    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailservice.sendEmail(emailModel);

        System.out.println("E-mail Status: " + emailModel.getStatusEmail().toString());
    }
}
