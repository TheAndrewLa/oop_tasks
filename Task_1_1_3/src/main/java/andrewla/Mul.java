package andrewla;

/**
 * Multiply expression class.
 */
public class Mul extends BinaryExpression {

    /**
     * Constructs {@code multiply} expression by left and right expressions.
     *
     * @param left a left expression
     * @param right a right expression
     */
    public Mul(Expression left, Expression right) {
        super(left, right, '*');
    }

    @Override
    Expression derivative(String variable) {
        return new Add(
            new Mul(left.derivative(variable), right),
            new Mul(right.derivative(variable), left));
    }

    @Override
    int eval(String values) {
        return left.eval(values) * right.eval(values);
    }
}
