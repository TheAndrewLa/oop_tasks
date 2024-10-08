package andrewla.lexer;

import java.util.Map;

/**
 * A helper class with lexing functions.
 *
 */
public class Lexer {

    /**
     * Returns type of token
     *
     * @param c char
     * @return an enum with all allowed type of tokens
     */
    public static TokenType recognizeToken(char c) {
        if (c >= '0' && c <= '9') {
            return TokenType.Digit;
        } else if (c >= 'a' && c <= 'z') {
            return TokenType.Letter;
        }

        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return TokenType.OperationSign;

            case '(':
                return TokenType.OpenBracket;

            case ')':
                return TokenType.CloseBracket;
        }

        return TokenType.BadToken;
    }
}
