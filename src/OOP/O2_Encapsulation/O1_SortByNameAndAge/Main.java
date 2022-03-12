package OOP.O2_Encapsulation.O1_SortByNameAndAge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            Person person = new Person(firstName, lastName, age, salary);
            people.add(person);
        }

        double bonus = Double.parseDouble(scanner.nextLine());

//        people.sort(Comparator.comparing(OOP.О4_InterfacesАndAbstraction.O3_4_Hello.OOP.О4_InterfacesАndAbstraction.E01_DefineAnInterfacePerson.OOP.О4_InterfacesАndAbstraction.E04_Food.Person::getFirstName).thenComparingInt(OOP.О4_InterfacesАndAbstraction.O3_4_Hello.OOP.О4_InterfacesАndAbstraction.E01_DefineAnInterfacePerson.OOP.О4_InterfacesАndAbstraction.E04_Food.Person::getAge));

        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }

}
