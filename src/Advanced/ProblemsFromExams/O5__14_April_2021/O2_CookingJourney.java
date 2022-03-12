package Advanced.ProblemsFromExams.O5__14_April_2021;

import java.util.Scanner;

public class O2_CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        char[][] pastryShop = new char[rows][rows];
        for (int row = 0; row < rows; row++) {
            pastryShop[row] = scanner.nextLine().toCharArray();
        }

        int rowCooker = 0;
        int colCooker = 0;
        int money = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (pastryShop[row][col] == 'S') {
                    rowCooker = row;
                    colCooker = col;
                }
                if (pastryShop[row][col] == 'P') {
                }
            }
        }

        while (true) {
            pastryShop[rowCooker][colCooker] = '-';
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    rowCooker--;
                    break;
                case "down":
                    rowCooker++;
                    break;
                case "left":
                    colCooker--;
                    break;
                case "right":
                    colCooker++;
                    break;
            }

            if (rowCooker < 0 || rowCooker > rows - 1 || colCooker < 0 || colCooker > rows - 1) {
                System.out.println("Bad news! You are out of the pastry shop.");
                System.out.printf("Money: %d%n", money);
                break;
            }

            if (pastryShop[rowCooker][colCooker] == 'P') {
                pastryShop[rowCooker][colCooker] = '-';
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < rows; col++) {
                        if (pastryShop[row][col] == 'P') {
                            rowCooker = row;
                            colCooker = col;
                            break;
                        }
                    }
                }
            }

            if (isElementDigit(pastryShop, rowCooker, colCooker)) {
                char element = pastryShop[rowCooker][colCooker];
                int digit = Integer.parseInt(String.valueOf(element));
                money += digit;
                pastryShop[rowCooker][colCooker] = 'S';
            }

            if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                System.out.printf("Money: %d%n", money);
                break;
            }

            pastryShop[rowCooker][colCooker] = 'S';
        }


        printMatrix(pastryShop, rows);
    }

    private static void printMatrix(char[][] pastryShop, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(pastryShop[row][col]);
            }
            System.out.println();
        }
    }


    public static boolean isElementDigit(char[][] pastryShop, int row, int col) {
                char element = pastryShop[row][col];
        return element == '0' || element == '1' || element == '2' || element == '3' ||
                element == '4' || element == '5' || element == '6' || element == '7' ||
                element == '8' || element == '9';
    }
}
