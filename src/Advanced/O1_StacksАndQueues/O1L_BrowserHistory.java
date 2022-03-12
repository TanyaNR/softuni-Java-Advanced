package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class O1L_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String instruction = scanner.nextLine();
        ArrayDeque<String> browser = new ArrayDeque<>();
        String current = "";

        while ( ! instruction.equals("Home")) {
            if (instruction.equals("back")) {
                if (browser.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    browser.pop();
                    current = browser.peek();
                    System.out.println(current);
                }
            } else {
                browser.push(instruction);
                current = browser.peek();
                System.out.println(current);
            }

            instruction = scanner.nextLine();
        }
    }
}
