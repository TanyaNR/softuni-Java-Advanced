import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();

        String[] token = scanner.nextLine().split("\\s+");
        Vehicles car = createdVehicle(token);

        token = scanner.nextLine().split("\\s+");
        Vehicles truck = createdVehicle(token);

        vehiclesMap.put("Car", car);
        vehiclesMap.put("Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehiclesType = tokens[1];

            switch (commandName) {
                case"Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    String driveMessage = vehiclesMap.get(vehiclesType).driving(distance);
                    System.out.println(driveMessage);
                    break;
                case "Refuel":
                    double flueAmount = Double.parseDouble(tokens[2]);
                    vehiclesMap.get(vehiclesType).refueling(flueAmount);
                    break;
            }
        }

        vehiclesMap.values().forEach(System.out::println);
    }

    private static Vehicles createdVehicle(String[] token) {
        String vehicleType = token[0];
        double fuelQuantity = Double.parseDouble(token[1]);
        double fuelConsumption = Double.parseDouble(token[2]);

        Vehicles vehicles = null;
        switch (vehicleType) {
            case "Car":
                vehicles = new Car (fuelQuantity, fuelConsumption);
                break;
            case "Truck":
                vehicles = new Truck (fuelQuantity, fuelConsumption);
                break;
        }

        return vehicles;
    }
}
