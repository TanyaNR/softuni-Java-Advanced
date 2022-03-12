package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class O2L_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");
        ArrayDeque<String> elementStack = new ArrayDeque<>();
        Collections.addAll(elementStack, input);

        while (elementStack.size() != 1) {
            int first = Integer.parseInt(elementStack.pop());
            String operator = elementStack.pop();
            int second = Integer.parseInt(elementStack.pop());

            if (operator.equals("+")) {
                int result = first + second;
                elementStack.push(String.valueOf(result));
            } else {
                int result = first - second;
                elementStack.push(String.valueOf(result));
            }
        }

        System.out.println(elementStack.peek());
    }
}
