package Advanced.O2_MultidimentionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class O1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] sizeMatrix1 = scanner.nextLine().split("\\s+");
        int rowsMatrix1 = Integer.parseInt(sizeMatrix1[0]);
        int colsMatrix1 = Integer.parseInt(sizeMatrix1[1]);

        int [][] matrix1 = new int [rowsMatrix1][colsMatrix1];
        for (int row = 0; row < rowsMatrix1; row++) {
            int [] rowMatrix1Data = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix1[row] = rowMatrix1Data;
        }

        String [] sizeMatrix2 = scanner.nextLine().split("\\s+");
        int rowsMatrix2 = Integer.parseInt(sizeMatrix2[0]);
        int colsMatrix2 = Integer.parseInt(sizeMatrix2[1]);

        int [][] matrix2 = new int [rowsMatrix2][colsMatrix2];
        for (int row = 0; row < rowsMatrix2; row++) {
            int [] rowMatrix2Data = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix2[row] = rowMatrix2Data;
        }

        if (rowsMatrix1 != rowsMatrix2 || colsMatrix1 != colsMatrix2) {
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < rowsMatrix1; row++) {
            for (int col = 0; col < colsMatrix2; col++) {
                if ( ! (matrix1[row][col] == matrix2[row][col])) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }
}
