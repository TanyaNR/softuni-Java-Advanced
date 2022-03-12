package Advanced.dealership;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latestCar = null;
        int latest = MIN_VALUE;
        for (Car car : this.data) {
            if (car.getYear() > latest) {
                latest = car.getYear();
                latestCar = car;
            }
        }
        if (latestCar == null) {
            return null;
        } else {
            return latestCar;
        }
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are in a car dealership %s:", getName())).append(System.lineSeparator());                ;
        for (Car car : this.data) {
            builder.append(car).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
