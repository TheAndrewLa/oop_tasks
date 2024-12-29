package andrewla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Performs testing of Expression::fromString method.
 */
public class FromStringTest {

    @Test
    void test() {
        Expression exp = Expression.fromString("(1+2)*((xy*yz)+678)");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        exp.print(stream);

        assertEquals("(1+2)*((xy*yz)+678)", out.toString());
    }
}
