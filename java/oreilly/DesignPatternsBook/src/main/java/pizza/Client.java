package pizza;

public class Client {

    public static void main(String[] args) {

        Pizzeria italian = new ItalianPizzeria();
        Pizzeria american = new AmericanPizzeria();

        Pizza pizza = italian.orderPizza("cheese");
        pizza = american.orderPizza("cheese");
    }
}
