import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    /**
     * Setting the color of Volvo240 using the superclass in the car.java file
     * @param color
     */
    public Volvo240(Color color){
        super("Volvo240", 4, color, 100);
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
     * How fast the car can accelerate
     * @return
     */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Increasing currentSpeed variable using getCurrentSpeed, speedFactor and enginePower
     * @param amount
     */
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreasing currentSpeed variable using getCurrentSpeed, speedFactor and enginePower
     * @param amount
     */
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    /**
     * Increases the speed of the car and checks if amount is outside the parameter 0 to 1
     * @param amount
     */
    public void gas(double amount){
        double speed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        if (speed > getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }
    /**
     * Breaks the car and checks if amount is outside the parameter 0 to 1
     * @param amount
     */
    public void brake(double amount){
        double speed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (speed < getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }
}
