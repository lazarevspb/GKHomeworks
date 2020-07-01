package lesson2;
/*
 * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
 * */

public class Ex5 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{1, 13, 5, 3, 2, 11, 4, 5, -2, 2, 4, 8, 9, 12, -1};
        int max, min;

        max = arrInt[0];
        for (int i = 0; i < arrInt.length - 1; i++) {
            if (max < arrInt[i + 1]) {
                max = arrInt[i + 1];
            }
        }

        min = arrInt[0];
        for (int i = 0; i < arrInt.length - 1; i++) {
            if (min > arrInt[i + 1]) {
                min = arrInt[i + 1];
            }
        }
    }
}
