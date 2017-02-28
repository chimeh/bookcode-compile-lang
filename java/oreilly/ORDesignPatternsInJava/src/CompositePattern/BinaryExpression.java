package CompositePattern;

/**
 * Created by Niko on 26/12/2015.
 */
public abstract class BinaryExpression implements Expression {
    protected Expression left;
    protected Expression right;

    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

}
