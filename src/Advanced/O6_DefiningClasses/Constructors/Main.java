package Advanced.O6_DefiningClasses.Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<Car> carsConstructor = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            Car car;
            if (carInfo.length == 1) {
                car = new Car(carInfo[0]);
            } else {
                car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
            }
            carsConstructor.add(car);
        }
        carsConstructor.forEach(car -> System.out.printf("The car is: %s %s - %d HP.%n",
                car.getBrand(),
                car.getModel(),
                car.getHorsePower()));
    }
}
