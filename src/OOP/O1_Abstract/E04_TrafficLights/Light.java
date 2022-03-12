package OOP.O1_Abstract.E04_TrafficLights;

public class Light {
    private Color color;

    public Light(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor() {
        if (getColor() == Color.RED) {
            setColor(Color.valueOf(Color.RED.getChange()));
        } else if (getColor() == Color.GREEN) {
            setColor(Color.valueOf(Color.GREEN.getChange()));
        } else if (getColor() == Color.YELLOW) {
            setColor(Color.valueOf(Color.YELLOW.getChange()));
        }
    }
}
