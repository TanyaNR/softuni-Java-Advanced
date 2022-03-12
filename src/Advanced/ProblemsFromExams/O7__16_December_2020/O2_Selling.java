package Advanced.ProblemsFromExams.O7__16_December_2020;

import java.util.Scanner;

public class O2_Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int rowCooker = 0;
        int colCooker = 0;
        int firstRowPillar = 0;
        int firstColPillar = 0;
        int allMoney = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'S') {
                    rowCooker = row;
                    colCooker = col;
                }
                if (matrix[row][col] == 'O') {
                    firstRowPillar = row;
                    firstColPillar = col;
                }
            }
        }
        while (true) {
            String command = scanner.nextLine();
            matrix[rowCooker][colCooker] = '-';
            switch (command) {
                case "up":
                    rowCooker--;
                    break;
                case "down":
                    rowCooker++;
                    break;
                case "left":
                    colCooker--;
                    break;
                case "right":
                    colCooker++;
                    break;
            }
            if (rowCooker < 0 || rowCooker > rows -1) {
                break;
            }
            if (colCooker < 0 || colCooker > rows - 1) {
                break;
            }
            if (matrix[rowCooker][colCooker] == 'O') {
                if (rowCooker == firstRowPillar &&  colCooker == firstRowPillar) {
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < rows; col++) {
                            if (matrix[row][col] == 'O') {
                                matrix[row][col] = 'S';
                                rowCooker = row;
                                colCooker = col;
                            }
                        }
                    }
                } else {
                    matrix[rowCooker][colCooker] = '-';
                    rowCooker = firstRowPillar;
                    colCooker = firstColPillar;
                    matrix[rowCooker][colCooker] = 'S';
                }
            }
            if (matrix[rowCooker][colCooker] != 'O' && matrix[rowCooker][colCooker] != '-' && matrix[rowCooker][colCooker] != 'S') {
                int money = Integer.parseInt(String.valueOf(matrix[rowCooker][colCooker]));
                allMoney += money;
                matrix[rowCooker][colCooker] = 'S';
            }
            if (allMoney >= 50) {
                break;
            }
        }

        if (rowCooker < 0 || rowCooker > rows -1 || colCooker < 0 || colCooker > rows - 1) {
            System.out.println("Bad news, you are out of the bakery.");
            System.out.printf("Money: %d%n", allMoney);
        } else if (allMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.printf("Money: %d%n", allMoney);
        }

        printMatrix(rows, matrix);
    }

    private static void printMatrix(int rows, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
