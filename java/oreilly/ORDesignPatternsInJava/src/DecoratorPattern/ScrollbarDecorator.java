package DecoratorPattern;

public class ScrollbarDecorator extends Decorator{

    public ScrollbarDecorator(GraphicalComponent next) {
        super(next);
    }

    @Override
    public void paint(){
        System.out.println("render scrollbar");
        super.paint();
    }
}
