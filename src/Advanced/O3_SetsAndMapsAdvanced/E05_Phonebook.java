package Advanced.O3_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phoneBook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String people = input.split("-")[0];
            String phoneNumber = input.split("-")[1];

            if (!phoneBook.containsKey(people)) {
                phoneBook.put(people, phoneNumber);
            } else {
                String currentNumber = phoneBook.get(people);
                currentNumber = phoneNumber;
                phoneBook.put(people, currentNumber);
            }

            input = scanner.nextLine();
        }
        String searchName = scanner.nextLine();

        while (!searchName.equals("stop")) {
            if (!phoneBook.containsKey(searchName)) {
                System.out.printf("Contact %s does not exist.%n", searchName);
            } else {
                System.out.println(searchName + " -> " + phoneBook.get(searchName));
            }

            searchName = scanner.nextLine();
        }
    }
}
