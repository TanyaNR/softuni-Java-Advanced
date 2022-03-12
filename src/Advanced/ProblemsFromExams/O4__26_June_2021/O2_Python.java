package Advanced.ProblemsFromExams.O4__26_June_2021;

import java.util.Scanner;

public class O2_Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String[] commandData = scanner.nextLine().split(", ");

        String[][] matrix = new String[rows][rows];
        for (int row = 0; row < rows; row++) {
            String[] rowMatrix = scanner.nextLine().split("\\s+");
            matrix[row] = rowMatrix;
        }

        int countFood = 0;
        int rowPython = 0;
        int colPython = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col].equals("s")) {
                    rowPython = row;
                    colPython = col;
                }
                if (matrix[row][col].equals("f")) {
                    countFood++;
                }
            }
        }

        int lengthPython = 1;
        int number = commandData.length;
        for (int i = 0; i < number; i++) {
            String command = commandData[i];
            switch (command){
                case "up":
                    rowPython--;
                    if (rowPython < 0) {
                        rowPython = rows - 1;
                    }
                    break;
                case "down":
                    rowPython++;
                    if (rowPython > rows - 1) {
                        rowPython = 0;
                    }
                    break;
                case "left":
                    colPython--;
                    if (colPython < 0) {
                        colPython = rows - 1;
                    }
                    break;
                case "right":
                    colPython++;
                    if (colPython > rows - 1) {
                        colPython = 0;
                    }
                    break;
            }

            if (matrix[rowPython][colPython].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

            if (matrix[rowPython][colPython].equals("f")) {
                lengthPython++;
                countFood--;
            }

            if (countFood == 0) {
                System.out.printf("You win! Final python length is %d%n", lengthPython);
                return;
            }

        }


        if (countFood != 0) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", countFood);
        }
    }
}
