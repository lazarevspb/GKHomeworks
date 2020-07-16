package lesson6;

public class Animal {

    public Animal() {
    }

    public void run(int length) {
        System.out.println("Животное: я бегу - " + length + " метров");
    }

    public void jump(double jump) {
        System.out.println("Животное: я прыгаю на - " + jump + " метров");
    }

    /**
     * Метод получения псевдослучайного целого числа от 0 до max (включая max);
     */
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
