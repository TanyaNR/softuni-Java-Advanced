package Advanced.ProblemsFromExams.O4__26_June_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class O1_OsPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(", ");
        String[] secondLine = scanner.nextLine().split("\\s+");
        int searchedTask = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();

        Arrays.stream(firstLine).map(Integer::parseInt).forEach(taskStack::push);
        Arrays.stream(secondLine).map(Integer::parseInt).forEach(threadQueue::offer);

        while (!threadQueue.isEmpty()) {
            int threadValue = threadQueue.peek();
            int taskValue = taskStack.peek();
            if (taskValue == searchedTask) {
                System.out.printf("Thread with value %d killed task %d%n", threadValue, searchedTask);
                break;
            }

            if (threadValue >= taskValue) {
                threadQueue.poll();
                taskStack.pop();
            } else {
                threadQueue.poll();
            }
        }

        for (Integer thread : threadQueue) {
            System.out.print(thread + " ");
        }
    }
}
