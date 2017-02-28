package cafe.decorator;

public abstract class Garnish extends Drink{

    @Override
    public abstract String getDescription();

    @Override
    public abstract Size getSize();
}
