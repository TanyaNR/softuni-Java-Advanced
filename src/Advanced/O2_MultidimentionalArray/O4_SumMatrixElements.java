package Advanced.O2_MultidimentionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class O4_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowOfMatrix;
        }

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int element = matrix[row][col];
                sum += element;
            }
        }


        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
