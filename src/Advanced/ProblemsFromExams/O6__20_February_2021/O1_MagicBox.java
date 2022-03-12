package Advanced.ProblemsFromExams.O6__20_February_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class O1_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondMagicBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondMagicBoxStack::push);

        int sumClaimedItems = 0;
        while (!firstMagicBoxQueue.isEmpty() && !secondMagicBoxStack.isEmpty()) {
            int firstMagicValue = getValue(firstMagicBoxQueue, secondMagicBoxStack);
            int secondMagicValue = getValue(secondMagicBoxStack, firstMagicBoxQueue);
            int sum = firstMagicValue + secondMagicValue;
            if (sum % 2 == 0) {
                sumClaimedItems += sum;
                firstMagicBoxQueue.poll();
                secondMagicBoxStack.pop();
            } else {
                firstMagicBoxQueue.offer(secondMagicValue);
                secondMagicBoxStack.pop();
            }
        }

        if (firstMagicBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondMagicBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (sumClaimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", sumClaimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d", sumClaimedItems);
        }
    }

    private static int getValue(ArrayDeque<Integer> firstMagicBoxStack, ArrayDeque<Integer> secondMagicBoxStack) {
        int magicValue = 0;
        if (!firstMagicBoxStack.isEmpty()) {
            try {
                magicValue = firstMagicBoxStack.peek();
            } catch (NullPointerException e) {
                throw new NullPointerException("magicValue is not valid");
            }
        }
        return magicValue;
    }
}
