package lesson2;

/*
* Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
* */

public class Ex3 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] < 6) {
                arrInt[i] *= 6;
            }
        }
    }
}
