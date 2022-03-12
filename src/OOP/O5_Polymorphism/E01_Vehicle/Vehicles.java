package OOP.O5_Polymorphism.E01_Vehicle;

import java.text.DecimalFormat;

public class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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
        this.fuelQuantity += litters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
