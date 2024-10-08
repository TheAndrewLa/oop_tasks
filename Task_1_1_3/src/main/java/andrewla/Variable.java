package andrewla;

import java.io.PrintStream;
import java.util.HashMap;

/**
 * Single variable expression class.
 */
public class Variable extends Expression {

    /**
     * Constructs variable expression by variable identifier
     *
     * @param varName a variable name (identifier)
     */
    public Variable(String varName) {
        this.varName = varName;
    }

    @Override
    void print(PrintStream stream) {
        stream.print(varName);
    }

    @Override
    Expression derivative(String variable) {
        if (variable.equals(varName)) {
            return new Number(1);
        }
        else {
            return new Number(0);
        }
    }

    @Override
    int eval(String values) {
        HashMap<String, Integer> valueMap = getValueMap(values);
        return valueMap.get(varName);
    }

    private final String varName;
}
