package CompositePattern;

/**
 * Created by Niko on 26/12/2015.
 */
public class Adder extends BinaryExpression {

    public Adder(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double getValue() {
        return this.left.getValue() + this.right.getValue();
    }
}
