package Advanced.O5_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E04_ApplieArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputNumbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> addFunction = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyFunction = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractFunction = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        Consumer<List> printConsumer = list -> list.forEach(entry -> System.out.print(entry + " "));
        String command = scanner.nextLine();
        while ( ! command.equals("end")) {
            switch (command) {
                case "add":
                    inputNumbers = addFunction.apply(inputNumbers);
                    break;
                case "multiply":
                    inputNumbers = multiplyFunction.apply(inputNumbers);
                    break;
                case "subtract":
                    inputNumbers = subtractFunction.apply(inputNumbers);
                    break;
                case "print":
                    printConsumer.accept(inputNumbers);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
