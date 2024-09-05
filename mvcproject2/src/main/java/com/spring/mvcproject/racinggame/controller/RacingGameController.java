package com.spring.mvcproject.racinggame.controller;

import com.spring.mvcproject.racinggame.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RacingGameController {
    private final Car car;

    @Autowired
    public RacingGameController(Car car) {
        this.car = car;
    }

    @GetMapping("/race")
    @ResponseBody
    public String startRace() {
        car.startCar();
        return "Race started!";
    }

}
