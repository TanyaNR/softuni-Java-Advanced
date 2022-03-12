package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class O8L_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String instruction = scanner.nextLine();
        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        while ( ! instruction.equals("Home")) {
            if (instruction.equals("back")) {
                if (backStack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    forwardStack.push(backStack.pop());
                    System.out.println(backStack.peek());
                }

            } else if (instruction.equals("forward")) {
                if (forwardStack.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardStack.peek());
                    backStack.push(forwardStack.pop());
                }

            } else {
                backStack.push(instruction);
                forwardStack.clear();
                System.out.println(backStack.peek());
            }

            instruction = scanner.nextLine();
        }
    }
}
