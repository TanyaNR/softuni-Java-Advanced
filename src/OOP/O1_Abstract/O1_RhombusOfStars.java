package OOP.O1_Abstract;

import java.util.Scanner;

public class O1_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        printTopHalfRhombus(size);
        printBottomHaltRombus(size);
    }


    private static void printBottomHaltRombus(int size) {
        for (int i = size - 1; i >= 1 ; i--) {
            printRow(size, i);
        }
    }

    private static void printTopHalfRhombus(int size) {
        for (int row = 1; row <= size; row++) {
            printRow(size, row);
        }
    }

    private static void printRow(int size, int i) {
        for (int j = size; j > i; j--) {
            System.out.print(" ");
        }
        for (int j = 0; j < i - 1; j++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
