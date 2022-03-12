package Advanced.O3_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> username = new LinkedHashSet<>();
        while (n-- > 0) {
            String input = scanner.nextLine();
            username.add(input);
        }

        for (String s : username) {
            System.out.println(s);
        }
    }
}
