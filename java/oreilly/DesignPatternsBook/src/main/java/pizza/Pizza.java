package pizza;

import pizza.additions.*;

import java.util.Arrays;

public abstract class Pizza {

    String name;
    Base base;
    Sauce sauce;
    Vegetable vegetables[];
    Cheese cheese;
    Pepperoni pepperoni;
    Chili chili;

    abstract void prepare();

    public void bake(){
        System.out.println("Pizza is baked for 25 minutes");
    }

    public void cut(){
        System.out.println("Pizza is cut into 8 pieces");
    }

    public void pack(){
        System.out.println("Pizza is packed");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", base=" + base +
                ", sauce=" + sauce +
                ", vegetables=" + Arrays.toString(vegetables) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", chili=" + chili +
                '}';
    }
}
