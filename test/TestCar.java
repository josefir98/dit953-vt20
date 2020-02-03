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

    @Test
    public void testSetAndGetCurrentSpeed() {
        car.setCurrentSpeed(20);
        assertTrue(car.getCurrentSpeed() == 20);
    }

    @Test
    public void testSetCurrentSpeed2() {
        car.setCurrentSpeed(-10);
        assertTrue(car.getCurrentSpeed() == 0);
    }

    @Test
    public void testSetCurrentSpeed3() {
        car.setCurrentSpeed(130);
        assertTrue(car.getCurrentSpeed() == 125);
    }

    @Test
    public void testGetAndSetColor() {
        car.setColor(Color.BLUE);
        assertTrue(car.getColor() == Color.BLUE);
    }

    @Test
    public void testStopEngine() {
        car.stopEngine();
        assertTrue(car.getCurrentSpeed() == 0);
    }

    @Test
    public void testStartEngine() {
        car.startEngine();
        assertTrue(car.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testGas1() {
        car.setCurrentSpeed(0);
        car.gas(0.5);
        assertTrue(car.getCurrentSpeed() == 0.625);
    }

    @Test
    public void testGas2() {
        try {
            car.gas(-1);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGas3() {
        try {
            car.gas(2);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testBrake1() {
        car.setCurrentSpeed(5);
        car.brake(0.5);
        assertTrue(car.getCurrentSpeed() == 4.375);
    }

    @Test
    public void testBrake2() {
        try {
            car.brake(-1);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testBrake3() {
        try {
            car.brake(2);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testBrake3() {
        try {
            car.brake(2);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
