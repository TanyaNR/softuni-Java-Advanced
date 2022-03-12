package Advanced.O6_DefiningClasses.E_05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> enginesList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] engineData = input.split("\\s+");

            String model = engineData[0];
            String power = engineData[1];

            Engine engine;
            if (engineData.length == 2) {
                engine = new Engine(model, power);
            } else if (engineData.length == 3) {
                String thirdElement = engineData[2];
                engine = new Engine(model, power, thirdElement);
            } else {
                String displacement = engineData[2];
                String efficiency = engineData[3];
                engine = new Engine(model, power, displacement, efficiency);
            }

            enginesList.add(engine);
        }

        int n2 = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < n2; i++) {
            String input = scanner.nextLine();
            String[] carData = input.split("\\s+");

            String model = carData[0];
            String engineModel = carData[1];

            Car car;
            if (carData.length == 2) {
                car = new Car (model, engineModel);
            } else if (carData.length == 3) {
                String thirdElement = carData[2];
                car = new Car (model, engineModel, thirdElement);
            } else {
                String weight = carData[2];
                String color = carData[3];
                car = new Car (model, engineModel, weight, color);
            }

            carsList.add(car);
        }
        //{CarModel}:
        //{EngineModel}:
//Power: {EnginePower}
//Displacement: {EngineDisplacement}
//Efficiency: {EngineEfficiency}
//Weight: {CarWeight}
//Color: {CarColor}

        for (Car car : carsList) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngineModel() + ":");
            for (Engine engine : enginesList) {
                if (car.getEngineModel().equals(engine.getModel())) {
                    System.out.println(engine.toString());
                }
            }
            System.out.println(car.toString());
        }
    }
}
