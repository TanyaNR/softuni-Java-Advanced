package Advanced.ProblemsFromExams.O3__18_August_2021;

import java.util.*;

public class O1_Pastry_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> pastryShop = new LinkedHashMap<>();
        pastryShop.put("Biscuit", 0);
        pastryShop.put("Cake", 0);
        pastryShop.put("Pie", 0);
        pastryShop.put("Pastry", 0);
        String[] inputFirstRaw = scanner.nextLine().split("\\s+");
        String[] inputSecondRow = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(inputFirstRaw).mapToInt(Integer::parseInt).forEach(liquidsQueue::offer);
        Arrays.stream(inputSecondRow).mapToInt(Integer::parseInt).forEach(ingredientsStack::push);

        int size = liquidsQueue.size();

        while (liquidsQueue.size() > 0 || ingredientsStack.size() > 0) {
            int liquidValue;
            int ingredientsValue;
            try {
                liquidValue = getValue(liquidsQueue, ingredientsStack);
                ingredientsValue = getValue(ingredientsStack, ingredientsStack);
            } catch (NullPointerException exception) {
                break;
            }
            int foodValue = liquidValue + ingredientsValue;
            String foodsName = "";
            if (foodValue != 25 && foodValue != 50 && foodValue != 75 && foodValue != 100) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                ingredientsValue += 3;
                ingredientsStack.push(ingredientsValue);
            }
            if (foodValue == 25) {
                foodsName = "Biscuit";
                adjustFood(liquidsQueue, ingredientsStack, foodsName, pastryShop);
            } else if (foodValue == 50) {
                foodsName = "Cake";
                adjustFood(liquidsQueue, ingredientsStack, foodsName, pastryShop);
            } else if (foodValue == 75) {
                foodsName = "Pie";
                adjustFood(liquidsQueue, ingredientsStack, foodsName, pastryShop);
            } else if (foodValue == 100) {
                foodsName = "Pastry";
                adjustFood(liquidsQueue, ingredientsStack, foodsName, pastryShop);
            }
        }

        int sumValue = 0;
        for (Integer value : pastryShop.values()) {
            sumValue += value;
        }

        if (sumValue >= 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        printLiguide(liquidsQueue);

        printIngredients(ingredientsStack);

        for (Map.Entry<String, Integer> stringIntegerEntry : pastryShop.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + ": " + stringIntegerEntry.getValue());
        }

    }


    private static void printIngredients(ArrayDeque<Integer> ingredientsStack) {
        if (ingredientsStack.isEmpty()) {
            System.out.print("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            int firstIngredients = ingredientsStack.pop();
            System.out.print(firstIngredients);
            ingredientsStack.forEach((ingredients) -> System.out.print(", " + ingredients));
        }
        System.out.println();
    }

    private static void printLiguide(ArrayDeque<Integer> liquidsQueue) {
        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            int firstLiquid = liquidsQueue.pop();
            System.out.print(firstLiquid);
            liquidsQueue.forEach((liquide) -> System.out.print(", " + liquide));
        }
    }

    private static int getValue(ArrayDeque<Integer> firstStack, ArrayDeque<Integer> secondStack) {
        int firstNumber;
        try {
            firstNumber = firstStack.peek();
        } catch (NullPointerException exception) {
            throw exception;
        }

        return firstNumber;
    }

    public static void adjustFood(ArrayDeque<Integer> liquidsQueue, ArrayDeque<Integer> ingredientsStack,
                                  String nameFood, Map<String, Integer> pastryShop) {
        int count = pastryShop.get(nameFood) + 1;
        pastryShop.put(nameFood, count);
        liquidsQueue.poll();
        ingredientsStack.pop();
    }
}
