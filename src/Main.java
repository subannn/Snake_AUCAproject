import game.Controllers.PauseController;
import game.Models.Apple;
import game.Models.Field;
import game.Models.Snake;
import game.Controllers.KeyController;

import static game.Controllers.BackToMenuController.backToMenuButton;
import static game.Controllers.MenuButtonContoller.startMenuButton;
import game.Views.AppleView;
import game.Views.FieldView;
import game.Views.PauseView;
import game.Views.SnakeView;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    public static final int INIT_WIDTH_PX = 700;
    public static final int INIT_HEIGHT_PX = 500;
    public static final int FIELD_WIDTH = 20;
    public static final int FIELD_HEIGHT = 20;
    private JLabel scoreCount;
    private Field field;
    private Snake snake;
    private Apple apple;
    private int score = 0;
    private Canvas canvas;
    class Canvas extends JPanel {
        public static final float GAP = 1.0f;

        public Canvas() {
            setBackground(Color.BLACK);
            setFocusable(true);

            addKeyListener(new KeyController(snake));
            addKeyListener(new PauseController(snake));

        }
        Graphics2D g2;
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.GRAY);
            g2 = (Graphics2D) g;
            float cellWidthPx = getWidth() / (float) field.getWidth();
            float cellHeightPx = getHeight() / (float) field.getHeight();
            float cellSizePx = Math.min(cellWidthPx, cellHeightPx);
            float fieldWidthPx = field.getWidth() * cellSizePx;
            float fieldHeightPx = field.getHeight() * cellSizePx;
            float hPx = (getWidth() - fieldWidthPx) * 0.5f;
            float vPx = (getHeight() - fieldHeightPx) * 0.5f;

            FieldView.draw(g2, hPx, vPx, cellSizePx, GAP, field);
            SnakeView.draw(g2, hPx, vPx, cellSizePx, GAP, snake);
            AppleView.draw(g2, hPx, vPx, cellSizePx, GAP, apple);
            PauseView.draw(g2, snake.isPaused(), INIT_WIDTH_PX, INIT_HEIGHT_PX);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {new Main().setVisible(true);});
    }

    public Main() {
        setTitle("Snake");
        setSize(INIT_WIDTH_PX, INIT_HEIGHT_PX);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
        setResizable(false);

        field = new Field(FIELD_WIDTH, FIELD_HEIGHT);
        snake = new Snake(0, 0);
        apple = new Apple(field);
        canvas = new Canvas();
        add(canvas, BorderLayout.CENTER);

        Timer timer = new Timer(160, e -> {
            snake.move();
            if(!field.isGameStarted()) {
                startMenuButton(score, field, scoreCount, snake, apple);
            }
            else if(snake.isDead(field)) {
                backToMenuButton(score, field, scoreCount, snake, apple);
                score = 0;
            }
            else if(snake.collidesWithApple(apple)){
                snake.grow();
                apple.respawn();
                score++;
                scoreCount.setText("Press ESC to pause the game                    Score:" + score);
            }
            repaint();
        });
        timer.start();

        score = 0;
        scoreCount = new JLabel("Press ESC to pause the game                    Score:" + score);
        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(Color.GRAY.brighter());
        scorePanel.setFocusable(false);
        scorePanel.setLayout(new BorderLayout());
        scoreCount.setFont(scoreCount.getFont().deriveFont(20f));
        scorePanel.add(scoreCount, BorderLayout.CENTER);
        this.add(scorePanel, BorderLayout.NORTH);
    }
}