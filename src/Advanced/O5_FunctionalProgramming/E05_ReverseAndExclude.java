package Advanced.O5_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputNumber = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());


        Collections.reverse(inputNumber);
        Predicate<Integer> checkDividedPredicate = e -> e % n == 0;
        inputNumber.removeIf(checkDividedPredicate);
        for (Integer integer : inputNumber) {
            System.out.print(integer + " ");
        }
    }
}
