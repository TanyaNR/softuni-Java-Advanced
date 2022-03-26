package E03_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{

    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.#");
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(super.getAnimalType())
                .append("[" + super.getAnimalName() + ", " + this.breed + ", ")
                .append(decimalFormat.format(super.getAnimalWeight())).append(", ")
                .append(super.getLivingRegion()).append(", ")
                .append(super.getFoodEaten())
                .append("]").toString();
    }
}
