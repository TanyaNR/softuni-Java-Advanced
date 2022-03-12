package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();
        ArrayDeque<Character> openedBracketStack = new ArrayDeque<>();
        Boolean isBalance = false;

        for (int i = 0; i < parentheses.length(); i++) {
            char p = parentheses.charAt(i);
            if (p == '(' || p == '{' || p == '[') {
                openedBracketStack.push(p);
            } else {
                if (openedBracketStack.isEmpty()) {
                    isBalance = false;
                    break;
                }

                char open = openedBracketStack.pop();
                if (open == '(' && p == ')') {
                    isBalance = true;
                } else if (open == '{' && p == '}') {
                    isBalance = true;
                } else if (open == '[' && p == ']') {
                    isBalance = true;
                } else {
                    isBalance = false;
                    break;
                }
            }
        }
        if (isBalance) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
