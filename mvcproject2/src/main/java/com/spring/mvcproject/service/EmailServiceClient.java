package com.spring.mvcproject.service;

import com.spring.mvcproject.domain.SendEmailRequest;
import org.springframework.stereotype.Service;

@Service //Spring이 관리하는 서비스 빈으로 등록
public class EmailServiceClient {
    public void sendEmail(SendEmailRequest request) {
        System.out.println("Sending email to: " + request.getToAddress());
        System.out.println("Subject: " + request.getSubject());
        System.out.println("Body: " + request.getBody());;
    }
}
