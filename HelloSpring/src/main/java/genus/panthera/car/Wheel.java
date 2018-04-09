package genus.panthera.car;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Wheel {
    @Setter @Getter private String model;
    @Setter @Getter private int diameter;
}
