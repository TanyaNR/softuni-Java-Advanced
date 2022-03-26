package OOP.O5_Polymorphism.E02_VehicleExtension;

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

        token = scanner.nextLine().split("\\s+");
        Vehicles bus = createdVehicle(token);

        vehiclesMap.put("OOP.O5_Polymorphism.E02_VehicleExtension.Car", car);
        vehiclesMap.put("OOP.O5_Polymorphism.E02_VehicleExtension.Truck", truck);
        vehiclesMap.put("OOP.O5_Polymorphism.E02_VehicleExtension.Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehiclesType = tokens[1];

            switch (commandName) {
                case"Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    Vehicles vehicles = vehiclesMap.get(vehiclesType);
                    if (vehicles instanceof Bus) {
                        bus.setFuelConsumption(bus.getFuelConsumption() + Bus.AIR_CONDITIONER_CONSUMPTION);
                        System.out.println(bus.driving(distance));
                        bus.setFuelConsumption(bus.getFuelConsumption() - Bus.AIR_CONDITIONER_CONSUMPTION);
                        continue;
                    }
                    String driveMessage = vehiclesMap.get(vehiclesType).driving(distance);
                    System.out.println(driveMessage);
                    break;
                case "Refuel":
                    double flueAmount = Double.parseDouble(tokens[2]);
                    vehiclesMap.get(vehiclesType).refueling(flueAmount);
                    break;
                case "DriveEmpty":
                    double distanceDriveEmpty = Double.parseDouble(tokens[2]);
                    String driveEmptyMessage = vehiclesMap.get(vehiclesType).driving(distanceDriveEmpty);
                    System.out.println(driveEmptyMessage);
                    break;
            }
        }

        vehiclesMap.values().forEach(System.out::println);
    }

    private static Vehicles createdVehicle(String[] token) {
        String vehicleType = token[0];
        double fuelQuantity = Double.parseDouble(token[1]);
        double fuelConsumption = Double.parseDouble(token[2]);
        int tankCapacity = Integer.parseInt(token[3]);

        Vehicles vehicles = null;
        switch (vehicleType) {
            case "OOP.O5_Polymorphism.E02_VehicleExtension.Car":
                vehicles = new Car (fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "OOP.O5_Polymorphism.E02_VehicleExtension.Truck":
                vehicles = new Truck (fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "OOP.O5_Polymorphism.E02_VehicleExtension.Bus":
                vehicles = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                break;
        }

        return vehicles;
    }
}
