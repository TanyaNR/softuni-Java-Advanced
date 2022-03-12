package Advanced.O5_FunctionalProgramming;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.function.Predicate;

public class O6_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int startNumber = Integer.parseInt(input[0]);
        int endNumber = Integer.parseInt(input[1]);
        String command = scanner.nextLine();

        Predicate<Integer> checkIfIven;
        if (command.equals("odd")) {
            checkIfIven = number -> number % 2 != 0;
        } else {
            checkIfIven = number -> number % 2 == 0;
        }
        for (int number = startNumber; number <= endNumber; number++) {
            if (checkIfIven.test(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
