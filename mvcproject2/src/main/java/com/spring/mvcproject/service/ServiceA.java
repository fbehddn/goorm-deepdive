package com.spring.mvcproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    @Autowired
    private ServiceB serviceB; //1. 필드에서 의존성 주입

//    @Autowired //2. 생성자를 통한 의존성 주입
//    public ServiceA(ServiceB serviceB) {
//        this.serviceB = serviceB;
//    }
//
//    @Autowired //3. setter 통한 의존성 주입
//    public void setServiceB(ServiceB serviceB) {
//        this.serviceB = serviceB;
//    }

    public void methodA() {
        System.out.println("method in ServiceA");
        serviceB.methodB();
    }
}
