package Advanced.ProblemsFromExams.O8__19_August_2020;

import java.util.Scanner;

public class O2_Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[rows][rows];
        for (int row = 0; row < rows; row++) {
            territory[row] = scanner.nextLine().toCharArray();
        }

        int rowBee = 0;
        int colBee = 0;
        int countFlowers = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (territory[row][col] == 'B') {
                    rowBee = row;
                    colBee = col;
                }
                if (territory[row][col] == 'f') {
                    countFlowers++;
                }
            }

        }
    }
}
