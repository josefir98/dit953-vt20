package Generics;

import java.awt.*;

public abstract class Car extends Motorized {
    private int nrDoors; // Number of doors on the car

    public Car(String modelName, int nrDoors, Color color, double enginePower) {
        super(modelName, color, enginePower);
    }

    /**
     * Getter for number of doors
     * @return
     */
    public int getNrDoors() {
        return nrDoors;
    }
}
