package Advanced.dealership;

public class Main {

    public static void main(String[] args) {
// Initialize the repository
        Dealership dealership = new Dealership("Autofest", 5);

// Initialize entity
        Car volvo = new Car("Volvo", "XC70", 2010);

// Print OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.OOP.О4_InterfacesАndAbstraction.O6_Ferrari.OOP.O4_InterfaceAndAbstraction.E05_SmartPhone___55.OOP.O5_Polimorphism.E01_Vehicle.OOP.O5_Polymorphism.E02_VehicleExtension.Car
        System.out.println(volvo); // Volvo XC70 (2010)

// Add OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.OOP.О4_InterfacesАndAbstraction.O6_Ferrari.OOP.O4_InterfaceAndAbstraction.E05_SmartPhone___55.OOP.O5_Polimorphism.E01_Vehicle.OOP.O5_Polymorphism.E02_VehicleExtension.Car
        dealership.add(volvo);

// Remove OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.OOP.О4_InterfacesАndAbstraction.O6_Ferrari.OOP.O4_InterfaceAndAbstraction.E05_SmartPhone___55.OOP.O5_Polimorphism.E01_Vehicle.OOP.O5_Polymorphism.E02_VehicleExtension.Car
        System.out.println(dealership.buy("Volvo", "XC90")); // false
        System.out.println(dealership.buy("Volvo", "XC70")); // true

        Car peugeot = new Car("Peugeot", "307", 2011);
        Car audi = new Car("OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.Audi", "S4", 2005);

        dealership.add(peugeot);
        dealership.add(audi);

// Get Latest OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.OOP.О4_InterfacesАndAbstraction.O6_Ferrari.OOP.O4_InterfaceAndAbstraction.E05_SmartPhone___55.OOP.O5_Polimorphism.E01_Vehicle.OOP.O5_Polymorphism.E02_VehicleExtension.Car
        Car latestCar = dealership.getLatestCar();
        System.out.println(latestCar); // Peugeot 307 (2011)

// Get OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.OOP.О4_InterfacesАndAbstraction.O6_Ferrari.OOP.O4_InterfaceAndAbstraction.E05_SmartPhone___55.OOP.O5_Polimorphism.E01_Vehicle.OOP.O5_Polymorphism.E02_VehicleExtension.Car
        Car audiS4 = dealership.getCar("OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.Audi", "S4");
        System.out.println(audiS4); // OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.Audi S4 (2005)

// Count
        System.out.println(dealership.getCount()); // 2

// Get Statistics
        System.out.println(dealership.getStatistics());
// The cars are in a car dealership Autofest:
// Peugeot 307 (2011)
// OOP.О4_InterfacesАndAbstraction.O1_2_CarShop.Audi S4 (2005)
    }
}
