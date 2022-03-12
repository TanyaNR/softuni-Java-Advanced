package OOP.O2_Encapsulation.E04_PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories () {
        double coefficientFlourType = 0;
        if (this.flourType.equals("White")) {
            coefficientFlourType = 1.5;
        } else if (this.flourType.equals("Wholegrain")){
            coefficientFlourType = 1.0;
        }

        double coefficientBakingTechnique = 0;
        if (this.bakingTechnique.equals("Crispy")) {
            coefficientBakingTechnique = 0.9;
        } else if (this.bakingTechnique.equals("Chewy")) {
            coefficientBakingTechnique = 1.1;
        } else if (this.bakingTechnique.equals("Homemade")){
            coefficientBakingTechnique = 1.0;
        }

        return (2 * this.weight) * coefficientFlourType * coefficientBakingTechnique;
    }
}
