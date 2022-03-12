package OOP.O2_Encapsulation.E02_AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameChicken = scanner.nextLine();
        int ageChicken = Integer.parseInt(scanner.nextLine());

        try {
            Chicken chicken = new Chicken(nameChicken, ageChicken);
            System.out.println(chicken.toString());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
