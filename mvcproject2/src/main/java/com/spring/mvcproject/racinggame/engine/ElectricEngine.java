package com.spring.mvcproject.racinggame.engine;

import org.springframework.stereotype.Component;

@Component("electric")
public class ElectricEngine implements Engine{
    @Override
    public String start() {
        return "Electric Engine is starting...";
    }
}
