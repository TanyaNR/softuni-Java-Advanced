package Advanced.O2_MultidimentionalArray;

import java.util.Scanner;

public class E08_TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean [][] matrixRoom = new boolean[15][15];
        int playerRow = 7;
        int playerCol = 7;
        double playerPoint = 18000;
        double heigenPoint = 3000000;

        double damagePoint = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();


        while (true) {
            String spell = input.split("\\s+")[0];
            int rowDamage = Integer.parseInt(input.split("\\s+")[1]);
            int colDamage = Integer.parseInt(input.split("\\s+")[2]);

            heigenPoint -= damagePoint;

            isHeigenDead(playerRow, playerCol, heigenPoint, spell);
            break;


        }

    }

    private static boolean isHeigenDead(int playerRow, int playerCol, double heigenPoint, String spell) {
        if (heigenPoint < 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heigenPoint);
            System.out.printf("Player: Killed by %s%n", spell);
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
            return true;
        }
        return false;
    }
}
