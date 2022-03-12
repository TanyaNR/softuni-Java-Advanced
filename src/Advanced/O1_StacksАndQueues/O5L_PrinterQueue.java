package Advanced.O1_StacksАndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class O5L_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String file = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String canceledFile = "";

        while ( ! file.equals("print")) {
            if (file.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    canceledFile = queue.peek();
                    System.out.printf("Canceled %s%n", canceledFile);
                    queue.poll();
                }
            } else {
                queue.offer(file);
            }

            file = scanner.nextLine();
        }
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
