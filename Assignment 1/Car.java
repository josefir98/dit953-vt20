import java.awt.*;

public class Car implements Movable {

    public String modelName; // The car model name
    public int nrDoors; // Number of doors on the car
    public Color color; // Color of the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car

    double x;
    double y;
    enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    Dir curDir = Dir.RIGHT;

    public Car(String modelName, int nrDoors, Color color, double enginePower) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    private void incrementSpeed(double amount){ }
    private void decrementSpeed(double amount){ }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        if(curDir == Dir.RIGHT) {
            x += currentSpeed;
        } else if (curDir == Dir.LEFT) {
            x -= currentSpeed;
        } else if (curDir == Dir.UP) {
            y += currentSpeed;
        } else if (curDir == Dir.DOWN) {
            y -= currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        if(curDir == Dir.RIGHT) {
            curDir = Dir.UP;
        } else if (curDir == Dir.LEFT) {
            curDir = Dir.DOWN;
        } else if (curDir == Dir.UP) {
            curDir = Dir.LEFT;
        } else if (curDir == Dir.DOWN) {
            curDir = Dir.RIGHT;
        }
    }

    @Override
    public void turnRight() {
        if(curDir == Dir.RIGHT) {
            curDir = Dir.DOWN;
        } else if (curDir == Dir.LEFT) {
            curDir = Dir.UP;
        } else if (curDir == Dir.UP) {
            curDir = Dir.RIGHT;
        } else if (curDir == Dir.DOWN) {
            curDir = Dir.LEFT;
        }
    }
}