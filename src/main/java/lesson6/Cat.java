package lesson6;

import java.util.Random;

public class Cat extends Animal {
    String name;
    double heightJumpLimit;
    int runLengthLimit;


    public Cat(String name, double heightJumpLimit, int runLengthLimit) {
        this.name = name;
        this.heightJumpLimit = heightJumpLimit;
        this.runLengthLimit = runLengthLimit;
    }

    public Cat(String name) {
        this.name = name;
        this.heightJumpLimit = Animal.rnd(1, 3);
        this.runLengthLimit = Animal.rnd(200, 1500);
    }

    @Override
    public void run(int length) {

        if (length <= runLengthLimit && length > 0) {
            System.out.printf("%s: я бегу %d метров\n", name, length);
        } else {
            System.out.printf("%s: не могу пробежать %d метров. Максимальная длинна пробежки: %d метров\n", name, length, runLengthLimit);
        }
    }

    @Override
    public void jump(double jump) {
        if (jump <= heightJumpLimit && jump > 0) {
            System.out.printf("%s: я прыгаю %.1f метров\n", name, jump);
        } else {
            System.out.printf("%s: не могу прыгнуть %.1f метра. Моя максимальная высота прыжка: %.1f метров\n", name, jump, heightJumpLimit);
        }
    }
}
