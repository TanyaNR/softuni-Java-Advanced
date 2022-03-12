package OOP.O5_Polymorphism.E01_Vehicle;

public class Truck extends Vehicles{

    final static double AIR_CONDITIONER_CONSUMPTION = 1.6;
    final static double FUEL_LEAK_CONSTANT = 0.05;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    public void refueling(double litters) {
        litters = litters * (1 - FUEL_LEAK_CONSTANT);
        super.refueling(litters);
    }
}
