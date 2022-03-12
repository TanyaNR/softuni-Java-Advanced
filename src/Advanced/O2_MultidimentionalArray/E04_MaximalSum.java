package Advanced.O2_MultidimentionalArray;

import java.util.Scanner;

public class E04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        fillmatrix(matrix, scanner);

        int sumMax = Integer.MIN_VALUE;
        int starRow = 0;
        int starCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                          matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 2][col + 1] +
                          matrix[row + 2][col] + matrix[row + 1][col + 2] + matrix[row + 2][col + 2];
                if (sum > sumMax) {
                    sumMax = sum;
                    starRow = row;
                    starCol = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", sumMax);
        for (int row = starRow; row <= starRow + 2; row++) {
            for (int col = starCol; col <= starCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void fillmatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
