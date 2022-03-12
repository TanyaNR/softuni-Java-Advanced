package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < number; i++) {
            String [] line = scanner.nextLine().split("\\s+");
            String command = line[0];

            if (command.equals("1")) {
                int digit = Integer.parseInt(line[1]);
                stack.push(digit);
            } else {
                if (command.equals("2")) {
                    if ( ! stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (command.equals("3")) {
                    if ( ! stack.isEmpty()) {
                        System.out.println(Collections.max(stack));
                    }
                }
            }
        }
    }
}
