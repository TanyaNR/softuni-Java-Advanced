package Advanced.O2_MultidimentionalArray;

import java.util.Scanner;

public class E05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineFirst = scanner.nextLine();
        int rows = Integer.parseInt(lineFirst.split("\\s+")[0]);
        int cols = Integer.parseInt(lineFirst.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        String instruction = scanner.nextLine();

        while ( ! instruction.equals("END")) {
            String[] input = instruction.split("\\s+");
            if ( ! isValidCommand(instruction, rows, cols)) {
                System.out.println("Invalid input!");
            } else {
                String [] instructionParts = instruction.split("\\s+");
                int row1 = Integer.parseInt(instructionParts[1]);
                int col1 = Integer.parseInt(instructionParts[2]);
                int row2 = Integer.parseInt(instructionParts[3]);
                int col2 = Integer.parseInt(instructionParts[4]);

                String currentElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = currentElement;

                printMatrix(matrix, rows, cols);
            }

            instruction = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidCommand(String instruction, int rows, int cols) {
        String [] instructionParts = instruction.split("\\s+");

        if (instructionParts.length != 5) {
            return false;
        }

        String command = instructionParts[0];
        if ( ! command.equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(instructionParts[1]);
        int col1 = Integer.parseInt(instructionParts[2]);
        int row2 = Integer.parseInt(instructionParts[3]);
        int col2 = Integer.parseInt(instructionParts[4]);
        if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= cols || row2 < 0 || row2 >= rows || col2 < 0 || col2 >= cols) {
            return  false;
        }

        return true;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}

