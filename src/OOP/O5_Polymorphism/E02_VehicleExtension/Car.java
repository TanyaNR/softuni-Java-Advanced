package OOP.O5_Polymorphism.E02_VehicleExtension;

public class Car extends Vehicles{

    final static double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION, tankCapacity);
    }



}
