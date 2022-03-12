package OOP.O2_Encapsulation.E03_ShoppingSpree;

public class Product {
    //fields
    private String name;
    private double cost;

    //methods
    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            //isEmpty
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setCost(double cost) {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }

    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
