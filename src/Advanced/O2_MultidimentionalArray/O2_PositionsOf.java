package Advanced.O2_MultidimentionalArray;

import java.util.Scanner;

public class O2_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] matrixSize = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        int [][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String [] rowOfMatrix = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(rowOfMatrix[col]);
            }
        }

        boolean isFound = false;
        int findIndex = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == findIndex) {
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if ( ! isFound) {
            System.out.println("not found");
        }
    }
}
