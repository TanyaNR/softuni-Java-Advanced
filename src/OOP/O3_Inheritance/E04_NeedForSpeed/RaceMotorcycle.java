package OOP.O3_Inheritance.E04_NeedForSpeed;

public class RaceMotorcycle extends Motorcycle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
