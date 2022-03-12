package Advanced.O8_IteratorsAndComparators.E06_StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        TreeSet<Person> peopleSortedByName = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> peopleSortedByAge = new TreeSet<>(new PersonAgeComparator());

        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        peopleSortedByName.addAll(people);
        peopleSortedByAge.addAll(people);
        for (Person person : peopleSortedByName) {
            System.out.println(person);
        }

        for (Person person : peopleSortedByAge) {
            System.out.println(person);
        }

    }
}
