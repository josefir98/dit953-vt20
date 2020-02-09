package Models;

import Generics.Car;
import Generics.Vehicle;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * constructor for Models.Volvo240 using the superclass in the car.java file. Color can be specified here
     * @param color 
     */
    public Volvo240(Color color) {
        super("Models.Volvo240", 4, color, 100);
    }

    /**
     * How fast the car can accelerate
     * @return
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
