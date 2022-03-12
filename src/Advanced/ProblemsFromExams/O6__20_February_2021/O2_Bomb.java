package Advanced.ProblemsFromExams.O6__20_February_2021;

import java.util.Scanner;

public class O2_Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String[] commandData = scanner.nextLine().split(",");

        String[][] matrix = new String[rows][rows];

        fillMatrix(matrix, rows, scanner);

        int rowBomb = 0;
        int colBomb = 0;
        int countBomb = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col].equals("s")) {
                    rowBomb = row;
                    colBomb = col;
                }
                if (matrix[row][col].equals("B")) {
                    countBomb++;
                }
            }
        }

        for (int i = 0; i < commandData.length; i++) {
            String command = commandData[i];
            switch (command) {
                case "up":
                    rowBomb--;
                    if (rowBomb < 0) {
                        rowBomb = 0;
                    }
                    break;
                case "down":
                    rowBomb++;
                    if (rowBomb > rows - 1) {
                        rowBomb = rows - 1;
                    }
                    break;
                case "left":
                    colBomb--;
                    if (colBomb < 0) {
                        colBomb = 0;
                    }
                    break;
                case "right":
                    colBomb++;
                    if (colBomb > rows - 1) {
                        colBomb = rows - 1;
                    }
                    break;
            }

            if (matrix[rowBomb][colBomb].equals("e")) {
                System.out.printf("END! %d bombs left on the field%n", countBomb);
                return;
            }

            if (matrix[rowBomb][colBomb].equals("B")) {
                countBomb--;
                matrix[rowBomb][colBomb] = "+";
                System.out.println("You found a bomb!");
            }

            if (countBomb == 0) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", countBomb, rowBomb, colBomb);
    }


    private static void fillMatrix(String[][] field, int rows, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            String[] entre = scanner.nextLine().split(" ");
            field[row] = entre;
        }
    }

}
