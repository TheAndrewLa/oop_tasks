package andrewla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class which performs test of behaviour of {@code Sub} class.
 */
public class SubTest {

    @Test
    void printTest() {
        Sub sub = new Sub(new Number(567), new Number(111));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        sub.print(stream);
        assertEquals("(567-111)", out.toString());

        Sub sub2 = new Sub(sub,
            new Sub(new Number(456), new Sub(new Variable("x"), new Variable("y"))));

        out.reset();

        sub2.print(stream);
        assertEquals("((567-111)-(456-(x-y)))", out.toString());
    }

    @Test
    void evalTest() {
        Sub sub1 = new Sub(new Number(876), new Number(123));
        assertEquals(876 - 123, sub1.eval(""));

        Sub sub2 = new Sub(new Number(1234), new Variable("xyz"));
        assertEquals(1234 - 100, sub2.eval("xyz=100"));

        Sub sub3 = new Sub(sub1,
            new Sub(new Number(456), new Sub(new Variable("x"), new Variable("y"))));

        // (876-123) - (456 - (x - y))
        assertEquals((876 - 123) - (456 - (10 - 12)), sub3.eval("x=10;y=12"));
    }

    @Test
    void derivativeTest() {
        Sub sub = new Sub(new Variable("x"), new Number(100));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        sub.derivative("x").print(stream);
        assertEquals("(1-0)", out.toString());

        out.reset();

        sub.derivative("y").print(stream);
        assertEquals("(0-0)", out.toString());
    }
}
