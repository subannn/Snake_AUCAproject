package game.Models;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private final List<Rectangle2D.Float> arrSnake;
    private int direction;
    private final Color color;
    private boolean isPaused;
    public boolean isPaused() {return isPaused;}
    public void setPaused(boolean paused) {isPaused = paused;}

    public Snake(int startX, int startY) {
        arrSnake = new ArrayList<>();
        arrSnake.add(new Rectangle2D.Float(startX, startY, 1, 1));
        direction = 4;
        isPaused = false;
        this.color = Color.GREEN;
    }
    public List<Rectangle2D.Float> getArrSnake() {
        return arrSnake;
    }
    public Color getColor() {
        return color;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public int getDirection() {return this.direction;};
    public void move() {
        if(!isPaused) {
            Rectangle2D.Float head = arrSnake.get(0);
            float newX = head.x;
            float newY = head.y;
            switch (direction) {
                case 1:
                    newY--; // up
                    break;
                case 2:
                    newY++; // down
                    break;
                case 3:
                    newX--; // left
                    break;
                case 4:
                    newX++; // right
                    break;
            }
            arrSnake.add(0, new Rectangle2D.Float(newX, newY, 1, 1));
            arrSnake.remove(arrSnake.size() - 1);
        }

    }
    public boolean isDead(Field field) {
        Rectangle2D.Float head = arrSnake.get(0);
        if (head.x < 0 || head.x >= field.getWidth() || head.y < 0 || head.y >= field.getHeight()) {
            return true;
        }
        for (int i = 1; i < arrSnake.size(); i++) {
            if (head.intersects(arrSnake.get(i))) {
                return true;
            }
        }
        return false;
    }
    public void reset(int startX, int startY) {
        arrSnake.clear();
        arrSnake.add(new Rectangle2D.Float(startX, startY, 1, 1));
        direction = 4;
    }
    public boolean collidesWithApple(Apple apple) {
        Rectangle2D.Float head = this.getArrSnake().get(0);
        float appleX = apple.getX();
        float appleY = apple.getY();
        return head.getX() == appleX && head.getY() == appleY;
    }
    public void grow() {
        Rectangle2D.Float lastSegment = arrSnake.get(arrSnake.size() - 1);
        arrSnake.add(new Rectangle2D.Float(lastSegment.x, lastSegment.y, 1, 1));
    }
}
