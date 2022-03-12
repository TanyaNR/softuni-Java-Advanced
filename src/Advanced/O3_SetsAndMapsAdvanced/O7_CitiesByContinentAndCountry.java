package Advanced.O3_SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class O7_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, ArrayList<String>>> map = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] inputData = scanner.nextLine().split("\\s+");

            String continent = inputData[0];
            String country = inputData[1];
            String city = inputData[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }

        map.entrySet().stream()
                .forEach(continent -> {
                    System.out.println(continent.getKey() + ":");
                    continent.getValue().entrySet().stream()
                            .forEach(country ->
                                    System.out.printf("  %s -> %s%n", country.getKey(), String.join(", ", country.getValue())));
                });
    }
}
