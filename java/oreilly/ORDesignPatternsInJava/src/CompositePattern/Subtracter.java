package CompositePattern;

/**
 * Created by Niko on 26/12/2015.
 */
public class Subtracter extends BinaryExpression {
     public Subtracter(Expression left, Expression right) {
      super(left, right);
    }

    @Override
    public double getValue() {
        return this.left.getValue() - this.right.getValue();
    }
}
