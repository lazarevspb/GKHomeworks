package lesson2;

/*
* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
* С помощью цикла и условия заменить 0 на 1, 1 на 0;
* */

public class Ex1 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] == 1) {
                arrInt[i] = 0;
            } else {
                arrInt[i] = 1;
            }
        }
    }
}
