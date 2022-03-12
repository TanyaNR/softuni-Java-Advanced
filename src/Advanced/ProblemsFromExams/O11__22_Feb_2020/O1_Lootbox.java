package Advanced.ProblemsFromExams.O11__22_Feb_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class O1_Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split("\\s+");
        String[] second = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        Arrays.stream(first).map(Integer::parseInt).forEach(firstBoxQueue::offer);
        Arrays.stream(second).map((Integer::parseInt)).forEach(secondBoxStack::push);

        int allSum = 0;
        int sum = 0;

        while ( !firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstItem = firstBoxQueue.peek();
            int secondItem = secondBoxStack.peek();
            sum = firstItem + secondItem;

            if (sum % 2 == 0) {
                allSum += sum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                secondBoxStack.pop();
                firstBoxQueue.offer(firstItem);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (allSum >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", allSum);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", allSum);
        }
     }
}
