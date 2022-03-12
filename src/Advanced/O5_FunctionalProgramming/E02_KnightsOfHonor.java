package Advanced.O5_FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class E02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        Consumer printConsumer = e -> System.out.println("Sir " + e);
        for (String s : text) {
            printConsumer.accept(s);
        }
    }
}
