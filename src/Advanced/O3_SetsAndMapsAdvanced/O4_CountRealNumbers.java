package Advanced.O3_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class O4_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> occurrence = new LinkedHashMap<>();
        for (double kay : input) {
            if (occurrence.containsKey(kay)) {
                int currentValue = occurrence.get(kay);
                currentValue++;
                occurrence.put(kay, currentValue);
            } else {
                occurrence.put(kay, 1);
            }
        }

        occurrence.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));

    }
}
