package OOP.O1_Abstract.E06_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = dimensions[0];
        int col = dimensions[1];

        int[][] matrix = new int[row][col];

        int value = 0;
        fillMatrix(row, col, matrix, value);

        String command = scanner.nextLine();
        long sumAllStars = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] heroCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            evilDestroys(matrix, evilRow, evilCol);

            int heroRow = heroCoordinates[0];
            int heroCol = heroCoordinates[1];

            sumAllStars = getStars(matrix, sumAllStars, heroRow, heroCol);

            command = scanner.nextLine();
        }

        System.out.println(sumAllStars);


    }

    private static long getStars(int[][] matrix, long sum, int heroRow, int heroCol) {
        while (heroRow >= 0 && heroCol < matrix[1].length) {
            if (heroRow < matrix.length && heroCol >= 0 && heroCol < matrix[0].length) {
                sum += matrix[heroRow][heroCol];
            }

            heroCol++;
            heroRow--;
        }
        return sum;
    }

    private static void evilDestroys(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void fillMatrix(int row, int col, int[][] matrix, int value) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
