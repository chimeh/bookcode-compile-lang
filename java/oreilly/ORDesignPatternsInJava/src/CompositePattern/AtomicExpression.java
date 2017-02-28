package CompositePattern;

/**
 * Created by Niko on 27/12/2015.
 */
public abstract class AtomicExpression implements Expression {
    private final double value;

    public AtomicExpression(double testValue) {
        this.value = testValue;
    }

    @Override
    public double getValue() {
        return value;
    }
}
