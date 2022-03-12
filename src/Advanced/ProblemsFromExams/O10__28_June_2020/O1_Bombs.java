package Advanced.ProblemsFromExams.O10__28_June_2020;

import java.util.*;

public class O1_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split(",\\s+");
        String[] second = scanner.nextLine().split(",\\s+");

        ArrayDeque<Integer> firstBombEffectQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBombCasingStack = new ArrayDeque<>();

        Arrays.stream(first).map(Integer::parseInt).forEach(firstBombEffectQueue::offer);
        Arrays.stream(second).map(Integer::parseInt).forEach(secondBombCasingStack::push);

        Map<String, Integer> bombPouch = new TreeMap<>();
        bombPouch.put("Datura Bombs", 0);
        bombPouch.put("Cherry Bombs", 0);
        bombPouch.put("Smoke Decoy Bombs", 0);
        int countDatura = 0;
        int countCherry = 0;
        int countSmoke = 0;

        while ( !firstBombEffectQueue.isEmpty() && !secondBombCasingStack.isEmpty()) {
            int firstValue = firstBombEffectQueue.peek();
            int secondValue = secondBombCasingStack.peek();
            int sum = firstValue + secondValue;
            String nameBomb = "";

            switch (sum) {
                case 40:
                    nameBomb = "Datura Bombs";
                    countDatura++;
                    addBombInPouch(bombPouch, firstBombEffectQueue, secondBombCasingStack, nameBomb);
                    break;
                case 60:
                    nameBomb = "Cherry Bombs";
                    countCherry++;
                    addBombInPouch(bombPouch, firstBombEffectQueue, secondBombCasingStack, nameBomb);
                    break;
                case 120:
                    nameBomb = "Smoke Decoy Bombs";
                    countSmoke++;
                    addBombInPouch(bombPouch, firstBombEffectQueue, secondBombCasingStack, nameBomb);
                    break;

            }

            if (sum != 40 && sum != 60 && sum != 120) {
                secondBombCasingStack.pop();
                secondBombCasingStack.push(secondValue - 5);
            }

            if (countCherry >= 3 && countDatura >= 3 && countSmoke >= 3) {
                break;
            }
        }

        if (countCherry >= 3 && countDatura >= 3 && countSmoke >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (firstBombEffectQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            printBombEffect(firstBombEffectQueue);
        }

        if (secondBombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            printBombCasing(secondBombCasingStack);
        }

        printBombPouch(bombPouch);

    }

    private static void printBombPouch(Map<String, Integer> bombPouch) {
        for (Map.Entry<String, Integer> stringIntegerEntry : bombPouch.entrySet()) {
            System.out.printf("%s: %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }

    private static void printBombCasing(ArrayDeque<Integer> firstStack) {
        int firstBombEffect = firstStack.pop();
        System.out.print("Bomb Casings: " + firstBombEffect);
        for (Integer integer : firstStack) {
            System.out.print(", " + integer);
        }
        System.out.println();
    }

    private static void printBombEffect(ArrayDeque<Integer> firstStack) {
        // "Bomb Effects: {bombEffect1}, {bombEffect2}, (…)"

        int firstBombEffect = firstStack.pop();
        System.out.print("Bomb Effects: " + firstBombEffect);
        for (Integer integer : firstStack) {
            System.out.print(", " + integer);
        }
        System.out.println();
    }

    private static void addBombInPouch(Map<String, Integer> bombPouch, ArrayDeque<Integer> firstStack, ArrayDeque<Integer> secondStack, String nameBomb) {
            int currentCount = bombPouch.get(nameBomb);
            currentCount++;
            bombPouch.put(nameBomb, currentCount);

        firstStack.pop();
        secondStack.pop();
    }
}
