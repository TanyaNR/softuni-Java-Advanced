package OOP.O1_Abstract.O4_HotelReservation;

public enum Season {
    Autumn (1),
    Spring (2),
    Winter (3),
    Summer (4);

    private int multiplied;

    Season(int multiplied) {
        this.multiplied = multiplied;
    }

    public int getMultiplied() {
        return multiplied;
    }
}
