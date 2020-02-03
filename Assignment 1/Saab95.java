import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    public Saab95(Color color) {
        super("Saab95", 2, color, 125);
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        double speed = getCurrentSpeed() + speedFactor() * amount;
        if(speed > getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }

    public void decrementSpeed(double amount){
        double speed = getCurrentSpeed() - speedFactor() * amount;
        if(speed < getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }
}
