package OOP.O4_InterfaceAndAbstraction.E05_SmartPhone;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        List<String> numbers = Arrays.stream(firstLine).collect(Collectors.toList());

        String[] secondLine = scanner.nextLine().split("\\s+");
        List<String> browser = Arrays.stream(secondLine).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(numbers, browser);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}

