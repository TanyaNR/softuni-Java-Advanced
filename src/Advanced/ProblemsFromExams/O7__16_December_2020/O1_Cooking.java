package Advanced.ProblemsFromExams.O7__16_December_2020;

import java.util.*;
import java.util.stream.Collectors;

public class O1_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(liquidQueue::offer);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(ingredientsStack::push);

        Map<String, Integer> cookRecipe = new LinkedHashMap<>();
        fillMap(cookRecipe);
        int countBread = 0;
        int countCake = 0;
        int countPastry = 0;
        int countFruitPie = 0;

        while (!liquidQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquidValue = getValue(liquidQueue, ingredientsStack);
            int ingredientsValue = getValue(ingredientsStack, liquidQueue);
            int sum = liquidValue + ingredientsValue;
            String recipeName = "";
            switch (sum) {
                case 25:
                    recipeName = "Bread";
                    putRecipe(cookRecipe, recipeName, countBread);
                    removeValue(liquidQueue, ingredientsStack);
                    countBread++;
                    break;
                case 50:
                    recipeName = "Cake";
                    putRecipe(cookRecipe, recipeName, countCake);
                    removeValue(liquidQueue, ingredientsStack);
                    countCake++;
                    break;
                case 75:
                    recipeName = "Pastry";
                    putRecipe(cookRecipe, recipeName, countPastry);
                    removeValue(liquidQueue, ingredientsStack);
                    countPastry++;
                    break;
                case 100:
                    recipeName = "Fruit Pie";
                    putRecipe(cookRecipe, recipeName, countFruitPie);
                    removeValue(liquidQueue, ingredientsStack);
                    countFruitPie++;
                    break;
                default:
                    notCookedRecipe(liquidQueue, ingredientsStack, ingredientsValue);
            }
        }

        if (countBread > 0 && countCake > 0 && countPastry > 0 && countFruitPie > 0 ) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        printLiquide(liquidQueue);
        printIngredients(ingredientsStack);
        printCookRecipe(cookRecipe);
    }

    private static void fillMap(Map<String, Integer> cookRecipe) {
        cookRecipe.put("Bread", 0);
        cookRecipe.put("Cake", 0);
        cookRecipe.put("Fruit Pie", 0);
        cookRecipe.put("Pastry", 0);
    }

    private static void removeValue(ArrayDeque<Integer> liquidQueue, ArrayDeque<Integer> ingredientsStack) {
        liquidQueue.poll();
        ingredientsStack.pop();
    }

    private static void printCookRecipe(Map<String, Integer> cookRecipe) {
        for (String recipeName : cookRecipe.keySet()) {
            System.out.printf("%s: %d%n", recipeName, cookRecipe.get(recipeName));
        }
    }

    private static void printIngredients(ArrayDeque<Integer> ingredientsStack) {
        if (!ingredientsStack.isEmpty()) {
            System.out.print("Ingredients left: ");
            int firstIngredients = ingredientsStack.pop();
            System.out.print(firstIngredients);
            for (Integer ingredientsValue : ingredientsStack) {
                System.out.print(", " + ingredientsValue);
            }
            System.out.println();
        } else {
            System.out.println("Ingredients left: none");
        }
    }

    private static void printLiquide(ArrayDeque<Integer> liquidQueue) {
        if (!liquidQueue.isEmpty()) {
            System.out.print("Liquids left: ");
            int firstLiquid = liquidQueue.poll();
            System.out.print(firstLiquid);
            for (Integer liquidValue : liquidQueue) {
                System.out.print(", " + liquidValue);
            }
            System.out.println();
        } else {
            System.out.println("Liquids left: none");
        }
    }

    private static void notCookedRecipe(ArrayDeque<Integer> liquidQueue, ArrayDeque<Integer> ingredientsStack, int value) {
        liquidQueue.poll();
        value += 3;
        ingredientsStack.pop();
        ingredientsStack.push(value);
    }

    private static void putRecipe(Map<String, Integer> cookRecipe, String recipeName, int count) {
        count = 0;
        int currentCount = cookRecipe.get(recipeName);
        cookRecipe.put(recipeName, currentCount + 1);
    }

    private static int getValue(ArrayDeque<Integer> firstStack, ArrayDeque<Integer> secondStack) {
        int value = 0;
        if (!firstStack.isEmpty()) {
            value = firstStack.peek();
        }
        return value;
    }
}
