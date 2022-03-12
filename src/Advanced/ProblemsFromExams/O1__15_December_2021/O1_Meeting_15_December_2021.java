package Advanced.ProblemsFromExams.O1__15_December_2021;

import java.util.*;

public class O1_Meeting_15_December_2021 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] males = scanner.nextLine().split("\\s+");
        String[] females = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays.stream(males).mapToInt(Integer::parseInt).forEach(malesStack::push);
        Arrays.stream(females).mapToInt(Integer::parseInt).forEach(femalesQueue::offer);

        int matches = 0;
        while (!femalesQueue.isEmpty() && !malesStack.isEmpty()) {
            int malesValue;
            int femalesValue;
            try {
                malesValue = getGenderValue(malesStack, femalesQueue);
                femalesValue = getGenderValue(femalesQueue, malesStack);
            } catch (NoGenderException exception) {
                break;
            }

            if (malesValue == femalesValue) {
                matches++;
                malesStack.pop();
                femalesQueue.pop();
            } else {
                femalesQueue.pop();
                int currentNumber = malesValue;
                malesStack.pop();
                currentNumber -= 2;
                malesStack.push(currentNumber);
            }
        }

        System.out.printf("Matches: %d%n",matches);
        if (malesStack.isEmpty()) {
            System.out.printf("Males left: none%n");
        } else {
            System.out.print("Males left: ");

            int firstMale = malesStack.pop();
            System.out.print(firstMale);
            if (!malesStack.isEmpty()) {
                malesStack.forEach((male) -> System.out.print(", " + male));
            }
            System.out.println();
        }

        if (femalesQueue.isEmpty()) {
            System.out.printf("Females left: none%n");
        } else {
            System.out.print("Females left: ");
            int firstFemale = femalesQueue.pop();
            System.out.print(firstFemale);
            if (!femalesQueue.isEmpty()) {
                femalesQueue.forEach((female) -> System.out.print(", " + female));
            }
        }
    }

    private static int getGenderValue(ArrayDeque<Integer> firstStack, ArrayDeque<Integer> secondStack) throws NoGenderException {
        int firstNumber;
        try {
            firstNumber = firstStack.peek();
        } catch (NullPointerException exception) {
            throw new NoGenderException();
        }

        if (firstNumber <= 0) {
            firstStack.pop();
            return getGenderValue(firstStack, secondStack);
        } else if (firstNumber % 25 == 0) {
            try {
                firstStack.pop();
                firstStack.pop();
            } catch (NoSuchElementException exception) {
                throw new NoGenderException();
            }

            return getGenderValue(firstStack, secondStack);
        }

        return firstNumber;
    }
}

