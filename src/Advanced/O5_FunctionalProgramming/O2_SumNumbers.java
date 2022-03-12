package Advanced.O5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class O2_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split(", ");
        Function<String, Integer> valueInt = value -> Integer.parseInt(value);

        List<Integer> numbers = Arrays.stream(inputNumbers)
                .map(valueInt)
                .collect(Collectors.toList());

        int sum = Arrays.stream(inputNumbers)
                .mapToInt(value -> Integer.parseInt(value))
                .sum();

        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum);

    }
}
