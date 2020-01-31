import java.awt.*;

public class Car implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name

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

    public void incrementSpeed(double amount){
        System.out.println("hej");
    }

    public void decrementSpeed(double amount){
        System.out.println("hej");
    }
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void direction() {

    }

    double x_pos = 0.0;
    double y_pos = 0.0;
    Dir curDir = Dir.RIGHT;

    enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    @Override
    public void move() {
        if (curDir == Dir.UP){
            y_pos += currentSpeed;
        }
        else if (curDir == Dir.DOWN){
            y_pos -= currentSpeed;
        }
        else if (curDir == Dir.LEFT){
            x_pos -= currentSpeed;
        }
        else if (curDir == Dir.RIGHT){
            x_pos += currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        if(curDir == Dir.RIGHT) {
            curDir = Dir.UP;
        }
        else if(curDir == Dir.LEFT) {
            curDir = Dir.DOWN;
        }
        else if(curDir == Dir.UP) {
            curDir = Dir.LEFT;
        }
        else if(curDir == Dir.DOWN) {
            curDir = Dir.RIGHT;
        }
    }

    @Override
    public void turnRight() {
        if(curDir == Dir.RIGHT) {
            curDir = Dir.DOWN;
        }
        else if(curDir == Dir.LEFT) {
            curDir = Dir.UP;
        }
        else if(curDir == Dir.UP) {
            curDir = Dir.RIGHT;
        }
        else if(curDir == Dir.DOWN) {
            curDir = Dir.LEFT;
        }
    }
}
