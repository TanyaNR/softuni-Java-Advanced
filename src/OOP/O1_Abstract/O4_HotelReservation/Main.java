package OOP.O1_Abstract.O4_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(inputData[0]);
        int numberOfDay = Integer.parseInt(inputData[1]);
        Season season = Season.valueOf(inputData[2]);
        DiscountType discountType = DiscountType.valueOf(inputData[3]);

        Double finalPrice = PriceCalculator.calculateFinalPrice(pricePerDay, numberOfDay, season, discountType);

        System.out.printf("%.2f", finalPrice);

    }
}
