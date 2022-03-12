package Advanced.O3_SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class O9_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sorted = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((left, right) -> right.compareTo(left))
                .limit(3)
                .collect(Collectors.toList());

        sorted.forEach(integer -> System.out.print(integer + " "));
    }
}
