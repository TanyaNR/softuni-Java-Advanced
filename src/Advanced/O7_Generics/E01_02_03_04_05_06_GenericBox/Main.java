package Advanced.O7_Generics.E01_02_03_04_05_06_GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        //Exercise 1
//        Box<String> box = new Box<>();
//        for (int i = 0; i < number; i++) {
//            String text = scanner.nextLine();
//            box.add(text);
//        }

        //Exercise 2
//        Box<Integer>box = new Box<>();
//        for (int i = 0; i < number; i++) {
//            int value = Integer.parseInt(scanner.nextLine());
//            box.add(value);
//        }

        //Exercise 3
//        Box<String> box = new Box<>();
//        for (int i = 0; i < number; i++) {
//            String text = scanner.nextLine();
//            box.add(text);
//        }
//
//        int firstSwapIndex = scanner.nextInt();
//        int secondSwapIndex = scanner.nextInt();
//        box.swapElement(firstSwapIndex, secondSwapIndex);

        //Exercise 4
//        Box<Integer> box = new Box<>();
//        for (int i = 0; i < number; i++) {
//            int value = Integer.parseInt(scanner.nextLine());
//            box.add(value);
//        }
//
//        int firstSwapIndex = scanner.nextInt();
//        int secondSwapIndex = scanner.nextInt();
//        box.swapElement(firstSwapIndex, secondSwapIndex);

        //Exercise 5
//        Box<String> box = new Box<>();
//        for (int i = 0; i < number; i++) {
//            String text = scanner.nextLine();
//            box.add(text);
//        }
//        String elementToCompare = scanner.nextLine();

        //Exercise 6
        Box<Double>box = new Box<>();
        for (int i = 0; i < number; i++) {
            double value = Double.parseDouble(scanner.nextLine());
            box.add(value);
        }
        double elementToCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreatThan(elementToCompare));
    }
}
