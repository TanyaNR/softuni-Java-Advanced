
package OOP.O1_Abstract.E05_GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long capacityOfTheBag = Long.parseLong(scanner.nextLine());
        String[] itemPairs = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gem = 0;
        long cash = 0;

        for (int i = 0; i < itemPairs.length; i += 2) {
            String name = itemPairs[i];
            long count = Long.parseLong(itemPairs[i + 1]);

            String itemType = "";

            if (name.length() == 3) {
                itemType = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                itemType = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                itemType = "Gold";
            }

            if (itemType.equals("")) {
                continue;
            } else if (capacityOfTheBag < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (itemType) {
                case "Gem":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gold")) {
                            if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gem")) {
                            if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(itemType)) {
                bag.put((itemType), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(itemType).containsKey(name)) {
                bag.get(itemType).put(name, 0L);
            }


            bag.get(itemType).put(name, bag.get(itemType).get(name) + count);
            switch (itemType) {
                case "Gold":
                    gold += count;
                    break;
                case "Gem":
                    gem += count;
                    break;
                case "Cash":
                    cash += count;
                    break;
            }
        }

        for (var entry : bag.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", entry.getKey(), sumValues);

            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}