package OOP.O4_InterfaceAndAbstraction.O5_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Identifiable> identifiables = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");

            if (inputData.length == 3) {
                String name = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String id = inputData[2];
                Citizen citizen = new Citizen(name, age, id);
                identifiables.add(citizen);
            } else if (inputData.length == 2) {
                String model = inputData[0];
                String id = inputData[1];
                Robot robot = new Robot(id, model);
                identifiables.add(robot);
            }

            input = scanner.nextLine();
        }

        String fakeID = scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(fakeID)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}
