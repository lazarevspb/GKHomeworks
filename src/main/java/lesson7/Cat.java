package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fulness = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (!p.decreaseFood(appetite)) {
            System.out.printf("%s: в этой тарелке не хватате еды\n", name);
            fulness = false;
        } else {
            fulness = true;
        }
    }

    public void fulnessInfo() {
        String hungryOrSatiety = this.fulness ? "сыт" : "голоден";
        System.out.printf("%s - %s\n", name, hungryOrSatiety);
    }
}
