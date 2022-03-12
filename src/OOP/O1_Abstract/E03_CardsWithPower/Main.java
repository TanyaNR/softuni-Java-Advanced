package OOP.O1_Abstract.E03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rankCard = scanner.nextLine();
        String suitCard = scanner.next();

        RankPower rankPower = RankPower.valueOf(rankCard);
        int powerOfRankCard = rankPower.getPower();

        SuitPower suitPower = SuitPower.valueOf(suitCard);
        int powerOfSuitCard = suitPower.getPower();

        int cardPower = powerOfRankCard + powerOfSuitCard;

        System.out.printf("Card name: %s of %s; Card power: %d%n", rankCard, suitCard, cardPower);
    }
}
