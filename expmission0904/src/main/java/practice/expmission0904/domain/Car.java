package practice.expmission0904.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    @Qualifier("V6")
    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void startRace() {
        if (engine != null) {
            engine.start();
        } else System.out.println("엔진이 할당되지 않음");
    }
}
