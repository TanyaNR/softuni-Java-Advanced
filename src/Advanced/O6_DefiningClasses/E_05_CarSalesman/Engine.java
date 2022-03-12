package Advanced.O6_DefiningClasses.E_05_CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement = "n/a";
    private String efficiency = "n/a";


    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power, String thirdElement) {
        char firstChar = thirdElement.charAt(0);
        if (Character.isDigit(firstChar)) {
            this.displacement = thirdElement;
        } else {
            this.efficiency = thirdElement;
        }

        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Power: " + power).append("\n").append("Displacement: " + displacement).append("\n")
                .append("Efficiency: " + efficiency);
        return builder.toString();
    }


}
