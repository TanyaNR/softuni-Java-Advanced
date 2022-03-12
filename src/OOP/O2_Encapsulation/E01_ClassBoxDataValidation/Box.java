package OOP.O2_Encapsulation.E01_ClassBoxDataValidation;

public class Box {
//    length, width, and height
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea () {
//        Surface Area = 2lw + 2lh + 2wh
        double surfaceArea = 2 * this.length * (this.height + this.width) + 2 * this.width * this.height;
        return surfaceArea;
    }

    public double calculateLateralSurfaceArea () {
//        Lateral Surface Area = 2lh + 2wh
        double lateralSurfaceArea = 2 * this.height * (this.length + this.width);
        return lateralSurfaceArea;
    }

    public double calculateVolume () {
//        Volume = lwh
        double volume = this.length * this.width * this.height;
        return volume;
    }
}
