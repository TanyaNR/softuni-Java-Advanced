package Advanced.O5_FunctionalProgramming;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class O4_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] price = scanner.nextLine().split(", ");
        Function<String, Double> parser = e -> Double.parseDouble(e);
        UnaryOperator<Double> addVat = e -> 1.2 * e;
        Consumer<Double> print = e -> System.out.printf("%.2f%n", e);

        System.out.println("Prices with VAT:");
        Arrays.stream(price)
                .map(parser)
                .map(addVat)
                .forEach(print);

    }
}
