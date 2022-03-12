package Advanced.O8_IteratorsAndComparators.E03_StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StackIterator stackIterator = new StackIterator();

        while (!input.equals("END")) {
            String command = input.split("\\s+")[0];

            switch (command) {
                case "Push":
                    String[] inputDigit = input.split("Push ")[1].split(",\\s+");
                    for (String digit : inputDigit) {
                        stackIterator.push(digit);
                    }
                    break;
                case"Pop":
                    stackIterator.pop();
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < 2; i++) {
            for (String string : stackIterator) {
                System.out.println(string);

            }
        }
    }
}
