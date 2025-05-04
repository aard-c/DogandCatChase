public class Cat extends Animal {
    public Cat(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meowed!");
    }

    public void chase(Animal target) {
        if (x < target.x) x++;
        else if (x > target.x) x--;

        if (y < target.y) y++;
        else if (y > target.y) y--;
    }
}