import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GameWindow extends JFrame implements KeyListener {
    private Cat cat;
    private Dog dog;
    private GamePanel panel;
    private final int gridSize = 10;
    private int turnCount = 0;

    public GameWindow() {
        cat = new Cat("Cat", 0, 0);
        dog = new Dog("Dog", 9, 9);
        panel = new GamePanel(cat, dog);

        add(panel);
        addKeyListener(this);
        setTitle("Cat and Dog Chase Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void moveDog(int dx, int dy) {
        int newX = Math.max(0, Math.min(gridSize - 1, dog.getX() + dx));
        int newY = Math.max(0, Math.min(gridSize - 1, dog.getY() + dy));
        dog.setPosition(newX, newY);

        checkSteakCollection();
        turnCount++;
        if (turnCount % 2 == 0) {
            cat.chase(dog);
        }
        panel.repaint();

        if (dog.getX() == cat.getX() && dog.getY() == cat.getY()) {
            JOptionPane.showMessageDialog(this, "Cat caught the dog! Final Score: " + dog.getScore());
            System.exit(0);
        }
    }

    private void checkSteakCollection() {
        panel.getSteaks().removeIf(p -> p.x == dog.getX() && p.y == dog.getY());

        if (panel.getSteaks().size() <= 1) {
            dog.increaseScore();
            dog.resetBarks();
            panel.spawnSteaks();
        }
    }

    private void pushCatAway() {
        int dx = cat.getX() - dog.getX();
        int dy = cat.getY() - dog.getY();

        int pushX = (dx == 0) ? 0 : (dx > 0 ? 1 : -1);
        int pushY = (dy == 0) ? 0 : (dy > 0 ? 1 : -1);

        int newX = Math.max(0, Math.min(gridSize - 1, cat.getX() + (pushX * 2)));
        int newY = Math.max(0, Math.min(gridSize - 1, cat.getY() + (pushY * 2)));

        cat.setPosition(newX, newY);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> moveDog(0, -1);
            case KeyEvent.VK_S -> moveDog(0, 1);
            case KeyEvent.VK_A -> moveDog(-1, 0);
            case KeyEvent.VK_D -> moveDog(1, 0);
            case KeyEvent.VK_SPACE -> {
                if (dog.getBarksLeft() > 0) {
                    dog.useBark();
                    pushCatAway();
                    panel.repaint();
                }
            }
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}