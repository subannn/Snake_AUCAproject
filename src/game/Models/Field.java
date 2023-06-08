package game.Models;

import java.awt.*;

public class Field extends Component {
    private final int width;
    private final int height;
    private final Color color;
    private boolean isGameStarted;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.isGameStarted = false;
        color = Color.DARK_GRAY;
    }
    public void setPause(boolean f) {
        isGameStarted = f;
    }
    public boolean isGameStarted() {
        return isGameStarted;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Color getColor() {
        return color;
    }

}