package Generics;

import java.awt.*;

public abstract class Car extends Motorized {
    private int nrDoors; // Number of doors on the car

    protected enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
    private Size carSize;

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
