package OOP.O1_Abstract.O4_HotelReservation;

public class PriceCalculator {

    public static double calculateFinalPrice (double pricePerDay, int numberOfDay,
                                              Season season, DiscountType discountType) {

        double price = pricePerDay * numberOfDay;
        price = price * season.getMultiplied();
        price = price * (100 - discountType.getDiscount()) / 100.0;

        return price;
    }
}
