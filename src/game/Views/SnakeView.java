package game.Views;

import game.Models.Snake;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SnakeView {
    public static void draw(Graphics2D g2, float horShiftPx, float vertShiftPx, float cellSizePx, float GAP, Snake snake) {
        g2.setColor(snake.getColor());
        for (Rectangle2D.Float segment : snake.getArrSnake()) {
            float xPx = horShiftPx + segment.x * cellSizePx;
            float yPx = vertShiftPx + segment.y * cellSizePx;
            g2.fill(new Rectangle2D.Float(xPx, yPx, cellSizePx - GAP, cellSizePx - GAP));
        }
    }
}
