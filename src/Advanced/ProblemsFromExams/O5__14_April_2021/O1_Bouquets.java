package Advanced.ProblemsFromExams.O5__14_April_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class O1_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tulipsLine = scanner.nextLine().split(", ");
        String[] daffodilsLine = scanner.nextLine().split(", ");

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        Arrays.stream(tulipsLine).map(Integer::parseInt).forEach(tulipsStack::push);
        Arrays.stream(daffodilsLine).map(Integer::parseInt).forEach(daffodilsQueue::offer);
        int bouquetsCounter = 0;
        int storyFlowers = 0;
        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int tulipValue = getFlowerValue(tulipsStack, daffodilsQueue);
            int daffodilsValue = getFlowerValue(daffodilsQueue, tulipsStack);
            int flowersSum = tulipValue + daffodilsValue;

            if (flowersSum == 15) {
                bouquetsCounter++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (flowersSum > 15) {
                tulipsStack.pop();
                tulipsStack.push(tulipValue - 2);
            } else {
                tulipsStack.pop();
                daffodilsQueue.poll();
                storyFlowers += flowersSum;
            }
        }

        int allBouquets = (storyFlowers / 15) + bouquetsCounter;
        if (allBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", allBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", 5 - allBouquets);        }
    }


    private static int getFlowerValue(ArrayDeque<Integer> firstStack, ArrayDeque<Integer> secondStack) {
        int tulipValue = 0;
        if (!firstStack.isEmpty()) {
            tulipValue = firstStack.peek();
        }
        return tulipValue;
    }
}
