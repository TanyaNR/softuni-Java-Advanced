package Advanced.O3_SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> stringMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            String letter = String.valueOf(input.charAt(i));
            if ( ! stringMap.containsKey(letter)) {
                stringMap.put(letter, 1);
            } else {
                int currentCount = stringMap.get(letter);
                currentCount++;
                stringMap.put(letter, currentCount);
            }
        }

//S: 1 time/s
        stringMap.entrySet()
                .forEach(stringIntegerEntry ->
                        System.out.println(stringIntegerEntry.getKey() + ": " + stringIntegerEntry.getValue() + " time/s"));
    }
}
