package Advanced.O2_MultidimentionalArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        int rows = Integer.parseInt(inputLine.split("\\s+")[0]);
        int cols = Integer.parseInt(inputLine.split("\\s+")[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String destroy = scanner.nextLine();

        while ( ! destroy.equals("Nuke it from orbit")) {
            int rowDestroy = Integer.parseInt(destroy.split("\\s+")[0]);
            int colDestroy = Integer.parseInt(destroy.split("\\s+")[1]);
            int radius = Integer.parseInt(destroy.split("\\s+")[2]);

            for (int currentRow = rowDestroy - radius; currentRow <= rowDestroy + radius; currentRow++) {
                if (isInMatrix(matrix, currentRow, colDestroy)) {
                    matrix.get(currentRow).remove(colDestroy);
                }
            }

            for (int currentCol = colDestroy + radius; currentCol >= colDestroy - radius ; currentCol--) {
                if (isInMatrix(matrix, rowDestroy, currentCol)) {
                    matrix.get(rowDestroy).remove(currentCol);
                }
            }

            matrix.removeIf(List::isEmpty);
            destroy = scanner.nextLine();
        }

        printMatrix(matrix);

    }



    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


    private static boolean isInMatrix(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }


    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int num = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(num);
                num++;
            }
        }
    }
}
