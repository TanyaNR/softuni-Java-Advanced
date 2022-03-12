package Advanced.O2_MultidimentionalArray;

import java.util.ArrayList;
import java.util.Scanner;

public class E06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rotation = Integer.parseInt(input.split("[()]+")[1]) % 360;

        ArrayList<String> rowData = new ArrayList<>();
        int colData = 0;

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            rowData.add(line);
            if (line.length() > colData) {
                colData = line.length();
            }
        }

        int rows = rowData.size();
        int cols = colData;

        char [][] matrix = new char[rows][cols];
        fillMatrix(matrix, rows, cols, rowData);

        rotationMatrix(matrix, rotation, rows, cols, rowData);

    }



    private static void rotationMatrix(char[][] matrix, int rotation, int rows, int cols, ArrayList<String> rowData) {
        if (rotation == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotation == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0 ; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotation == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows ; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        }
    }


    private static void fillMatrix(char[][] matrix, int rows, int cols, ArrayList<String> rowData) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < rowData.get(row).length()) {
                    matrix[row][col] = rowData.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }
}
