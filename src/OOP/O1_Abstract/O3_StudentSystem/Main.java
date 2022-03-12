package OOP.O1_Abstract.O3_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();
        String[] input = scanner.nextLine().split(" ");
        String command = input[0];
        while (! command.equals("Exit")) {
            studentSystem.executeCommand(input);

            input = scanner.nextLine().split(" ");
            command = input[0];
        }
    }
}
