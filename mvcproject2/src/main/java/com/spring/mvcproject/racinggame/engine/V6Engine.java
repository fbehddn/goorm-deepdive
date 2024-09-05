package com.spring.mvcproject.racinggame.engine;

import org.springframework.stereotype.Component;

@Component("v6")
public class V6Engine implements Engine{
    @Override
    public String start() {
        return "V6 Engine is starting...";
    }
}
