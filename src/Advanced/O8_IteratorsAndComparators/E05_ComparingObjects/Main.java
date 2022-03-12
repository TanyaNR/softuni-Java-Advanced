package Advanced.O8_IteratorsAndComparators.E05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String dataPeople = scanner.nextLine();
        int countPeople = 0;

        while ( ! dataPeople.equals("END")) {
            String name = dataPeople.split("\\s+")[0];
            int age = Integer.parseInt(dataPeople.split("\\s+")[1]);
            String town = dataPeople.split("\\s+")[2];

            Person person = new Person(name, age, town);
            people.add(person);
            countPeople++;

            dataPeople = scanner.nextLine();
        }

        int number = Integer.parseInt(scanner.nextLine());
        int indexPerson = number - 1;

        Person searchedPerson = people.get(indexPerson);
        people.remove(indexPerson);
        int count = 1;

        for (Person person : people) {
            if (searchedPerson.compareTo(person) == 0) {
                count++;
            }
        }

        if (count == 1) {
            System.out.println("No matches");
        } else if (count > 1) {
            System.out.printf("%d %d %d", count, countPeople - count, countPeople);
        }
    }
}
