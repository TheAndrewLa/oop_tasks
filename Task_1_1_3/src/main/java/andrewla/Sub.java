package andrewla;

public class Sub extends BinaryExpression {

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

