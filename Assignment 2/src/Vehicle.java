import java.awt.*;

public abstract class Vehicle implements Movable {

    private String modelName; // The car model name
    private int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car

    private double x;
    private double y;

    /**
     * enum for direction of car
     */
    private enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private Dir curDir;

    /**
     * Constructor for Vehicle
     * @param modelName is the type of car
     * @param nrDoors number of doors
     * @param color color is the color
     * @param enginePower is the engine power of the car
     */
    public Vehicle(String modelName, int nrDoors, Color color, double enginePower) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.curDir = Dir.RIGHT;
        stopEngine();
    }

    /**
     * Getter for number of doors
     * @return
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Getter for engine power
     * @return
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Getter for current speed of car
     * @return
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Takes current speed and sees that it does not overstep enginePower
     * @param currentSpeed
     */
    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed >= enginePower) {
            this.currentSpeed = enginePower;
        } else if (currentSpeed <= 0) {
            this.currentSpeed = 0;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }

    /**
     * Getter for color of car
     * @return
     */
    public Color getColor() {
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
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Speed of car when turned off
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Dir getCurDir() {
        return curDir;
    }

    public void setCurDir(Dir curDir) {
        this.curDir = curDir;
    }

    public abstract double speedFactor();

    /**
     * Increasing currentSpeed variable
     * @param amount
     */
    public void incrementSpeed(double amount) {
        double speed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        if (speed > getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }

    /**
     * Decreasing currentSpeed variable
     * @param amount
     */
    public void decrementSpeed(double amount) {
        double speed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (speed < getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }

    /**
     * Increases the speed of the car and checks if amount is outside the parameter 0 to 1
     * @param amount
     */
    public void gas(double amount) {
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
    public void brake(double amount) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Parameter must be in intervall[0,1]");
        }
    }

    /**
     * Moving position of the car on the x and y axis
     */
    @Override
    public void move() {
        if (curDir == Dir.RIGHT) {
            x += currentSpeed;
        } else if (curDir == Dir.LEFT) {
            x -= currentSpeed;
        } else if (curDir == Dir.UP) {
            y += currentSpeed;
        } else if (curDir == Dir.DOWN) {
            y -= currentSpeed;
        }
    }

    /**
     * Turning car left depending of current orientation
     */
    @Override
    public void turnLeft() {
        if (curDir == Dir.RIGHT) {
            curDir = Dir.UP;
        } else if (curDir == Dir.LEFT) {
            curDir = Dir.DOWN;
        } else if (curDir == Dir.UP) {
            curDir = Dir.LEFT;
        } else if (curDir == Dir.DOWN) {
            curDir = Dir.RIGHT;
        }
    }

    /**
     * Turning car right depending of current orientation
     */
    @Override
    public void turnRight() {
        if (curDir == Dir.RIGHT) {
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
