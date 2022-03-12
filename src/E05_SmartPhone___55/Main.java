package E05_SmartPhone___55;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        List<String> numbers = Arrays.stream(firstLine).collect(Collectors.toList());

        String[] secondLine = scanner.nextLine().split("\\s+");
        List<String> browser = Arrays.stream(secondLine).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(numbers, browser);

        for (String number : numbers) {
            System.out.println("Calling... " + number);
        }

        for (String url : browser) {
            if (isString(url)) {
                System.out.printf("Browsing: %s!%n", url);
            } else {
                System.out.println("Invalid URL!");
            }
        }
    }

    private static boolean isString(String url) {
        for (int i = 0; i < url.length(); i++) {
            char currentChar = url.charAt(i);
            if (Character.isDigit(currentChar)) {
                return false;
            }
        }
        return true;
    }
}

