package Advanced.ProblemsFromExams.O1__15_December_2021;

import java.util.Scanner;

public class O2_ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] fieldParis = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            fieldParis[row] = scanner.nextLine().toCharArray();
        }

        int parisRow = 0;
        int parisCol = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < fieldParis[row].length; col++) {
                if (fieldParis[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        while (true) {
            String[] commandData = scanner.nextLine().split("\\s+");
            //{command} {rowSpartan} {colSpartan}
            String command = commandData[0];
            int enemyRow = Integer.parseInt(commandData[1]);
            int enemyCol = Integer.parseInt(commandData[2]);

            fieldParis[parisRow][parisCol] = '-';
            fieldParis[enemyRow][enemyCol] = 'S';

            switch (command) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < rows) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (parisCol + 1 < fieldParis[parisRow].length) {
                        parisCol++;
                    }
                    break;
            }
            // 1. преместване - energy - 1
            energy--;
            //    ако стигне края - не се мести -> energy - 1
            //    проверка дали е урял -> energy <= 0,
            if (energy <= 0) {
                parisDead(fieldParis, parisRow, parisCol);
                break;
            }
            // 2. ако на мястото има спартанец -> energy - 2
            if (fieldParis[parisRow][parisCol] == 'S') {
                //    проверка дали е урял -> energy <= 0, мястото е 'Х' ->
                //    отпечатваме, че е умрял
                //    отпечатваме матрицата
                //    ако спартанецът е убит -> мястото е -> '-'
                energy -= 2;
                if (energy <= 0) {
                    parisDead(fieldParis, parisRow, parisCol);
                    break;
                } else {
                    fieldParis[parisRow][parisCol] = '-';
                }
                // 3. ако на мястото е Хелън -> мястото е -> '-' т.е (бягат, дори и energy == 0)
            } else if (fieldParis[parisRow][parisCol] == 'H') {
                fieldParis[parisRow][parisCol] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                printMatrix(fieldParis);
                break;
            }
        }
    }

    private static void parisDead(char[][] fieldParis, int parisRow, int parisCol) {
        //мястото е Х ->
        //отпечатваме, че е умрял
        //отпечатваме матрицата
        fieldParis[parisRow][parisCol] = 'X';
        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        printMatrix(fieldParis);
    }

    private static void printMatrix(char[][] fieldParis) {
        for (int row = 0; row < fieldParis.length; row++) {
            for (int col = 0; col < fieldParis[row].length; col++) {
                System.out.print(fieldParis[row][col]);
            }
            System.out.println();
        }
    }
}
