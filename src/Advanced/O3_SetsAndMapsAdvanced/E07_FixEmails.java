package Advanced.O3_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Map<String, String> bookEmails = new LinkedHashMap<>();

        while ( ! name.equals("stop")) {
            String email = scanner.nextLine();
            if ( ! (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com"))) {
                bookEmails.put(name, email);
            }

            name = scanner.nextLine();
        }
        bookEmails.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
