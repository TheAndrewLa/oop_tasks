package andrewla;

public class Add extends BinaryExpression {

    /**
     * Constructs {@code add} expression by left and right expressions.
     *
     * @param left a left expression
     * @param right a right expression
     */
    public Add(Expression left, Expression right) {
        super(left, right, '+');
    }

    @Override
    Expression derivative(String variable) {
        return new Add(left.derivative(variable), right.derivative(variable));
    }

    @Override
    int eval(String values) {
        return left.eval(values) + right.eval(values);
    }
}
