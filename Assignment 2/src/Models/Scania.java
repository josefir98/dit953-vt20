package Models;

import Generics.Vehicle;
import Interfaces.PlatForm;

import java.awt.*;

public class Scania extends Vehicle implements PlatForm {

    private final static double trimFactor = 1;

    private int platformStage;

    public Scania(Color color) {
        super("Models.Scania", 2, color, 90);
        platformStage = 0;
    }

    /**
     * How fast the truck can accelerate
     */
    @Override
    public double speedFactor() {
        if (getPlatStage() == 0)
        {
            return getEnginePower() * 0.01 * trimFactor;
        }else {
            return 0;
        }
    }

    @Override
    public int getPlatStage() {
        return platformStage;
    }

    @Override
    public void setPlatStage(int degree) {
        if (getCurrentSpeed() == 0) {
            if (degree <= 0 && degree >= 70) {
                platformStage = degree;
            }else {
                throw new RuntimeException("This platforms range is between 0-70 degrees!");
            }
        } else {
            throw new RuntimeException("Generics.Vehicle must be still too change platform stage!");
        }
    }
}