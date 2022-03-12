package Advanced.O5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class E09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> checkDivisible = ((number, list) -> {
            for (int integerInList : list) {
                if (number % integerInList != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int i = 1; i <= n; i++) {
            if (checkDivisible.apply(i, numbers)) {
                System.out.print(i + " ");
            }
        }
    }
}
