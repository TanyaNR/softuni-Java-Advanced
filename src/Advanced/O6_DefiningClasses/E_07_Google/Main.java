package Advanced.O6_DefiningClasses.E_07_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> peopleData = new HashMap<>();

        while ( ! input.equals("End")) {
            String[] inputData = input.split("\\s+");
            String personName = inputData[0];
            String personInformation = inputData[1];

            if ( ! peopleData.containsKey(personName)) {
                peopleData.put(personName, new Person());
            }

            switch (personInformation) {
                case "company":
                    String companyName = inputData[2];
                    String department = inputData[3];
                    double salary = Double.parseDouble(inputData[4]);
                    Company company = new Company(companyName, department, salary);
                    peopleData.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = inputData[2];
                    String pokemonType = inputData[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleData.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = inputData[2];
                    String parentBirthday = inputData[3];
                    Parents parents = new Parents(parentName, parentBirthday);
                    peopleData.get(personName).getParents().add(parents);
                    break;
                case "children":
                    String childName = inputData[2];
                    String childBirthday = inputData[3];
                    Children children = new Children(childName, childBirthday);
                    peopleData.get(personName).getChildren().add(children);
                    break;
                case "car":
                    String carModel = inputData[2];
                    int carSpeed = Integer.parseInt(inputData[3]);
                    Car car = new Car(carModel, carSpeed);
                    peopleData.get(personName).setCar(car);
                    break;

            }

            input = scanner.nextLine();
        }

        String searchPerson = scanner.nextLine();
        System.out.println(searchPerson);

        Person personalData = peopleData.get(searchPerson);
        System.out.println(personalData);
    }
}
