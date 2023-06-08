package game.Controllers;

import game.Models.Apple;
import game.Models.Field;
import game.Models.Snake;

import javax.swing.*;

import static game.Controllers.MenuButtonContoller.startMenuButton;

public class BackToMenuController {
    public static void backToMenuButton(int score, Field field, JLabel scoreCount, Snake snake, Apple apple) {
        int choice = JOptionPane.showOptionDialog(field,
                "You lose! Your score: " + score,
                "Game over",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Go to menu", "Cancel"},
                "Go to menu");
        if(choice == JOptionPane.YES_OPTION) {
            startMenuButton(score, field, scoreCount, snake, apple);
        }
        else
            System.exit(0);
    }
}
