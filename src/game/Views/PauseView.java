package game.Views;

import game.Models.Field;

import java.awt.*;

public class PauseView {
    public static void draw(Graphics2D g2, boolean isPaused, int w, int h) {
        if(isPaused) {
            Font font = new Font("Monospace", Font.BOLD, 50);
            g2.setFont(font);
            g2.setColor(Color.RED);
            g2.drawString("Paused", w / 2 - 100, h / 2 - 50);
        }
    }

}