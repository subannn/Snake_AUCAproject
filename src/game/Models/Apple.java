package game.Models;

import java.awt.*;
import java.util.Random;

public class Apple {
    private int x;
    private int y;
    private final Color color;
    private final Field field;
    private final Random random;
    public Apple(Field field) {
        this.field = field;
        color = Color.RED;
        random = new Random();
        respawn();
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
    public void respawn() {
        x = random.nextInt(field.getWidth());
        y = random.nextInt(field.getHeight());
    }
}
