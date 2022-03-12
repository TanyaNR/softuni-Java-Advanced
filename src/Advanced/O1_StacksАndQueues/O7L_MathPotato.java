package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class O7L_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        Collections.addAll(childrenQueue, input);
        int count = Integer.parseInt(scanner.nextLine());
        int cycleCount = 1;

        while (childrenQueue.size() > 1) {
            for (int i = 1; i < count; i++) {
                childrenQueue.offer(childrenQueue.poll());
            }

            if (isPrime(cycleCount)) {
                System.out.printf("Prime %s%n", childrenQueue.peek());
            } else {
                System.out.printf("Removed %s%n", childrenQueue.poll());
            }

            cycleCount ++;
        }

        System.out.println("Last is " + childrenQueue.peek());
    }

    private static boolean isPrime(int cycleCount) {
        if (cycleCount == 1) {
            return false;
        }  else if (cycleCount == 2){
            return true;
        }

        for (int i = 2; i <= cycleCount / 2; i++) {
            if (cycleCount % i == 0) {
                return false;
            }
        }
        return true;
    }
}
