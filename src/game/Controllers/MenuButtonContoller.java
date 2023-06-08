package game.Controllers;

import game.Models.Apple;
import game.Models.Field;
import game.Models.Snake;

import javax.swing.*;

public class MenuButtonContoller {
    public static void startMenuButton(int score, Field field, JLabel scoreCount, Snake snake, Apple apple) {
        int choice = JOptionPane.showOptionDialog(field,
                "Do you want to start the game?",
                "Game Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Start", "Cancel"},
                "Start");
        if(choice == JOptionPane.YES_OPTION) {
            score = 0;
            scoreCount.setText("Press ESC to pause the game                    Score:" + score);
            snake.reset(0, 0);
            apple.respawn();
            field.setPause(true);
        }
        else
            System.exit(0);
    }
}
