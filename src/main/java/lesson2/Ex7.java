package lesson2;

/*
 * 7. **** Написать метод, которому на вход подается одномерный массив и число n
 * (может быть положительным, или отрицательным), при этом метод должен сместить
 * все элементымассива на n позиций (Циклично). Для усложнения задачи нельзя
 * пользоваться вспомогательными массивами.
 * */

import java.util.Arrays;//delete

public class Ex7 {


    public static void main(String[] args) {
        int[] arrInt = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        int shiftQuantity = 10;

        arrayShift(arrInt, shiftQuantity);
        System.out.println(Arrays.toString(arrInt));
    }

    private static void arrayShift(int[] arrInt, int quantity) {
        int tmp;
        if (quantity > -1) {
            for (int i = quantity; i > 0; i--) {
                tmp = arrInt[arrInt.length - 1];
                for (int j = arrInt.length - 1; j > 0; j--) {
                    arrInt[j] = arrInt[j - 1];
                }
                arrInt[0] = tmp;
            }


        }
        if (quantity < 0) {
            tmp = arrInt[0];
            for (int j = 0; j < arrInt.length - 1; j++) {
                arrInt[j] = arrInt[j + 1];
            }
            arrInt[arrInt.length - 1] = tmp;
        }
    }


}



