package practice.expmission0904.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private final Engine engine;

    @Autowired
    public Car(@Qualifier("v6Engine") Engine engine) {
        this.engine = engine;
    }

    public void startRace() {
        engine.start();
    }
}
