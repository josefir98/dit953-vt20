import java.awt.*;

public class Saab95 extends Vehicle {

    private boolean turboOn;

    /**
     * constructor for Saab95 using the superclass in the car.java file. Color can be specified here
     * @param color 
     */
    public Saab95(Color color) {
        super("Saab95", 2, color, 125);
        turboOn = false;
    }

    /**
     * Boolean for Turbo ON
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Boolean for Turbo OFF
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * How fast the car can accelerate
     * Will accelerate faster if turboOn is set to True
     * @return
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
