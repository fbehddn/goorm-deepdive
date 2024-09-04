package practice.expmission0904.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practice.expmission0904.domain.Car;
import practice.expmission0904.domain.Engine;

@RestController
public class RacingGameController {
    private Car car;
    private Engine v6Engine;
    private Engine electricEngine;

    @Autowired
    public RacingGameController(Car car,
                                @Qualifier("V6") Engine v6Engine,
                                @Qualifier("Electric") Engine electricEngine) {
        this.car = car;
        this.v6Engine = v6Engine;
        this.electricEngine = electricEngine;
    }

    @GetMapping("/race")
    public String startRace(@RequestParam(value = "engine", defaultValue = "V6") String engineType) {
        if (engineType.equals("V6")) {
            car.setEngine(v6Engine);
        } else if (engineType.equals("Electric")) {
            car.setEngine(electricEngine);
        } else return "유효하지 않은 엔진 이름";
        car.startRace();
        return "Race started with " + engineType;
    }
}
