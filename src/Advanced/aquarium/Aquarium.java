package Advanced.aquarium;

import java.util.LinkedHashSet;
import java.util.Set;

public class Aquarium {
    private Set<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashSet<>(capacity);
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {
        boolean isHaveSameFish = false;
        for (Fish fish1 : this.fishInPool) {
            if (fish1.getName().equals(fish.getName())) {
                isHaveSameFish = true;
            }
        }
        if (!isHaveSameFish && getFishInPool() < getCapacity()) {
                this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        Fish removedFish = null;
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                removedFish = fish;
            }
        }
        if (removedFish == null) {
            return false;
        } else {
            this.fishInPool.remove(removedFish);
            return true;
        }
    }

    public String findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish.getName();
            }
        }
        return null;
    }

    //"Aquarium: {name} ^ Size: {size}
    //{Fish1}
    //{Fish2}
    //…".
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size)).append(System.lineSeparator());
        for (Fish fish : this.fishInPool) {
            stringBuilder.append(fish.toString());
        }
        return stringBuilder.toString();
    }
}
