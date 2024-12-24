package andrewla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class which performs test of behaviour of {@code Add} class.
 */
public class AddTest {

    @Test
    void printTest() {
        Add add = new Add(new Number(123), new Number(123));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        add.print(stream);
        assertEquals("(123+123)", out.toString());

        Add add2 = new Add(add,
            new Add(new Number(456), new Add(new Variable("x"), new Variable("y"))));

        out.reset();

        add2.print(stream);
        assertEquals("((123+123)+(456+(x+y)))", out.toString());
    }

    @Test
    void evalTest() {
        Add add1 = new Add(new Number(123), new Number(876));
        assertEquals(123 + 876, add1.eval(""));

        Add add2 = new Add(new Number(1234), new Variable("xyz"));
        assertEquals(1234 + 100, add2.eval("xyz=100"));

        Add add3 = new Add(add1,
            new Add(new Number(456), new Add(new Variable("x"), new Variable("y"))));

        assertEquals(123 + 876 + 456 + 10 + 12, add3.eval("x=10;y=12"));
    }

    @Test
    void derivativeTest() {
        Add add = new Add(new Variable("x"), new Number(100));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        add.derivative("x").print(stream);
        assertEquals("(1+0)", out.toString());

        out.reset();

        add.derivative("y").print(stream);
        assertEquals("(0+0)", out.toString());
    }
}
