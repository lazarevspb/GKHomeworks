package lesson6;

public class Dog extends Animal {
    String name;
    double heightJumpLimit;
    int runLengthLimit;

    public Dog(String name, double heightJumpLimit, int runLengthLimit) {
        this.name = name;
        this.heightJumpLimit = heightJumpLimit;
        this.runLengthLimit = runLengthLimit;
    }

    public Dog(String name) {
        this.name = name;
        this.heightJumpLimit = Animal.rnd(0, 1);
        this.runLengthLimit = Animal.rnd(500, 2000);
    }

    @Override
    public void run(int length) {
        if (length <= runLengthLimit && length > 0) {
            System.out.printf("%s: я бегу %d метров\n", name, length);
        } else {
            System.out.printf("%s: не могу пробежать %d  метров. Максимальная длинна пробежки: %d метров\n", name, length, runLengthLimit);

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

    public void swimming(int length) {
        if (length <= runLengthLimit && length > 0) {
            System.out.printf("%s: я плыву %d метров\n", name, length);
        } else {
            System.out.printf("%s: не могу плыть %d метров", name, length);

        }
    }
}
