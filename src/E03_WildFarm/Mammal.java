package E03_WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{

    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }


    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.#");
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(super.getAnimalType())
                .append("[" + super.getAnimalName() + ", ")
                .append(decimalFormat.format(super.getAnimalWeight())).append(", ")
                .append(this.getLivingRegion()).append(", ")
                .append(getFoodEaten())
                .append("]").toString();
    }
}
