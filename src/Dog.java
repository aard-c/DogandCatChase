public class Dog extends Animal {
    private int barksLeft = 3;
    private int score = 0;

    public Dog(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barked!");
    }

    public int getBarksLeft() {
        return barksLeft;
    }

    public void useBark() {
        barksLeft--;
    }

    public void resetBarks() {
        barksLeft = 3;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }
}