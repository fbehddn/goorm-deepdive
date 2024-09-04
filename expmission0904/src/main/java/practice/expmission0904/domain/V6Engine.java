package practice.expmission0904.domain;

import org.springframework.stereotype.Component;

@Component("v6Engine")
public class V6Engine implements Engine {

    @Override
    public void start() {
        System.out.println("V6 Engine is starting...");
    }
}
