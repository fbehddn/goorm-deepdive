package com.spring.mvcproject.racinggame.car;

import com.spring.mvcproject.racinggame.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;

@Component
@RequestScope
public class Car {
    private final Map<String,Engine> engines;
    private Engine engine;

    @Autowired
    public Car(Map<String,Engine> engines) {
        this.engines = engines;
    }

    //사용자가 선택한 엔진 타입에 맞는 엔진을 설정하는 메서드
    public void setEngine(String engineType) {
        this.engine = engines.get(engineType.toLowerCase());
    }
    public void startCar() {
        System.out.println(engine.start());
    }
}
