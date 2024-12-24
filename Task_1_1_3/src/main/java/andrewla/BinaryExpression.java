package andrewla;

import java.io.PrintStream;

/**
 * Abstract binary expression class.
 */
public abstract class BinaryExpression extends Expression {

    /**
     * Constructs a binary expression from two expressions
     *
     * @param left   left expression
     * @param right  right expression
     * @param opSign sign of operation
     */
    public BinaryExpression(Expression left, Expression right, char opSign) {
        this.left = left;
        this.right = right;
        this.opSign = opSign;
    }

    @Override
    public void print(PrintStream stream) {
        stream.print('(');
        left.print(stream);
        stream.print(opSign);
        right.print(stream);
        stream.print(')');
    }

    abstract Expression derivative(String variable);

    abstract int eval(String values);

    /**
     * Creates any binary expression by operation sign. Throws exception if operation sign is
     * illegal
     *
     * @param left  a left expression
     * @param right a right expression
     * @param sign  a sign of operation
     * @return an expression
     */
    public static BinaryExpression createBySign(Expression left, Expression right, char sign) {
        switch (sign) {
            case '+':
                return new Add(left, right);

            case '-':
                return new Sub(left, right);

            case '*':
                return new Mul(left, right);

            case '/':
                return new Div(left, right);

            default:
                throw new IllegalArgumentException("Bad sign of operation!");
        }
    }

    private final char opSign;
    protected final Expression left;
    protected final Expression right;
}
