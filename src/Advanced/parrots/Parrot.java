package Advanced.parrots;

public class Parrot {
//    •	name: String
//•	species: String
//•	available: boolean - true by default
//The class constructor should receive (name, species).
    private String name;
    private String species;
    private boolean available = true;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
//        "Parrot ({species}): {name}"
        return String.format("Parrot (%s): %s", this.species, this.name);
    }
}
