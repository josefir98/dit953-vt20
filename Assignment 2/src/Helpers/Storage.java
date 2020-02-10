package Helpers;

import Abstract.Car;
import Abstract.Truck;
import Models.CarCarrierScania;

import java.util.Stack;

public class Storage<T extends Car, L extends Truck> {
    private Stack<T> storage = new Stack<T>();

    public T unLoad(L truck, T car, int platStage) {
        if (platStage == 1) {
            car.setX(truck.getX() - 3);
            car.setY(truck.getY() - 3);
            return storage.pop();
        }else {
            throw new RuntimeException("Platform must be down!");
        }
    }

    public void load(L truck, T car, int platStage) {
        if (distance(truck, car) <= 5 && platStage == 1) {
            storage.add(car);
            car.setX(truck.getX());
            car.setY(truck.getY());
        }else {
            throw new RuntimeException("Car must be within 5 units and platform must be down!");
        }
    }

    public double distance(L truck, T car) {
        double x1 = truck.getX();
        double y1 = truck.getY();
        double x2 = car.getX();
        double y2 = car.getY();
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
