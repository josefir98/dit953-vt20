package Abstract;

import java.awt.*;

public abstract class Motorized extends Vehicle {
    private double enginePower; // Engine power of the car

    /**
     * Superclass Motorized
     * @param modelName Name of motorized thing
     * @param color Color of motorized thing
     * @param enginePower Engine power of motorized thing
     */
    public Motorized(String modelName, Color color, double enginePower) {
        super(modelName, color);
        this.enginePower = enginePower;
        stopEngine();
    }

    /**
     * Getter for engine power
     * @return
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Initial speed of car when started
     */
    public void startEngine() {
        setCurrentSpeed(0.1);
    }

    /**
     * Speed of car when turned off
     */
    public void stopEngine() {
        setCurrentSpeed(0);
    }

    /**
     * Increasing currentSpeed variable
     * @param amount
     */
    public void incrementSpeed(double amount) {
        double speed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        if (speed > getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }

    /**
     * Decreasing currentSpeed variable
     * @param amount
     */
    public void decrementSpeed(double amount) {
        double speed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (speed < getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }
}
