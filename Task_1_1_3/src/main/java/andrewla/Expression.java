package andrewla;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Abstract expression class.
 */
public abstract class Expression {

    /**
     * Printing expression.
     *
     * @param stream a stream where print occurs
     */
    abstract void print(PrintStream stream);

    /**
     * Differentiate an expression and returns derivative.
     * Variable name should satisfy this regexp {@code [a-z]+}
     *
     * @param variable an identifier of variable of differentiation
     * @return an expression which is derivative
     */
    abstract Expression derivative(String variable);

    /**
     * Evaluates expression by variable-value map.
     * Value map is being set in this pattern:
     * "var1=val1;var2=val2;..."
     *
     * @param values a string contains values of variables
     * @return a result of evaluation
     */
    abstract int eval(String values);

    /**
     * Value map is being set in this pattern:
     * "var1=val1;var2=val2;..."
     *
     * @param values a string with value map
     * @return a hashmap with variable names as key and variable value as value
     */
    protected static HashMap<String, Integer> getValueMap(String values) {
        HashMap<String, Integer> map = new HashMap<>();

        Scanner scan = new Scanner(values);
        scan.useDelimiter(";");

        while (scan.hasNext()) {
            String record = scan.next();

            StringBuilder name = new StringBuilder();
            StringBuilder value = new StringBuilder();

            int i = 0;
            while (record.charAt(i) != '=') {
                name.append(record.charAt(i));
                i++;
            }

            i++;

            while (i < record.length()) {
                value.append(record.charAt(i));
                i++;
            }

            map.put(name.toString(), Integer.valueOf(value.toString()));
        }

        return map;
    }
}
