package Advanced.O6_DefiningClasses.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String brand = carInfo[0];
            String model = carInfo[1];
            int horsePower = Integer.parseInt(carInfo[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsepower(horsePower);

            carsList.add(car);
        }

        carsList.forEach(car -> System.out.printf("The car is: %s %s - %d HP.%n", car.getBrand(), car.getModel(), car.getHorsepower()));
    }
}
