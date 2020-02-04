package Generics;

import java.awt.*;

public abstract class Truck extends Motorized {
    private int nrDoors; // Number of doors on the car

    public Truck(String modelName, Color color, double enginePower) {
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
