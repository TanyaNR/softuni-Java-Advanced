package Advanced.O5_FunctionalProgramming;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputInteger = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestElementFunction = list -> list.lastIndexOf(Collections.min(list));
        System.out.println(smallestElementFunction.apply(inputInteger));

    }
}
