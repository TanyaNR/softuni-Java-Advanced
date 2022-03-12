package Advanced.O3_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E06_AMinerTask {
    public static <doubel> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> minerTask = new LinkedHashMap<>();
        while ( ! input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if ( ! minerTask.containsKey(input)) {
                minerTask.put(input, quantity);
            } else {
                int currentQuantity = minerTask.get(input);
                currentQuantity += quantity;
                minerTask.put(input, currentQuantity);
            }

            input = scanner.nextLine();
        }

        minerTask.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
