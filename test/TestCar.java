import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestCar {

    private Saab95 car;

    @Before
    public void init() {
        car = new Saab95(Color.BLACK);
    }

    @Test
    public void testGetNrDoors() {
        assertTrue(car.getNrDoors() == 2);
    }

    @Test
    public void testGetEnginePower() {
        assertTrue(car.getEnginePower() == 125);
    }
}
