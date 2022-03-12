package Advanced.O2_MultidimentionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class O5_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int bestSum = Integer.MIN_VALUE;
        String subRow1 = "";
        String subRow2 = "";

        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = input;
        }

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > bestSum) {
                    bestSum = sum;
                    subRow1 = matrix[row][col] + " " + matrix[row][col + 1];
                    subRow2 = matrix[row + 1][col] + " " + matrix[row + 1][col + 1];
                }
            }
        }

        System.out.println(subRow1);
        System.out.println(subRow2);
        System.out.println(bestSum);
    }
}
