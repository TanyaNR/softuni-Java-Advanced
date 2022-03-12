package Advanced.O5_FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputInteger = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> comparator = ((left, rigth) -> {
            if (left % 2 == 0 && rigth % 2 != 0) {
                return -1;
            } else if (left % 2 != 0 && rigth % 2 == 0) {
                return 1;
            } else {
                return (left.compareTo(rigth));
            }
        });

        inputInteger.stream().sorted(comparator).forEach(numbers -> System.out.print(numbers + " "));
    }
}
