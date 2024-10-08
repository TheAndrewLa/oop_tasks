package andrewla;

/**
 * Subtraction expression class.
 */
public class Sub extends BinaryExpression {

    /**
     * Constructs {@code subtract} expression by left and right expressions.
     *
     * @param left a left expression
     * @param right a right expression
     */
    public Sub(Expression left, Expression right) {
        super(left, right, '-');
    }

    @Override
    Expression derivative(String variable) {
        return new Sub(left.derivative(variable), right.derivative(variable));
    }

    @Override
    int eval(String values) {
        return left.eval(values) - right.eval(values);
    }
}

