package Helpers;

import Abstract.Car;

import java.util.ArrayList;
import java.util.List;

public class CarGarage<T extends Car> {
    private int maxCars;
    private ArrayList<T> cars = new ArrayList<T>();

    public CarGarage(int maxCars) {
        this.maxCars = maxCars;
    }

    public T remove(T car) {
        cars.remove(car);
        return car;
    }

    public void add(T car) {
        if (cars.size() <= maxCars) {
            cars.add(car);
        }else{
            throw new RuntimeException("The Garage is full!");
        }
    }
}
