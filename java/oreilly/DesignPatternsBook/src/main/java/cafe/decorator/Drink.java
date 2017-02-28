package cafe.decorator;

public abstract class Drink {

    String description = "Unknown drink";

    Size size;

    public abstract double cost();

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
