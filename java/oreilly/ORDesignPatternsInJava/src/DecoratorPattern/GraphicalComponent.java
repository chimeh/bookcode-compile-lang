package DecoratorPattern;

public interface GraphicalComponent {
    public void paint();
    public GraphicalComponent addContent(Object content);
}
