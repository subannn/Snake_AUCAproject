package game.Views;

import game.Models.Apple;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class AppleView {
    public static void draw(Graphics2D g2, float horShiftPx, float vertShiftPx, float cellSizePx, float GAP, Apple apple) {
        g2.setColor(apple.getColor());
        float appleXPx = horShiftPx + apple.getX() * cellSizePx;
        float appleYPx = vertShiftPx + apple.getY() * cellSizePx;
        g2.fill(new Rectangle2D.Float(appleXPx, appleYPx, cellSizePx - GAP, cellSizePx - GAP));
    }
}