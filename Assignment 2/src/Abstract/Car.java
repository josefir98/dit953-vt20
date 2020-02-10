package Abstract;

import java.awt.*;

public abstract class Car extends Motorized {
    private int nrDoors; // Number of doors on the car

    /**
     * Enum for size of car
     */
    protected enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
    private Size carSize;

    /**
     * Superclass car
     * @param modelName Name of car
     * @param carSize Size of car
     * @param nrDoors Number of doors on car
     * @param color Color of car
     * @param enginePower Engine power of car
     */
    public Car(String modelName, Size carSize, int nrDoors, Color color, double enginePower) {
        super(modelName, color, enginePower);
        this.nrDoors = nrDoors;
        this.carSize = carSize;
    }

    /**
     * Getter for number of doors
     * @return
     */
    public int getNrDoors() {
        return nrDoors;
    }
}
