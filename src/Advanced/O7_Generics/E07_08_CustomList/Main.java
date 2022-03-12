package Advanced.O7_Generics.E07_08_CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();
        CustomList<String> customList = new CustomList<String>();

        while ( ! inputData.equals("END")) {
            String command = inputData.split("\\s+")[0];

            switch (command) {
                case "Add":
                    String elementToAdd = inputData.split("\\s+")[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int elementToRemove = Integer.parseInt(inputData.split("\\s+")[1]);
                    customList.remove(elementToRemove);
                    break;
                case "Contains":
                    String elementToContains = inputData.split("\\s+")[1];
                    System.out.println(customList.contains(elementToContains));
                    break;
                case "Swap":
                    int firstSwapIndex = Integer.parseInt(inputData.split("\\s+")[1]);
                    int secondSwapIndex = Integer.parseInt(inputData.split("\\s+")[2]);
                    customList.swap(firstSwapIndex, secondSwapIndex);
                    break;
                case "Greater":
                    String elementToGreat = inputData.split("\\s+")[1];
                    System.out.println(customList.countGreatThan(elementToGreat));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                    customList.sort();
                    break;
            }

            inputData = scanner.nextLine();

        }
    }
}
