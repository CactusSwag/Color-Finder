import java.util.ArrayList;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.io.IOException;
import java.awt.event.InputEvent;

public class Hacker {
    ArrayList<ColorCoord> colorArray;

    public Hacker() {
        colorArray = new ArrayList<ColorCoord>();
    }

    public void screenShot() throws IOException {
        
        try {
            // Create Robot screenCap
            Robot screenCap = new Robot();
    
            // Get screen size
            Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    
            // Get screenshot from screen size
            BufferedImage tmpImg = screenCap.createScreenCapture(screenSize);
            colorCoords(tmpImg);
        }

        catch(Exception e) {
            System.out.print(e);
        }
    }

    public void colorCoords(BufferedImage image) throws IllegalArgumentException, IOException, FileNotFoundException {
        try {
            int height = image.getHeight();
            int width = image.getWidth();
            ColorCoord cc;

            for(int i=0; i < width; i++) {
                for(int j=0; j < height; j++) {
                    Color color = new Color(image.getRGB(i, j));
                    cc = new ColorCoord(color, i, j);
                    colorArray.add(cc);
                }
            }
        }
        
        catch(Exception e) {
            System.out.print(e);
        
        }
    }
    
    // Finds color that matches RGB, clicks coordinates
    public void findAndClick(Color findColor){
        try {
            Robot mouseMover = new Robot();
            for (ColorCoord cc : colorArray) {
                if (findColor.getRGB() == cc.getColor().getRGB()) {
                    mouseMover.mouseMove(cc.getX(), cc.getY());
                    mouseMover.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    mouseMover.delay(100);
                    mouseMover.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    mouseMover.delay(100);
                }
            }
        }
        catch(Exception e) {
            System.out.println("Fail 3");
        }
    }
}
