package practice.expmission0904.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practice.expmission0904.domain.Car;
import practice.expmission0904.domain.ElectricEngine;
import practice.expmission0904.domain.V6Engine;

@RestController
public class RacingGameController {
    private Car car;

    @Autowired
    public RacingGameController(Car car) {
        this.car = car;
    }

    @GetMapping("/race")
    public String startRace(@RequestParam(value = "engine", defaultValue = "v6Engine") String engineType) {
        if (engineType.equals("v6Engine")) {
            car = new Car(new V6Engine());
        } else if (engineType.equals("electricEngine")) {
            car = new Car(new ElectricEngine());
        }
        car.startRace();
        return "Race started with " + engineType;
    }
}
