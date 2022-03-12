package OOP.O2_Encapsulation.E04_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int numberOfTopping = Integer.parseInt(pizzaData[2]);
        Pizza pizza = new Pizza(pizzaName, numberOfTopping);

        String[] doughData = scanner.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double weightInGrams = Double.parseDouble(doughData[3]);
        Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);

        pizza.setDought(dough);

        String toppingData = scanner.nextLine();
        while ( !toppingData.equals("END")) {
            String toppingType = toppingData.split("\\s+")[1];
            double weightInGramsTopping = Double.parseDouble(toppingData.split("\\s+")[2]);
            Topping topping = new Topping(toppingType, weightInGramsTopping);
            pizza.addTopping(topping);

            toppingData = scanner.nextLine();
        }

        System.out.println(pizza.getName() + " - " + pizza.getOverallCalories());
    }
}
