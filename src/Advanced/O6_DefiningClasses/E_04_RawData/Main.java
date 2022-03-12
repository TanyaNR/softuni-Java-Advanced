package Advanced.O6_DefiningClasses.E_04_RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Car>> cargoTypeMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            double tire1Pressure = Double.parseDouble(carData[5]);
            int tire1Age = Integer.parseInt(carData[6]);
            double tire2Pressure = Double.parseDouble(carData[7]);
            int tire2Age = Integer.parseInt(carData[8]);
            double tire3Pressure = Double.parseDouble(carData[9]);
            int tire3Age = Integer.parseInt(carData[10]);
            double tire4Pressure = Double.parseDouble(carData[11]);
            int tire4Age = Integer.parseInt(carData[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                    tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            if (cargoType.equals("fragile")) {
                if (!cargoTypeMap.containsKey(cargoType)) {
                    cargoTypeMap.put(cargoType, new ArrayList<>());
                    cargoTypeMap.get(cargoType).add(car);
                } else {
                    cargoTypeMap.get(cargoType).add(car);
                }

            } else {
                if (!cargoTypeMap.containsKey(cargoType)) {
                    cargoTypeMap.put(cargoType, new ArrayList<>());
                    cargoTypeMap.get(cargoType).add(car);
                } else {
                    cargoTypeMap.get(cargoType).add(car);
                }
            }
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            printModelFragile(cargoTypeMap, command);
        } else {
            printModelFlamable(cargoTypeMap, command);
        }
    }

    private static void printModelFragile(Map<String, List<Car>> cargoTypeMap, String command) {
        List<Car> carList = cargoTypeMap.get(command);
        for (Car car : carList) {
            if (car.getTire1Pressure() < 1 || car.getTire2Pressure() < 1 || car.getTire3Pressure() < 1 || car.getTire4Pressure() < 1) {
                System.out.println(car.getModel());
            }
        }
    }

    private static void printModelFlamable(Map<String, List<Car>> cargoTypeMap, String command) {
        List<Car> carList = cargoTypeMap.get(command);
        for (Car car : carList) {
            if (car.getEnginePower() > 250) {
                System.out.println(car.getModel());
            }
        }
    }
}
