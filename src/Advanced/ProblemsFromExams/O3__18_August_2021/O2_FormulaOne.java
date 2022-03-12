package Advanced.ProblemsFromExams.O3__18_August_2021;

import java.util.Scanner;

public class O2_FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int num = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int rowCar = 0;
        int colCar = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'P') {
                    rowCar = row;
                    colCar = col;
                }
            }
        }

        for (int i = 0; i < num; i++) {
            String moveCar = scanner.nextLine();
            matrix[rowCar][colCar] = '.';
            switch (moveCar) {
                case "up":
                    rowCar--;
                    if (rowCar < 0) {
                        rowCar = rows - 1;
                    }
                    break;
                case "down":
                    rowCar++;
                    if (rowCar > rows - 1) {
                        rowCar = 0;
                    }
                    break;
                case "left":
                    colCar--;
                    if (colCar < 0) {
                        colCar = rows - 1;
                    }
                    break;
                case "right":
                    colCar++;
                    if (colCar > rows  - 1) {
                        colCar = 0;
                    }
                    break;
            }

            if (matrix[rowCar][colCar] == 'B') {
                switch (moveCar) {
                    case "up":
                        rowCar--;
                        if (rowCar < 0) {
                            rowCar = rows - 1;
                        }
                        break;
                    case "down":
                        rowCar++;
                        if (rowCar > rows - 1) {
                            rowCar = 0;
                        }
                        break;
                    case "left":
                        colCar--;
                        if (colCar < 0) {
                            colCar = rows - 1;
                        }
                        break;
                    case "right":
                        colCar++;
                        if (colCar > rows  - 1) {
                            colCar = 0;
                        }
                        break;
                }
                matrix[rowCar][colCar] = 'P';
            }

            if (matrix[rowCar][colCar] == 'T') {
                switch (moveCar) {
                    case "down":
                        rowCar--;
                        if (rowCar < 0) {
                            rowCar = rows - 1;
                        }
                        break;
                    case "up":
                        rowCar++;
                        if (rowCar > rows - 1) {
                            rowCar = 0;
                        }
                        break;
                    case "right":
                        colCar--;
                        if (colCar < 0) {
                            colCar = rows - 1;
                        }
                        break;
                    case "left":
                        colCar++;
                        if (colCar > rows  - 1) {
                            colCar = 0;
                        }
                        break;
                }
                matrix[rowCar][colCar] = 'P';
            }

            if (matrix[rowCar][colCar] == 'F'){
                matrix[rowCar][colCar] = 'P';
                System.out.println("Well done, the player won first place!");
                printMatrix(rows, matrix);
                break;
            }

            matrix[rowCar][colCar] = 'P';
        }

        if (isMatrixHaveP(matrix, rows)) {
            System.out.println("Oh no, the player got lost on the track!");
            printMatrix(rows, matrix);
        }
    }

    private static void printMatrix(int rows, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isMatrixHaveP(char[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'F') {
                    return true;
                }
            }
        }
        return false;
    }
}
