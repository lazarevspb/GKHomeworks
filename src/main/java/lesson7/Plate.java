package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if ((food - n) < 0) {
            return false;
        } else {
            food = food - n;
            return true;
        }
    }

    public void refill(int n) {
        food += n;
    }

    public void info() {
        System.out.println("Тарелка: " + food);
    }
    
}
