package Advanced.ProblemsFromExams.O2__23_October_2021;

import java.util.*;

public class O1_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split("\\s+");
        String[] second = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();

        Arrays.stream(first).map(Integer::parseInt).forEach(ingredientsQueue::offer);
        Arrays.stream(second).map(Integer::parseInt).forEach(freshnessStack::push);
        Map<String, Integer> cocktails = new TreeMap<>();
        int countPear = 0;
        int countHarvest = 0;
        int countApple = 0;
        int countFashion = 0;

        while ( !ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredientsValue = ingredientsQueue.peek();
            int freshnessValue = freshnessStack.peek();
            int neededValue = ingredientsValue * freshnessValue;

            String nameCocktail = "";

            if (ingredientsValue == 0) {
                ingredientsQueue.poll();
            }

            if (neededValue != 150 && neededValue != 250 && neededValue != 300 && neededValue != 400 && ingredientsValue != 0) {
                ingredientsQueue.poll();
                freshnessStack.pop();
                ingredientsQueue.offer(ingredientsValue + 5);
            }


            switch (neededValue) {
                case 150:
                    nameCocktail = "Pear Sour";
                    countPear++;
                    addCocktails(cocktails, ingredientsQueue, freshnessStack, nameCocktail);
                    break;
                case 250:
                    nameCocktail = "The Harvest";
                    countHarvest++;
                    addCocktails(cocktails, ingredientsQueue, freshnessStack, nameCocktail);
                    break;
                case 300:
                    nameCocktail = "Apple Hinny";
                    countApple++;
                    addCocktails(cocktails, ingredientsQueue, freshnessStack, nameCocktail);
                    break;
                case 400:
                    nameCocktail = "High Fashion";
                    countFashion++;
                    addCocktails(cocktails, ingredientsQueue, freshnessStack, nameCocktail);
                    break;
            }

        }


        if (countApple != 0 && countFashion != 0 && countPear != 0 && countHarvest !=0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()) {
            int sum = 0;
            for (Integer integer : ingredientsQueue) {
                sum += integer;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        //" # {cocktail name} --> {amount}"
        if (!cocktails.isEmpty()) {
            for (Map.Entry<String, Integer> stringIntegerEntry : cocktails.entrySet()) {
                System.out.printf(" # %s --> %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            }
        }
    }



    private static void addCocktails(Map<String, Integer> cocktails, ArrayDeque<Integer> firstStack, ArrayDeque<Integer> secondStack, String nameCocktail) {
        if (cocktails.containsKey(nameCocktail)) {
            int currentCount = cocktails.get(nameCocktail);
            currentCount++;
            cocktails.put(nameCocktail, currentCount);
        } else {
            cocktails.putIfAbsent(nameCocktail, 1);
        }
        firstStack.pop();
        secondStack.pop();
    }
}
