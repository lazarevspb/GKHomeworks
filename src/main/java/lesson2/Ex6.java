package lesson2;

/*
 * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
 *  метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
 * части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
 *  checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
 * */

public class Ex6 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{0, 1, 1, 0, 2, 1};
        checkBalance(arrInt);
    }

    static boolean checkBalance(int[] arrInt) {
        int leftSum = 0;
        for (int i = 0; i < arrInt.length; i++) {
            int rightSum = 0;
            leftSum += arrInt[i];
            for (int j = i + 1; j < arrInt.length; j++) {
                rightSum += arrInt[j];
            }
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }
}


