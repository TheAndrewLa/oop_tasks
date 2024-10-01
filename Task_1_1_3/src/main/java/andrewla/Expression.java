package andrewla;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Expression {

    /**
     * Printing expression
     *
     * @param stream a stream where print occurs
     */
    abstract void print(PrintStream stream);

    /**
     * Differentiate an expression and returns derivative
     * TODO: convention of variable name
     *
     * @param variable an identifier of variable of differentiation
     * @return a expression which is derivative
     */
    abstract Expression derivative(String variable);

    /**
     * Evaluates expression by variable-value map
     * TODO: convention of value map
     *
     * @param values a string contains values of variables
     * @return a result of evaluation
     */
    abstract int eval(String values);

    /**
     * TODO: convention of value map
     *
     * @param values a string with variable signification
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
            }

            i++;

            while (i < record.length()) {
                value.append(record.charAt(i));
            }

            map.put(name.toString(), Integer.valueOf(value.toString()));
        }

        return map;
    }
}
