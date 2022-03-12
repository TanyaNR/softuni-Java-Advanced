package OOP.O2_Encapsulation.E04_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dought;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setToppings(int count) {
        if (count >= 0 && count <= 10) {
            this.toppings = new ArrayList<>(count);
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    private void setName(String name) {
        if (name.trim().length() >= 1 && name.trim().length() <= 15) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public void setDought(Dough dought) {
        this.dought = dought;
    }

    public String getName() {
        return name;
    }

    public void addTopping (Topping toping) {
        this.toppings.add(toping);
    }

    public double getOverallCalories () {
        return this.dought.calculateCalories() + this.toppings.stream().mapToDouble(t -> t.calculateCalories()).sum();
    }
}
