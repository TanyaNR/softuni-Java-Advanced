package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queue::push);
        System.out.println();
        String output = queue.stream().map(e -> String.valueOf(e))
                .collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
