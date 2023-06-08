package game.Controllers;

import game.Models.Snake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PauseController implements KeyListener {
    Snake snake;
    @Override
    public void keyTyped(KeyEvent e) {}
    public PauseController(Snake snake) {this.snake = snake;}

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE) {
            if(snake.isPaused()) {
                snake.setPaused(false);
            }
            else if(!snake.isPaused()) {
                snake.setPaused(true);
            }
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {}
}