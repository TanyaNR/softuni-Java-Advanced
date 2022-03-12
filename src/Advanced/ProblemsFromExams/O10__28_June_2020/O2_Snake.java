package Advanced.ProblemsFromExams.O10__28_June_2020;

import java.util.Scanner;

public class O2_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int rowSnake = 0;
        int colSnake = 0;
        int firstLairRow = 0;
        int firstLairCol = 0;
        int countFood = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'S') {
                    rowSnake = row;
                    colSnake = col;
                }
                if (matrix[row][col] == 'B') {
                    firstLairRow = row;
                    firstLairCol = col;
                }
            }
        }

        while (scanner.hasNextLine()){
            String command = scanner.nextLine();
            matrix[rowSnake][colSnake] = '.';

            switch (command) {
                case "up":
                    rowSnake--;
                    break;
                case "down":
                    rowSnake++;
                    break;
                case "left":
                    colSnake--;
                    break;
                case "right":
                    colSnake++;
                    break;

            }

            if (rowSnake < 0 || rowSnake > rows -1 || colSnake < 0 || colSnake > rows - 1) {
                break;
            }

            if (countFood >= 10) {
                matrix[rowSnake][colSnake] = 'S';
                break;
            }

            if (matrix[rowSnake][colSnake] == 'B') {
                matrix[rowSnake][colSnake] = '.';
                if (!(rowSnake == firstLairRow) && !(colSnake == firstLairCol)) {
                    rowSnake = firstLairRow;
                    colSnake = firstLairCol;
                    matrix[rowSnake][colSnake] = 'S';
                } else {
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < rows; col++) {
                            if (matrix[rowSnake][colSnake] == 'B') {
                                rowSnake = row;
                                colSnake = col;
                                matrix[rowSnake][colSnake] = 'S';
                            }
                        }
                    }
                }
            }

            if (matrix[rowSnake][colSnake] == '*') {
                countFood++;
            }

            matrix[rowSnake][colSnake] = 'S';
        }



        if (rowSnake < 0 || rowSnake > rows -1 || colSnake < 0 || colSnake > rows - 1 || countFood < 10) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", countFood);
        printMatrix(matrix, rows);
    }

    private static void printMatrix(char[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
