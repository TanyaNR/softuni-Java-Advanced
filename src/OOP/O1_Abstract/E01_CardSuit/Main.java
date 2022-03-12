package OOP.O1_Abstract.E01_CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Suits:");
        CardSuite[] cardSuites = CardSuite.values();

        for (CardSuite cardSuite : cardSuites) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuite.ordinal(), cardSuite.toString());
        }
    }
}
