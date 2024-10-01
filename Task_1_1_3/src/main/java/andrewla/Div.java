package andrewla;

public class Div extends BinaryExpression {

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
