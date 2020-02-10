package Helpers;

import Abstract.Car;

import java.util.Stack;

public class Storage<T extends Car> {
    private Stack<T> storage = new Stack<T>();

    T unLoad(){
        return storage.pop();
    }

    void load(T car){
        storage.add(car);
    }
}
