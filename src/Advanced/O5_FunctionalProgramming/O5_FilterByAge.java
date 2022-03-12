package Advanced.O5_FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class O5_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] peopleData = scanner.nextLine().split(", ");
            String name = peopleData[0];
            int age = Integer.parseInt(peopleData[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

        BiPredicate<Integer, Integer> predicateCondition;
        if (condition.equals("older")) {
            predicateCondition = (personAge, age) -> personAge >= age;
        } else {
            predicateCondition = (personAge, age) -> personAge <= age;
        }

        Consumer<Map.Entry<String, Integer>> printConsumer;
        if (printType.equals("name")) {
            printConsumer = person -> System.out.println(person.getKey());
        } else if (printType.equals("age")) {
            printConsumer = person -> System.out.println(person.getValue());
        } else {
            printConsumer = person -> System.out.println(person.getKey() + " - " + person.getValue());
        }

        people.entrySet()
                .stream()
                .filter(person -> predicateCondition.test(person.getValue(), ageLimit))
                .forEach(printConsumer);

    }
}

