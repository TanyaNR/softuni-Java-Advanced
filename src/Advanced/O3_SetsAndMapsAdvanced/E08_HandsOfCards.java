package Advanced.O3_SetsAndMapsAdvanced;

import java.util.*;

public class E08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> playerDeck = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String playerName = input.split(": ")[0];
            String inputPart = input.split(": ")[1];
            String[] cardDraw = inputPart.split(", ");

            if (!playerDeck.containsKey(playerName)) {
                Set<String> cards = new HashSet<>();
                cards.addAll(Arrays.asList(cardDraw));
                playerDeck.put(playerName, cards);
            } else {
                Set<String> currentCards = playerDeck.get(playerName);
                currentCards.addAll(Arrays.asList(cardDraw));
                playerDeck.put(playerName, currentCards);
            }

            input = scanner.nextLine();
        }

        playerDeck.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getPointsCard(cards);
            System.out.printf("%s: %d%n", name, points);
        });
    }

    private static int getPointsCard(Set<String> cards) {
        int sumPoints = 0;
        int points = 0;
        int power = 0;
        int type = 0;
        for (String card : cards) {
            if (card.startsWith("10")) {
                power = 10;
            } else if (card.startsWith("2")) {
                power = 2;
            } else if (card.startsWith("3")) {
                power = 3;
            } else if (card.startsWith("4")) {
                power = 4;
            }else if (card.startsWith("5")) {
                power = 5;
            } else if (card.startsWith("6")) {
                power = 6;
            } else if (card.startsWith("7")) {
                power = 7;
            } else if (card.startsWith("8")) {
                power = 8;
            } else if (card.startsWith("9")) {
                power = 9;
            } else if (card.startsWith("J")) {
                power = 11;
            } else if (card.startsWith("Q")) {
                power = 12;
            } else if (card.startsWith("K")) {
                power = 13;
            } else if (card.startsWith("A")) {
                power = 14;
            }

            if (card.endsWith("S")) {
                type = 4;
            } else if (card.endsWith("H")) {
                type = 3;
            } else if (card.endsWith("D")) {
                type = 2;
            } else if (card.endsWith("C")) {
                type = 1;
            }
            points = power * type;
            sumPoints += points;
        }

        return sumPoints;
    }
}
