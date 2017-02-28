package DecoratorPattern;

public class BorderDecorator extends Decorator {

    public BorderDecorator(GraphicalComponent next) {
        super(next);
    }

    @Override
    public void paint(){
        System.out.println("render border before");
        super.paint();
        System.out.println("render border after");
    }
}
