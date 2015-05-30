package guru.springframework.blog.dependencyinversionprinciple.lowlevel;

import guru.springframework.blog.dependencyinversionprinciple.highlevel.Switchable;

public class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Fan: Fan turned on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan: Fan turned off...");
    }
}
