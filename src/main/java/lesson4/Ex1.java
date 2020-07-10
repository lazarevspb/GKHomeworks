package lesson4;

/*
*   Крестики-нолики в процедурном стиле
* 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
* 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
* 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
* Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
*/

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

        while (!checkWin() && overflowMap()) {
            humanTurn();
            printMap();
            aiTurn();
            printMap();
        }
    }

    public static boolean overflowMap() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (square[i][j] == DOT_EMPTY) {
                    count++;
                }
            }
        }
        if (count > 0) {
            return true;
        } else {
            System.out.println("Все поля заполнены - НИЧЬЯ");
            return false;
        }
    }

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
        return (x >= 0) || (x <= SIZE) || (y >= 0) || (y <= SIZE);
    }

    public static void humanTurn() {

        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y: ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while ((!validation(x, y)) || (!isEmpty(x, y)));
        square[x][y] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = aiTurnRandom.nextInt(SIZE);
            y = aiTurnRandom.nextInt(SIZE);
        } while ((!validation(x, y)) || (!isEmpty(x, y)));
        square[x][y] = DOT_O;
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));

    }

    public static boolean isEmpty(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            if (square[x][y] == '*') {
                return true;
            }
        }
        return false;
    }

    public static boolean checkWin() {
        int pointX = 0;
        int pointO = 0;
        for (int m = 0; m < SIZE; m++) {                            //правая диагональ
            for (int n = SIZE - m - 2; n >= 0; n--, m++) {
                if (square[m][n] == DOT_X || square[m][n] == DOT_O) {
                    if (square[m][n] == DOT_X) {
                        pointX++;
                        pointO = 0;
                    } else {
                        pointO++;
                        pointX = 0;
                    }
                } else if (square[m][n] == DOT_EMPTY) {
                    pointX = 0;
                    pointO = 0;
                }
            }
            if (pointX >= WIN_POINT) {
                System.out.println("Игра закончена.\nКрестики победили!");
                return true;
            } else if (pointO >= WIN_POINT) {
                System.out.println("Игра закончена.\nНолики победили!");
                return true;
            }
        }
        pointX = 0;
        pointO = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = SIZE - i - 1; j >= 0; j--, i++) {
                if (square[i][j] == DOT_X || square[i][j] == DOT_O) {
                    if (square[i][j] == DOT_X) {
                        pointX++;
                        pointO = 0;
                    } else {
                        pointO++;
                        pointX = 0;
                    }
                } else if (square[i][j] == DOT_EMPTY) {
                    pointX = 0;
                    pointO = 0;
                }
                if (pointX >= WIN_POINT) {
                    System.out.println("Игра закончена.\nКрестики победили!");
                    return true;
                } else if (pointO >= WIN_POINT) {
                    System.out.println("Игра закончена.\nНолики победили!");
                    return true;
                }
            }
        }
        pointX = 0;
        pointO = 0;

        for (int k = 1; k < SIZE; k++) {
            for (int l = SIZE - k; l > 0; l--, k++) {
                if (square[k][l] == DOT_X || square[k][l] == DOT_O) {
                    if (square[k][l] == DOT_X) {
                        pointX++;
                        pointO = 0;
                    } else {
                        pointO++;
                        pointX = 0;
                    }
                } else if (square[k][l] == DOT_EMPTY) {
                    pointX = 0;
                    pointO = 0;
                }
            }
            if (pointX >= WIN_POINT) {
                System.out.println("Игра закончена.\nКрестики победили!");
                return true;
            } else if (pointO >= WIN_POINT) {
                System.out.println("Игра закончена.\nНолики победили!");
                return true;
            }
        }
        pointX = 0;
        pointO = 0;

        for (int i = 1; i < SIZE; i++) {                            //левая диагональ
            for (int j = 0; j < SIZE - 1; j++, i++) {
                if (square[i][j] == DOT_X || square[i][j] == DOT_O) {
                    if (square[i][j] == DOT_X) {
                        pointX++;
                        pointO = 0;
                    } else {
                        pointO++;
                        pointX = 0;
                    }
                } else if (square[i][j] == DOT_EMPTY) {
                    pointX = 0;
                    pointO = 0;
                }
            }
            if (pointX >= WIN_POINT) {
                System.out.println("Игра закончена.\nКрестики победили!");
                return true;
            } else if (pointO >= WIN_POINT) {
                System.out.println("Игра закончена.\nНолики победили!");
                return true;
            }
        }
        pointX = 0;
        pointO = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++, i++) {
                if (square[i][j] == DOT_X || square[i][j] == DOT_O) {
                    if (square[i][j] == DOT_X) {
                        pointX++;
                        pointO = 0;
                    } else {
                        pointO++;
                        pointX = 0;
                    }

                } else if (square[i][j] == DOT_EMPTY) {
                    pointX = 0;
                    pointO = 0;
                }
            }
            if (pointX >= WIN_POINT) {
                System.out.println("Игра закончена.\nКрестики победили!");
                return true;
            } else if (pointO >= WIN_POINT) {
                System.out.println("Игра закончена.\nНолики победили!");
                return true;
            }
        }
        pointX = 0;
        pointO = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++, i++) {
                if (square[i][j] == DOT_X || square[i][j] == DOT_O) {
                    if (square[i][j] == DOT_X) {
                        pointX++;
                        pointO = 0;
                    } else {
                        pointO++;
                        pointX = 0;
                    }
                } else if (square[i][j] == DOT_EMPTY) {
                    pointX = 0;
                    pointO = 0;
                }
            }
            if (pointX >= WIN_POINT) {
                System.out.println("Игра закончена.\nКрестики победили!");
                return true;
            } else if (pointO >= WIN_POINT) {
                System.out.println("Игра закончена.\nНолики победили!");
                return true;
            }
        }
        pointX = 0;
        pointO = 0;

        for (int i = 0; i < SIZE; i++) {                             //строки
            for (int j = 0; j < SIZE; j++) {
                if (square[i][j] == DOT_X || square[i][j] == DOT_O) {
                    if (square[i][j] == DOT_X) {
                        pointX++;
                        pointO = 0;
                    } else {
                        pointO++;
                        pointX = 0;
                    }
                    if (pointX >= WIN_POINT) {
                        System.out.println("Игра закончена.\nКрестики победили!");
                        return true;
                    } else if (pointO >= WIN_POINT) {
                        System.out.println("Игра закончена.\nНолики победили!");
                        return true;
                    }
                } else if (square[i][j] == DOT_EMPTY) {
                    pointX = 0;
                    pointO = 0;
                }
            }
            pointX = 0;
            pointO = 0;
        }
        pointX = 0;
        pointO = 0;

        for (int i = 0; i < SIZE; i++) {                            // стольбцы
            for (int j = 0; j < SIZE; j++) {

                if (square[j][i] == DOT_X || square[j][i] == DOT_O) {
                    if (square[j][i] == DOT_X) {
                        pointX++;
                        pointO = 0;
                    } else {
                        pointO++;
                        pointX = 0;
                    }
                    if (pointX >= WIN_POINT) {
                        System.out.println("Игра закончена.\nКрестики победили!");
                        return true;
                    } else if (pointO >= WIN_POINT) {
                        System.out.println("Игра закончена.\nНолики победили!");
                        return true;
                    }
                } else if (square[i][j] == DOT_EMPTY) {
                    pointX = 0;
                    pointO = 0;
                }
            }
            pointX = 0;
            pointO = 0;
        }
        return false;
    }

}