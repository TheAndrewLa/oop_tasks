package andrewla;

import andrewla.lexer.Lexer;
import andrewla.lexer.TokenType;
import java.io.PrintStream;
import java.util.ArrayList;
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
     * Differentiate an expression and returns derivative. Variable name should satisfy this regexp
     * {@code [a-z]+}
     *
     * @param variable an identifier of variable of differentiation
     * @return an expression which is derivative
     */
    abstract Expression derivative(String variable);

    /**
     * Evaluates expression by variable-value map. Value map is being set in this pattern:
     * "var1=val1;var2=val2;..."
     *
     * @param values a string contains values of variables
     * @return a result of evaluation
     */
    abstract int eval(String values);

    /**
     * Constructs expression by given string. String should be without spaces and contain only
     * numbers, latin symbols, brackets, math signs
     *
     * @param string an expression
     * @return an expression object
     */
    public static Expression fromString(String string) {
        Expression left = null;
        Expression right = null;

        Integer value = null;
        String variable = null;

        char opSign = '\0';

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            TokenType type = Lexer.recognizeToken(ch);

            switch (type) {
                case OperationSign: {
                    assert !(value != null && variable != null);

                    opSign = ch;

                    if (left == null) {
                        left = (value == null) ? new Variable(variable) : new Number(value);
                    }

                    value = null;
                    variable = null;
                }
                break;

                case Digit: {
                    value = (value == null) ? ch - '0' : value * 10 + (ch - '0');
                }
                break;

                case Letter: {
                    variable = (variable == null) ? String.valueOf(ch)
                        : variable.concat(String.valueOf(ch));
                }
                break;

                case OpenBracket: {
                    
                }
                break;

                case CloseBracket: {
                    assert !(left != null && right != null);

                    right = (value == null) ? new Variable(variable) : new Number(value);
                    left = BinaryExpression.createBySign(left, right, opSign);

                    value = null;
                    variable = null;
                }
                break;

                case BadToken:
                default: {
                    throw new IllegalArgumentException(
                        "Bad token in expression!".concat(String.valueOf(ch)));
                }
            }
        }

        return left;
    }

    /**
     * Value map is being set in this pattern: "var1=val1;var2=val2;..."
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
