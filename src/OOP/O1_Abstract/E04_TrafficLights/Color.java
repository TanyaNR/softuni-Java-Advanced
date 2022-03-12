package OOP.O1_Abstract.E04_TrafficLights;

public enum Color {
    RED ("GREEN"),
    YELLOW ("RED"),
    GREEN ("YELLOW");

    private String change;

    Color(String change) {
        this.change = change;
    }

    public String getChange() {
        return change;
    }
}
