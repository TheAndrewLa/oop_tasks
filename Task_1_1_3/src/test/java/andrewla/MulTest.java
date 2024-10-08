package andrewla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class which performs test of behaviour of {@code Mul} class.
 */
public class MulTest {

    @Test
    void printTest() {
        Mul mul = new Mul(new Number(100), new Number(200));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        mul.print(stream);
        assertEquals("(100*200)", out.toString());

        Mul mul2 = new Mul(mul,
            new Mul(new Mul(new Variable("x"), new Variable("y")), new Number(456)));

        out.reset();

        mul2.print(stream);
        assertEquals("((100*200)*((x*y)*456))", out.toString());
    }

    @Test
    void evalTest() {
        Mul mul1 = new Mul(new Number(345), new Number(213));
        assertEquals(345 * 213, mul1.eval(""));

        Mul mul2 = new Mul(new Number(1234), new Variable("xyz"));
        assertEquals(1234 * 100, mul2.eval("xyz=100"));

        Mul add3 = new Mul(mul1, new Mul(new Variable("x"), new Variable("y")));

        assertEquals(345 * 213 * 10 * 12, add3.eval("x=10;y=12"));
    }

    @Test
    void derivativeTest() {
        Mul add = new Mul(new Variable("x"), new Variable("y"));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        add.derivative("x").print(stream);
        assertEquals("((1*y)+(0*x))", out.toString());

        out.reset();

        add.derivative("y").print(stream);
        assertEquals("((0*y)+(1*x))", out.toString());
    }
}
