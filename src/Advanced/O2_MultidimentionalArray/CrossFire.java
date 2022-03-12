package Advanced.O2_MultidimentionalArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CrossFire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);


        String input = scan.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int rowCoordinates = Integer.parseInt(input.split("\\s+")[0]);
            int colCoordinates = Integer.parseInt(input.split("\\s+")[1]);
            int destructionRange = Integer.parseInt(input.split("\\s+")[2]);

            destroy(matrix, rowCoordinates, colCoordinates, destructionRange);

            input = scan.nextLine();
        }

        printOutput(matrix);
    }



    public static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int num = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(num++);
            }
        }
    }

    public static void destroy(List<List<Integer>> matrix, int rowCoordinates, int colCoordinates, int destructionRange) {
        for (int i = rowCoordinates - destructionRange; i <= rowCoordinates + destructionRange; i++) {
            if (isInRange(i, colCoordinates, matrix) && i != rowCoordinates) {
                matrix.get(i).remove(colCoordinates);
            }
        }

        for (int i = colCoordinates + destructionRange; i >= colCoordinates - destructionRange; i--) {
            if (isInRange(rowCoordinates, i, matrix)) {
                matrix.get(rowCoordinates).remove(i);
            }
        }

        matrix.removeIf(List::isEmpty);
    }


    public static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }


    public static void printOutput(List<List<Integer>> matrix) {
        for(List<Integer> integers : matrix){
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
