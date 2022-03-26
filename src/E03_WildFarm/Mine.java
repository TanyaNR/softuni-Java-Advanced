package E03_WildFarm;

import java.util.*;

public class Mine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Animal> allAnimals = new ArrayList<>();

        while ( !input.equals("End")) {
            String[] animalData = input.split("\\s+");
            Animal animal = createAnimal(animalData);

            String[] eatData = scanner.nextLine().split("\\s+");
            Food food = getFood(eatData);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            allAnimals.add(animal);
            input = scanner.nextLine();
        }

        allAnimals.stream().forEach(System.out::println);
    }

    private static Food getFood(String[] eatData) {
        Integer quantity = Integer.parseInt(eatData[1]);
        if (eatData[0].equals("E03_WildFarm.Meat")) {
            return new Meat(quantity);
        } else if (eatData[0].equals("E03_WildFarm.Vegetable")) {
            return new Vegetable(quantity);
        } else {
            throw new IllegalArgumentException("No such food");
        }
    }

    private static Animal createAnimal(String[] animalData) {
        String animalType = animalData[0];
        String animalName = animalData[1];
        Double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];

        switch (animalType) {
            case "E03_WildFarm.Cat":
                String breed = animalData[4];
                return new Cat(animalType, animalName, animalWeight, animalLivingRegion, breed);
            case "E03_WildFarm.Tiger":
                return new Tiger(animalType, animalName, animalWeight, animalLivingRegion);
            case "E03_WildFarm.Mouse":
                return new Mouse(animalType, animalName, animalWeight, animalLivingRegion);
            case "E03_WildFarm.Zebra":
                return new Zebra(animalType, animalName, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}
