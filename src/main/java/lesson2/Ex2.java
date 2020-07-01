package lesson2;

/*
* Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
* */

public class Ex2 {
    public static void main(String[] args) {
        int[] arrInt = new int[8];
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] =+ 3 * i;
        }
    }
}
