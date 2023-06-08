package game.Controllers;

import game.Models.Snake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {
    Snake snake;
    @Override
    public void keyTyped(KeyEvent e) {}
    public KeyController(Snake snake) {
        this.snake = snake;
    }
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP && snake.getDirection() != 2 && !snake.isPaused()) {
            snake.setDirection(1);
        }
        else if(keyCode == KeyEvent.VK_DOWN && snake.getDirection() != 1 && !snake.isPaused()) {
            snake.setDirection(2);
        }
        else if(keyCode == KeyEvent.VK_LEFT && snake.getDirection() != 4 && !snake.isPaused()) {
            snake.setDirection(3);
        }
        else if(keyCode == KeyEvent.VK_RIGHT && snake.getDirection() != 3 && !snake.isPaused()) {
            snake.setDirection(4);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
}