package com.spring.mvcproject.racinggame.car;

import com.spring.mvcproject.racinggame.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(@Qualifier("v6") Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        System.out.println(engine.start());
    }
}
