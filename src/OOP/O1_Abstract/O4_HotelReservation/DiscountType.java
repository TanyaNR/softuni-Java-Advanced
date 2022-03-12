package OOP.O1_Abstract.O4_HotelReservation;

public enum DiscountType {
    VIP (20),
    SecondVisit (10),
    None (0);

    private int discount;

    DiscountType(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
