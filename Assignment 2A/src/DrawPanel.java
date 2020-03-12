import Abstract.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    //HashMap<String, Values<BufferedImage, Point>> cars = new HashMap<>();
    //Pair<BufferedImage, Point> values = new Pair<>();
    HashMap<String, BufferedImage> images = new HashMap<>();
    HashMap<String, Point> points = new HashMap<>();

    // Just a single image, TODO: Generalize

    // To keep track of a singel cars position
    //Point volvoPoint = new Point();

    // TODO: Make this genereal for all cars
    void moveit(Vehicle car, int x, int y) {
        points.replace(car.getModelName(), new Point(x, y));
    }
/*
    public static class Values<BufferedImage, Point> {

        private final BufferedImage image;
        private final Point point;

        public Values(BufferedImage image, Point point) {
            this.image = image;
            this.point = point;
        }

        public BufferedImage getImage() {
            return image;
        }

        public Point getPoint() {
            return point;
        }
    }
*/
    // Initializes the panel and reads the images
    public DrawPanel(ArrayList<Vehicle> cars, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        for (Vehicle car : cars) {
            // Print an error message in case file is not found with a try/catch block
            try {
                this.images.put(car.getModelName(), ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/" + car.getModelName() + ".jpg")));
                this.points.put(car.getModelName(), new Point());
                //volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Volvo240.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        images.forEach((k, v) -> {
            g.drawImage(v, points.get(k).x, points.get(k).y, null); // see javadoc for more info on the parameters
        });
    }
}
