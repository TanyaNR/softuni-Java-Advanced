package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class O6L_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");
        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, input);
        int count = Integer.parseInt(scanner.nextLine());

        while (children.size() > 1) {
            for (int i = 1; i < count; i++) {
                children.offer(children.poll());
            }
            System.out.printf("Removed %s%n", children.peek());
            children.poll();
        }
        System.out.printf("Last is %s%n", children.peek());
    }
}
