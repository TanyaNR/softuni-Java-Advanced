package OOP.O4_InterfaceAndAbstraction.O6_Ferrari;

public class Ferrari implements Car{
    private String driverName;
    private final String model = "488-Spider";
    private final String brakes = "Brakes!";
    private final String gas = "brum-brum-brum-brrrrr";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return this.brakes;
    }

    @Override
    public String gas() {
        return this.gas;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.model, this.brakes, this.gas, this.driverName);
    }
}
