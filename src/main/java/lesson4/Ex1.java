package lesson4;

import java.util.Random;
import java.util.Scanner;

class Ex1 {
    public static final int SIZE = 5;
    public static final int WIN_POINT = 4;
    public static final int DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random aiTurnRandom = new Random();
    static char[][] square = new char[SIZE][SIZE];

    public static void main(String[] args) {

        initMap();
        printMap();

        while (!checkWin()) {

            humanTurn();
            printMap();
            aiTurn();
            printMap();
        }

    }

    private static void columns() {  //удалить
        for (int i = 0; i < SIZE; i++) {
//            printMap();
            for (int j = 0; j < SIZE; j++) {
                square[j][i] = DOT_X;
                printMap();

            }
        }
    }

    private static boolean checkWin() {
        int countDotX = 0;
        int countDotO = 0;
        int changeLine = 0;
        char prevItem = '*';
        for (int i = SIZE - 1; i > 0; i--) {    //Правая диагональ
            for (int j = 0; j < SIZE; j++, i--) {
                if (square[j][i] == DOT_X || square[j][i] == DOT_O) {
                    if (square[j][i] == DOT_O) {
                        if (square[j][i] == DOT_O && countDotO < 1) {
                            countDotO++;
                        }
                        if (square[j][i] == DOT_O && countDotO >= 1 && prevItem == DOT_O) {
                            countDotO++;
                            if (countDotO >= WIN_POINT) {
                                System.out.println("Нолики виграли");
                                return true;
                            }
                        }
                        if (square[j][i] == DOT_O && countDotO >= 1 && prevItem == DOT_X) {
                            countDotO = 0;
                        }
                    }

                    if (square[j][i] == DOT_X) {
                        if (square[j][i] == DOT_X && countDotX < 1) {
                            countDotX++;
                        }
                        if (square[j][i] == DOT_X && countDotX >= 1 && prevItem == DOT_X) {
                            countDotX++;
                            if (countDotX >= WIN_POINT) {
                                System.out.println("Крестики виграли 1");
                                return true;
                            }
                        }
                        if (square[j][i] == DOT_X && countDotX >= 1 && prevItem == DOT_O) {
                            countDotX = 0;
                        }
                    }
                    prevItem = square[j][i];
                }
                if (i < 0) {
                    break;
                }
            }
             countDotX = 0;
             countDotO = 0;
            prevItem = '*';
        }

        for (int i = 0; i < SIZE; i++) {  //Левая диагональ
            for (int j = i; j < SIZE; j++) {
                if (j > i) {
                    break;
                }
                if (square[j][i] == DOT_X || square[j][i] == DOT_O) {
                    if (square[j][i] == DOT_O) {
                        if (square[j][i] == DOT_O && countDotO < 1) {
                            countDotO++;
                        }
                        if (square[j][i] == DOT_O && countDotO >= 1 && prevItem == DOT_O) {
                            countDotO++;
                            if (countDotO >= WIN_POINT) {
                                System.out.println("Нолики виграли");
                                return true;
                            }
                        }
                        if (square[j][i] == DOT_O && countDotO >= 1 && prevItem == DOT_X) {
                            countDotO = 0;
                        }
                    }

                    if (square[j][i] == DOT_X) {
                        if (square[j][i] == DOT_X && countDotX < 1) {
                            countDotX++;
                        }
                        if (square[j][i] == DOT_X && countDotX >= 1 && prevItem == DOT_X) {
                            countDotX++;
                            if (countDotX >= WIN_POINT) {
                                System.out.println("Крестики виграли 2");
                                return true;
                            }
                        }
                        if (square[j][i] == DOT_X && countDotX >= 1 && prevItem == DOT_O) {
                            countDotX = 0;
                        }
                    }
                    prevItem = square[j][i];
                }
            }
        }
        countDotX = 0;
        countDotO = 0;
        prevItem = '*';

        for (int i = 0; i < SIZE; i++) {  //строки
            for (int j = 0; j < SIZE; j++) {
                if (square[i][j] == DOT_X || square[j][i] == DOT_O) {
                    if (square[i][j] == DOT_O) {
                        if (prevItem == DOT_X | prevItem == DOT_EMPTY) {
                            countDotO = 0;
                        }
                        if (countDotO == 0) {
                            countDotO++;
                        }
                        if (prevItem == DOT_X && changeLine == i) {
                            countDotO++;
                            if (countDotO >= WIN_POINT) {
                                System.out.println("Нолики виграли");
                                return true;
                            }
                        }
                    }
                    if (square[i][j] == DOT_X) {

                            if (prevItem == DOT_O | prevItem == DOT_EMPTY) {
                                countDotX = 0;
                            }
                        if (countDotX == 0) {
                            countDotX++;
                        }
                        if (prevItem == DOT_X && changeLine == i) {
                            countDotX++;
                            if (countDotX >= WIN_POINT) {
                                System.out.println("Крестики виграли 3 ");
                                return true;
                            }
                        }
                    }
                    changeLine = i;
                    prevItem = square[i][j];
                } else {
                    prevItem = square[i][j];
                    changeLine = i;
                }
            }
            countDotX = 0;
            countDotO = 0;
        }

        for (int i = 0; i < SIZE; i++) { // стольбцы
            for (int j = 0; j < SIZE; j++) {
                if (square[j][i] == DOT_X || square[j][i] == DOT_O) {
                    if (square[j][i] == DOT_O) {
                        if (prevItem == DOT_X | prevItem == DOT_EMPTY) {
                            countDotO = 0;
                        }
                        if (countDotO == 0) {
                            countDotO++;
                        }
                        if (prevItem == DOT_X && changeLine == i) {
                            countDotO++;
                            if (countDotO >= WIN_POINT) {
                                System.out.println("Нолики виграли");
                                return true;
                            }
                        }
                    }
                    if (square[j][i] == DOT_X) {
                        if (prevItem == DOT_O | prevItem == DOT_EMPTY) {
                            countDotX = 0;
                        }
                        if (countDotX == 0) {
                            countDotX++;
                        }
                        if (prevItem == DOT_X && changeLine == i) {
                            countDotX++;
                            if (countDotX >= WIN_POINT) {
                                System.out.println("Крестики виграли 4");
                                return true;
                            }
                        }
                    }
                    changeLine = i;
                    prevItem = square[j][i];
                } else {
                    prevItem = square[j][i];
                    changeLine = i;
                }
            }
        }

//        if (countDotX >= WIN_POINT) {
//            System.out.println("Крестики вин: " + countDotX);
//        }
//        if (countDotO >= WIN_POINT) {
//            System.out.println("Нолики вин: " + countDotO);
//        }
        return false;
    }

