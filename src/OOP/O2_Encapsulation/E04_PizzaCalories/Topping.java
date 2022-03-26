package OOP.O2_Encapsulation.E04_PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "E03_WildFarm.Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
    }

    public double calculateCalories () {
        double coefficientTopingType = 0;
        if (this.toppingType.equals("E03_WildFarm.Meat")) {
            coefficientTopingType = 1.2;
        } else if (this.toppingType.equals("Veggies")) {
            coefficientTopingType = 0.8;
        } else if (this.toppingType.equals("Cheese")) {
            coefficientTopingType = 1.1;
        } else if (this.toppingType.equals("MeatSauce")) {
            coefficientTopingType = 0.9;
        }

        return 2 * this.weight * coefficientTopingType;
    }
}
