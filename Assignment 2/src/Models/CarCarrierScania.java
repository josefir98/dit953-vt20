package Models;

import Abstract.Car;
import Abstract.Truck;
import Helpers.PlatForm;
import Helpers.Storage;

import java.awt.*;

public class CarCarrierScania extends Truck implements PlatForm {
    private final static double trimFactor = 1.1;
    private Storage<Car, CarCarrierScania> carsStored = new Storage();

    private int platformStage = 0;

    public CarCarrierScania(Color color) {
        super("Models.CarCarrierScania", 2, color, 95);
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
    public void setPlatStage(int stage) {
        if (getCurrentSpeed() == 0) {
            if (stage == 0 || stage == 1) {
                platformStage = stage;
            }else {
                throw new RuntimeException("This platforms has 2 stages, 0 and 1!");
            }
        } else {
            throw new RuntimeException("Generics.Vehicle must be still too change platform stage!");
        }
    }
}
