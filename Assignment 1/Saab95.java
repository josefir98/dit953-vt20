import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name

    /**
     * Setting the color of Saab95 using the superclass in the car.java file
     * @param color
     */
    public Saab95(Color color) {
        super("Saab95", 2, color, 125);
    }

    /**
     * Getter for number of doors
     * @return
     */
    public int getNrDoors(){
        return nrDoors;
    }
    /**
     * Getter for engine power
     * @return
     */
    public double getEnginePower(){
        return enginePower;
    }
    /**
     * Getter for the current speed of the car
     * @return
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    /**
     * Getter for the color of the car
     * @return
     */
    public Color getColor(){
        return color;
    }
    /**
     * Setter for the color of the car
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
     * Boolean for Turbo ON
     */
    public void setTurboOn(){
	    turboOn = true;
    }
    /**
     * Boolean for Turbo OFF
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * How fast the car can accelerate
     * Will accelerate faster if turboOn is set to True
     * @return
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
    /**
     * Increasing currentSpeed variable using getCurrentSpeed, speedFactor and enginePower
     * @param amount
     */
    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    /**
     * Decreasing currentSpeed variable using getCurrentSpeed, speedFactor and enginePower
     * @param amount
     */
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Increases the speed of the car and checks if amount is outside the parameter 0 to 1
     * @param amount
     */
    public void gas(double amount){
        double speed = getCurrentSpeed() + speedFactor() * amount;
        if (speed > getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }
    /**
     * Breaks the car and checks if amount is outside the parameter 0 to 1
     * @param amount
     */
    public void brake(double amount){
        double speed = getCurrentSpeed() - speedFactor() * amount;
        if (speed < getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }
}
