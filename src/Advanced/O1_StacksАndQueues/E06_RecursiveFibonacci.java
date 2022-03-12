package Advanced.O1_StacksАndQueues;

import java.util.Scanner;

public class E06_RecursiveFibonacci {
    public static long [] memoryForFib;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memoryForFib = new long[n + 1];
        System.out.println(fib(n));

    }

    public static long fib (int n) {
        if (n <= 1) {
            return 1;
        }
        if (memoryForFib[n] != 0) {
            return memoryForFib[n];
        } else {
            memoryForFib[n] = fib(n-1) + fib(n-2);
        }
        return fib(n-1) + fib(n-2);
    }
}
