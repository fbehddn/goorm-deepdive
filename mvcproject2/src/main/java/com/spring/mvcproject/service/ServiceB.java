package com.spring.mvcproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {
    @Autowired
    private ServiceA serviceA;

    public void methodB() {
        System.out.println("methodB");
        serviceA.methodA();
    }
}
