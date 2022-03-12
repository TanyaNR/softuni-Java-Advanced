package Advanced.O6_DefiningClasses.E_05_CarSalesman;

import java.util.List;

public class Car {
    private String model;
    private String engineModel;
    private String weight = "n/a";
    private String color = "n/a";

    public Car(String model, String engineModel) {
        this.model = model;
        this.engineModel = engineModel;
    }

    public Car(String model, String engineModel, String weight, String color) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, String engineModel, String thirdElement) {
        char firstChar = thirdElement.charAt(0);
        if (Character.isDigit(firstChar)) {
            this.weight = thirdElement;
        } else {
            this.color = thirdElement;
        }

        this.model = model;
        this.engineModel = engineModel;
    }

    public String getModel() {
        return model;
    }

    public String getEngineModel() {
        return engineModel;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Weight: " + weight).append("\n").append("Color: " + color);
        return builder.toString();
    }
}
