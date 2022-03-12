package Advanced.O3_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class E03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> element = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elementInput = scanner.nextLine().split("\\s+");
            element.addAll(Arrays.asList(elementInput));
        }

        for (String s : element) {
            System.out.print(s + " ");
        }

    }
}
