package andrewla;

/**
 * Division expression class.
 */
public class Div extends BinaryExpression {

    /**
     * Constructs {@code divide} expression by left and right expressions.
     *
     * @param left a left expression
     * @param right a right expression
     */
    public Div(Expression left, Expression right) {
        super(left, right, '/');
    }

    @Override
    Expression derivative(String variable) {
        Expression numerator = new Sub(
            new Mul(left.derivative(variable), right),
            new Mul(right.derivative(variable), left));

        Expression denominator = new Mul(right, right);

        return new Div(numerator, denominator);
    }

    @Override
    int eval(String values) {
        return left.eval(values) / right.eval(values);
    }
}
