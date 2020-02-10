package Abstract;

import java.awt.*;

public abstract class Truck extends Motorized {
    private int nrDoors; // Number of doors on the car

    public Truck(String modelName, int nrDoors, Color color, double enginePower) {
        super(modelName, color, enginePower);
        this.nrDoors = nrDoors;
    }

    /**
     * Getter for number of doors
     * @return
     */
    public int getNrDoors() {
        return nrDoors;
    }
}
