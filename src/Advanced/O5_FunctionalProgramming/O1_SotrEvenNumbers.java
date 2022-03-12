package Advanced.O5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class O1_SotrEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(", ");

        List<String> numbersList = Arrays.stream(numbers)
                .map(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.print(String.join(", ", numbersList));
        System.out.println();

       numbersList = numbersList
               .stream()
               .map(e -> Integer.parseInt(e))
               .sorted()
               .map(e-> e.toString())
               .collect(Collectors.toList());

        System.out.print(String.join(", ", numbersList));
        System.out.println();
    }
}
