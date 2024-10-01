package andrewla;

import java.io.PrintStream;

public abstract class BinaryExpression extends Expression {

    /**
     * Constructs a binary expression from two expressions
     *
     * @param left left expression
     * @param right right expression
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

    private final char opSign;
    protected final Expression left;
    protected final Expression right;
}
