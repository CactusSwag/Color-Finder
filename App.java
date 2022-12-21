import java.awt.Color;


public class App {
    public static void main(String[] args) throws Exception {
        // Initializes Hacker into App
        Hacker hacker = new Hacker();
        // Runs method screenShot from Hacker
        hacker.screenShot();
        // Find this color
        Color searchColor = new Color(0, 255, 255);
        // Runs findAndClick from hacker
        hacker.findAndClick(searchColor);
    }
}