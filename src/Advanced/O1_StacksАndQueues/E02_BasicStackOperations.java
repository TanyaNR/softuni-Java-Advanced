package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numbersStack.push(scanner.nextInt());
        }

        for (int i = 0; i < s; i++) {
            numbersStack.pop();
        }

        if (numbersStack.contains(x)) {
            System.out.println("true");
        } else if ( ! numbersStack.isEmpty()){
            System.out.println(Collections.min(numbersStack));
        } else {
            System.out.println(0);
        }
    }
}
