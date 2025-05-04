import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
    private final int gridSize = 10;
    private final int cellSize = 50;

    private Cat cat;
    private Dog dog;
    private List<Point> steaks = new ArrayList<>();
    private final Random random = new Random();

    public GamePanel(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
        setPreferredSize(new Dimension(gridSize * cellSize, gridSize * cellSize));
        spawnSteaks();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                g.setColor(Color.BLACK);
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);

                boolean isSteak = false;
                for (Point p : steaks) {
                    if (p.x == x && p.y == y) {
                        isSteak = true;
                        break;
                    }
                }
                if (cat.getX() == x && cat.getY() == y) {
                    g.setColor(Color.YELLOW);
                } else if (dog.getX() == x && dog.getY() == y) {
                    g.setColor(Color.BLUE);
                } else if (isSteak) {
                    g.setColor(Color.RED);
                } else {
                    continue;
                }
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }

        // Draw overlay (score, barks)
        g.setColor(Color.WHITE);
        g.drawString("Score: " + dog.getScore(), 10, 15);
        g.drawString("Barks Left: " + dog.getBarksLeft(), 10, 30);
    }

    public void spawnSteaks() {
        steaks.clear();
        while (steaks.size() < 3) {
            int x = random.nextInt(gridSize);
            int y = random.nextInt(gridSize);
            boolean occupied = (x == cat.getX() && y == cat.getY()) || (x == dog.getX() && y == dog.getY());
            boolean duplicate = steaks.stream().anyMatch(p -> p.x == x && p.y == y);
            if (!occupied && !duplicate) {
                steaks.add(new Point(x, y));
            }
        }
    }

    public List<Point> getSteaks() {
        return steaks;
    }
}