import java.awt.*;

public class Car implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    private double x_pos = 0.0;
    private double y_pos = 0.0;
    Dir curDir = Dir.RIGHT;
    /**
     * Superclass for volvo240 and Saab95
     * @param modelName is the type of car
     * @param nrDoors number of doors
     * @param color color is the color
     * @param enginePower is the engine power of the car
     */
    public Car(String modelName, int nrDoors, Color color, double enginePower) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.curDir = Dir.RIGHT;
        stopEngine();
    }

    /**
     * Takes current speed and sees that it does not overstep enginePower
     * @param currentSpeed
     */
    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed >= enginePower) {
            this.currentSpeed = enginePower;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }
    /**
     * Getter for number of doors
     * @return
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Getter for amount of engine power
     * @return
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Getter for current speed of car
     * @return
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Getter for color of car
     * @return
     */
    public Color getColor(){
        return color;
    }

    /**
     * Setter for color of car
     * @param clr
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Initial speed of car when started
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }
    /**
     * Speed of car when turned off
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Increasing currentSpeed variable
     * @param amount
     */
    public void incrementSpeed(double amount){
    }

    /**
     * Decreasing currentSpeed variable
     * @param amount
     */
    public void decrementSpeed(double amount){
    }

    /**
     * Increases the speed of the car and checks if amount is outside the parameter 0 to 1
     * @param amount
     */
    public void gas(double amount){
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Parameter must be in intervall[0,1]");
        }
    }

    /**
     * Breaks the car and checks if amount is outside the parameter 0 to 1
     * @param amount
     */
    public void brake(double amount){
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Parameter must be in intervall[0,1]");
        }
    }
    /**
     * enum for direction of car
     */
    enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    /**
     * Moving position of the car on the x and y axis
     */
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
    /**
     * Turning car left depending of current orientation
     */
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
    /**
     * Turning car right depending of current orientation
     */
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
