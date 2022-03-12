package OOP.O4_InterfaceAndAbstraction.E02_03_BirthDate;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Birthable> beings = new ArrayList<>();

        while (!line.equals("End")) {
            String[] input = line.split("\\s+");

            switch (input[0]) {
                case "OOP.О4_InterfacesАndAbstraction.E02_03_BirthDate.OOP.О4_InterfacesАndAbstraction.E04_Food.Citizen":
                    String name = input[1];
                    int age = Integer.parseInt(input[2]);
                    String id = input[3];
                    String birthDate = input[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    beings.add(citizen);
                    break;
                case "OOP.О4_InterfacesАndAbstraction.E02_03_BirthDate.Pet":
                    String namePet = input[1];
                    String birthDatePet = input[2];
                    Pet pet = new Pet(namePet, birthDatePet);
                    beings.add(pet);
                    break;
                case "OOP.О4_InterfacesАndAbstraction.E02_03_BirthDate.Robot":
                    String idRobot = input[1];
                    String model = input[2];
                    Robot robot = new Robot(idRobot, model);
                    break;
            }

            line = scanner.nextLine();
        }

        String searchedYear = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < beings.size(); i++) {
            Birthable currentBeing = beings.get(i);
            if (currentBeing.getBirthDate().endsWith(searchedYear)) {
                System.out.println(currentBeing.getBirthDate());
                count--;
            } else {
                count++;
            }
        }

        if (count > 0) {
            System.out.println("<no output>");
        }
        scanner.close();
    }
}

