package Advanced.ProblemsFromExams.O2__23_October_2021;

import java.util.Scanner;

public class O2_MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] fieldMouse = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            fieldMouse[row] = scanner.nextLine().toCharArray();
        }

        int eatCheese = 0;
        int rowMouse = 0;
        int colMouse = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (fieldMouse[row][col] == 'M') {
                    rowMouse = row;
                    colMouse = col;
                }
            }
        }


        String moveCommand = scanner.nextLine();
        while (!moveCommand.equals("end")) {
            fieldMouse[rowMouse][colMouse] = '-';
            switch (moveCommand) {
                case "up":
                    rowMouse--;
                    break;
                case "down":
                    rowMouse++;
                    break;
                case "left":
                    colMouse--;
                    break;
                case "right":
                    colMouse++;
                    break;
            }

            if (rowMouse < 0 || rowMouse >= rows || colMouse < 0 || colMouse >= rows) {
                System.out.println("Where is the mouse?");
                break;
            }

            if (fieldMouse[rowMouse][colMouse] == 'c') {
                eatCheese++;
            } else if (fieldMouse[rowMouse][colMouse] == 'B') {
                fieldMouse[rowMouse][colMouse] = '-';
                String mouseMoveBonus = moveCommand;
                switch (mouseMoveBonus) {
                    case "up":
                        rowMouse--;
                        break;
                    case "down":
                        rowMouse++;
                        break;
                    case "left":
                        colMouse--;
                        break;
                    case "right":
                        colMouse++;
                        break;
                }
                if (fieldMouse[rowMouse][colMouse] == 'c') {
                    eatCheese++;
                    fieldMouse[rowMouse][colMouse] = '-';
                }

                fieldMouse[rowMouse][colMouse] = 'M';
            }
            fieldMouse[rowMouse][colMouse] = 'M';
            moveCommand = scanner.nextLine();
        }


        if (eatCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatCheese);
        }
        printFieldMouse(fieldMouse, rows);
    }

    private static void printFieldMouse(char[][] fieldMouse, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(fieldMouse[row][col]);
            }
            System.out.println();
        }
    }
}
