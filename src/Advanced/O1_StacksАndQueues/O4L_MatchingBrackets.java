package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class O4L_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {
            char ch = expression.charAt(index);
            if (ch == '(') {
                stack.push(index);
            } else if (ch == ')') {
                int startIndex = stack.pop();
                String extract = expression.substring(startIndex, index + 1);
                System.out.println(extract);
            }
        }
    }
}
