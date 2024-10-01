package andrewla;

import java.io.PrintStream;

public class Number extends Expression {

    /**
     * Constructs a number expression by given value
     *
     * @param value a value
     */
    public Number(int value) {
        this.value = value;
    }

    @Override
    void print(PrintStream stream) {
        stream.print(value);
    }

    @Override
    Expression derivative(String variable) {
        return new Number(0);
    }

    @Override
    int eval(String values) {
        return value;
    }

    private final int value;
}
