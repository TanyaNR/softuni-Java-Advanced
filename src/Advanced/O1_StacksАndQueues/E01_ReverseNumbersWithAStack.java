package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbersStack = new ArrayDeque<>();

        for (String s : input) {
            numbersStack.push(s);
        }

        while (!numbersStack.isEmpty()) {
            for (String s : numbersStack) {
                System.out.print(numbersStack.pop() + " ");
            }
        }
    }
}
