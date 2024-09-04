package practice.expmission0904.domain;

import org.springframework.stereotype.Component;

@Component("Electric")
public class ElectricEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Electric Engine is starting...");
    }
}
