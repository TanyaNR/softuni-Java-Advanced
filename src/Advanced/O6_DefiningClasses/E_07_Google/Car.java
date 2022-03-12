package Advanced.O6_DefiningClasses.E_07_Google;

public class Car {

    //car {carModel} {carSpeed}
    private String carModel;
    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return carModel + " " + carSpeed;
    }
}
