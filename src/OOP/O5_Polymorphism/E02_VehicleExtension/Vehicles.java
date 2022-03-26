package OOP.O5_Polymorphism.E02_VehicleExtension;

import java.text.DecimalFormat;

public class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;

    public Vehicles(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String driving(double distance) {
        double fuelNeeded = fuelConsumption * distance;
        if (fuelNeeded > fuelQuantity) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        this.fuelQuantity -= fuelNeeded;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
    }

    public void refueling(double litters) {
        if (litters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        if (litters > tankCapacity - fuelQuantity) {
            System.out.println("Cannot fit fuel in tank" );
            return;
        }

        this.fuelQuantity += litters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
