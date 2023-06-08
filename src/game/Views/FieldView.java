package game.Views;

import game.Models.Field;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class FieldView {
    public static void draw(Graphics2D g2, float horShiftPx, float vertShiftPx, float cellSizePx, float GAP, Field field) {
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                float xPx = horShiftPx + x * cellSizePx;
                float yPx = vertShiftPx + y * cellSizePx;
                g2.setColor(field.getColor());
                g2.fill(new Rectangle2D.Float(xPx, yPx, cellSizePx - GAP, cellSizePx - GAP));
            }
        }
    }

}