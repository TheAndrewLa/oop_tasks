package andrewla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Performs testing of {@code Variable} and {@code Value} classes
 */
public class VarValTest {

    @Test
    void valueTest() {
        Number number = new Number(123);

        assertEquals(123, number.eval(""));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        number.print(stream);
        assertEquals("123", out.toString());

        out.reset();

        number.derivative("").print(stream);
        assertEquals("0", out.toString());
    }

    @Test
    void variableTest() {
        Variable variable = new Variable("x");

        assertEquals(123, variable.eval("x=123"));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        variable.derivative("x").print(stream);
        assertEquals("1", out.toString());

        out.reset();

        variable.derivative("xx").print(stream);
        assertEquals("0", out.toString());
    }
}
