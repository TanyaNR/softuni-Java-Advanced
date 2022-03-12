package Advanced.O3_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstLop = inputLine[0];
        int secondLop = inputLine[1];

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstLop; i++) {
            String addedToSet = scanner.nextLine();
            firstSet.add(addedToSet);
        }

        for (int i = 0; i < secondLop; i++) {
            String addedToSet = scanner.nextLine();
            secondSet.add(addedToSet);
        }

        Set<String> duplicateSet = new LinkedHashSet<>();
        for (String s : firstSet) {
            if (secondSet.contains(s)) {
                duplicateSet.add(s);
            }
        }

        for (String s : duplicateSet) {
            System.out.print(s + " ");
        }
    }
}
