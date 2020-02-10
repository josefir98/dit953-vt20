import Models.CarCarrierScania;
import Models.Saab95;
import Models.Scania;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class Tester {
    Scania scania;
    CarCarrierScania carrier;

    @Before
    public void init() {
        scania = new Scania(Color.BLACK);
        carrier = new CarCarrierScania(Color.BLACK);
    }

    @Test
    public void testGetPlatStage() {
        assertTrue(scania.getPlatStage() == 0 && carrier.getPlatStage() == 0);
    }

    @Test
    public void testSetPlatStage() {
        scania.setPlatStage(50);
        carrier.setPlatStage(1);
        assertTrue(scania.getPlatStage() == 50 && carrier.getPlatStage() == 1);
    }
}
