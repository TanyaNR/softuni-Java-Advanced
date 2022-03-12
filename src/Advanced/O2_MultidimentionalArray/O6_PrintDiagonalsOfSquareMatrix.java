package Advanced.O2_MultidimentionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class O6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            int [] dataMatrix = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = dataMatrix;
        }

        for (int row = 0; row < n; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
        for (int row = 0; row < n; row++) {
            System.out.print(matrix[n-row-1][row] + " ");
        }
    }
}
