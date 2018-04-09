package genus.panthera.car;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString(exclude = {"frontWheels", "backWheels"})
public class Car {
    @Setter @Getter private Engine engine;
    @Setter @Getter private Driver driver;
    @Setter @Getter private List<Wheel> frontWheels;
    @Setter @Getter private List<Wheel> backWheels;
    @Setter @Getter private Corpus corpus;

    @Setter @Getter private int speed;
    @Setter @Getter private int fuel;

    public void move() {
        System.out.println("va-roooom vooom vooom");
    }

    public Car speedup() {
        if (speed == 0) speed = 5;
        speed *= 2;
        return this;
    }

    public Car slowdown() {
        if (speed == 0) return this;
        speed /= 2;
        return this;
    }



}