    private static void slashLeft() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = i; j < SIZE; j++) {
                if (j > i) {
                    break;
                }
                square[i][j] = DOT_X;
            }
        }

    }

    private static void slashRight() {
        for (int i = SIZE - 1; i > 0; i--) {
            for (int j = 0; j < SIZE; j++, i--) {
                if (i < 0) {
                    break;
                }
                square[j][i] = DOT_X;

            }
        }
    }

    private static void slashRightPlus() {
        for (int i = SIZE - 1; i > 0; i--) {
            for (int j = 1; j < SIZE; j++) {

                square[j][i--] = DOT_X;
                if (i < 0) {
                    break;
                }
            }
        }
    }

    private static void slashRightMinus() {
        for (int i = SIZE - 2; i > 0; i--) {
            for (int j = 1; j < SIZE; j++) {

                square[j][i--] = DOT_X;
                if (i < 0) {
                    break;
                }
            }
        }
    }

//    private static void isWIn() {
//        int pointX = 0;
//        int pointO = 0;
//        for (int i = 0; i < SIZE; i++) {
//
//            for (int j = 0; j < SIZE; j++) {
//                if (square[i][j] == DOT_O) {
//                    pointO++;
//                    if (pointO >= 3) {
//                        System.out.println("Point O");
//                    }
//
//                }
//                if (square[i][j] == DOT_X) {
//                    pointX++;
//                    if (pointX >= 3) {
//                        System.out.println("Point X");
//                    }
//
//                }
//            }
//
//        }
//
//    }

    public static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                square[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.println();
        for (int k = 0; k < SIZE + 1; k++) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean validation(int x, int y) {
        if ((x >= 0) || (x <= SIZE) || (y >= 0) || (y <= SIZE)) {
//        if(x == 1){
            return true;
        }

        return false;
    }

    public static void humanTurn() {
        int x, y;
//        do {
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;
//        } while ((!validation(x, y)) || (!isEmpty(x, y)));
        square[x][y] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = aiTurnRandom.nextInt(SIZE);
            y = aiTurnRandom.nextInt(SIZE);
        } while ((!validation(x, y)) || (!isEmpty(x, y)));
        square[x][y] = DOT_O;
    }

    public static boolean isEmpty(int x, int y) {
        if (x >= 0 && x < SIZE || y >= 0 && y < SIZE) {
            if (square[x][y] == '*') {
                return true;
            }
        }


        return false;
    }


}