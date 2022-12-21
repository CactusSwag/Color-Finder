import java.awt.Color;

public class  ColorCoord {
    Color color;
    int x;
    int y;

    public ColorCoord(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Color getColor() {
        return color;
    }
}
