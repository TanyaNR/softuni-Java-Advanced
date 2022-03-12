package Advanced.O2_MultidimentionalArray;

import java.util.Scanner;

public class E02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String [][] matrix= new String[rows][cols];
        fillMatrix(matrix);
        
        printMatrix(matrix);
        
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix) {
        char first = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String colChar = "" + first + (char)(first + col) + first;
                matrix[row][col] = colChar;
            }
            first = (char)(first + 1);
        }
    }
}
