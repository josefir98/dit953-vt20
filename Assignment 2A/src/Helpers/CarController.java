package Helpers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Abstract.*;
import Models.*;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(Color.BLACK));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                checkCol(car);
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }

        private void checkCol(Car car) {
            if (car.getX() < 0 || car.getX() > CarView.getWorldWidth() || car.getY() < 0 || car.getY() > CarView.getWorldHeight() - 240) {
                if (car.getX() < 0) {
                    car.setX(0);
                } else if (car.getX() > CarView.getWorldWidth()) {
                    car.setX(CarView.getWorldWidth());
                } else if (car.getY() < 0) {
                    car.setY(0);
                } else if (car.getY() > CarView.getWorldHeight() - 240) {
                    car.setY(CarView.getWorldHeight() - 240);
                }
                car.turnLeft();
                car.turnLeft();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brakeValue = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brakeValue);
        }
    }
}
