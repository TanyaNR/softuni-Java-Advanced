package Advanced.ProblemsFromExams.O8__19_August_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class O1_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(rosesQueue::offer);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);

        int sum = 0;
        int countWreath = 0;
        int storyWreath = 0;

        while (!rosesQueue.isEmpty() && !liliesStack.isEmpty()) {
            int rosesValue = takeValue(rosesQueue, liliesStack);
            int liliesValue = takeValue(liliesStack, rosesQueue);
            sum = rosesValue + liliesValue;
            if (sum == 15) {
                countWreath++;
                removeValue(rosesQueue, liliesStack);
            } else if (sum < 15) {
                storyWreath += sum;
                removeValue(rosesQueue, liliesStack);
            } else {
                decreaseValue(rosesQueue, liliesStack);
            }
        }

        int allWreath = countWreath + (storyWreath / 15);
        if (allWreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", countWreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - allWreath);
        }
    }

    private static void decreaseValue(ArrayDeque<Integer> rosesQueue, ArrayDeque<Integer> liliesStack) {
        int value = liliesStack.pop() - 2;
        liliesStack.push(value);
    }

    private static void removeValue(ArrayDeque<Integer> rosesQueue, ArrayDeque<Integer> liliesStack) {
        rosesQueue.poll();
        liliesStack.pop();
    }


    private static int takeValue(ArrayDeque<Integer> firstStack, ArrayDeque<Integer> secondStack) {
        int value = 0;
        if (!firstStack.isEmpty()) {
            value = firstStack.peek();
        }
        return value;
    }
}
