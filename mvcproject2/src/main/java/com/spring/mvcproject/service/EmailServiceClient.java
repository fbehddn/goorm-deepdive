package com.spring.mvcproject.service;

import com.spring.mvcproject.domain.SendEmailRequest;

public class EmailServiceClient {
    public void sendEmail(SendEmailRequest request) {
        System.out.println("Sending email to: " + request.getToAddress());
        System.out.println("Subject: " + request.getSubject());
        System.out.println("Body: " + request.getBody());;
    }
}
