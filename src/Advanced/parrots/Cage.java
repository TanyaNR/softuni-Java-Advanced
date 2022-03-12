package Advanced.parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Cage {
//    •	name: String
//•	capacity: int
    List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        Parrot toRemove = null;
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                toRemove = parrot;
            }
        }
        if (toRemove != null) {
            return this.data.remove(toRemove);
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = this.data.stream().filter(singleParrot -> singleParrot.getName().equals(name) && singleParrot.isAvailable()).findFirst().get();
        parrot.setAvailable(false);
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> removedParrot = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                removedParrot.add(parrot);
            }
        }

        Predicate<Parrot> removedParrotWithTheSameSpecies = parrot -> parrot.getSpecies().equals(species);
        this.data.removeIf(removedParrotWithTheSameSpecies);
        Parrot[] removedParrotArr = new Parrot[removedParrot.size()];
        return removedParrot; //.toArray(removedParrotArr);
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
//        o	"Parrots available at {cageName}:
//{Parrot 1}
//{Parrot 2}
//(…)"
        StringBuilder builder = new StringBuilder();
        builder.append("Parrots available at " + getName() + ":").append(System.lineSeparator());
        for (Parrot parrot : data) {
            builder.append(parrot).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
