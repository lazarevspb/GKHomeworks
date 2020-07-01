package lesson2;

/*
* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
* и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
* */

public class Ex4 {
    public static void main(String[] args) {
        int[][] arrInt = new int[7][7];

        for (int i = 0; i <= arrInt[i].length - 1; i++) {
            for (int j = i; j <= arrInt[i].length - 1; j++) {
                if (j > i) {
                    break;
                }
                arrInt[i][j] = 1;
            }
            if (i == arrInt[i].length - 1) {
                break;
            }
        }

        for (int i = arrInt[0].length - 1; i >= 0; i--) {
            for (int j = 0; j <= arrInt[j].length - 1; j++) {

                arrInt[j][i--] = 1;
                if (i < 0) {
                    break;
                }
            }
        }


    }
}
