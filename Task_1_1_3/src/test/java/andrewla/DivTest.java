package andrewla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class which performs test of behaviour of {@code Div} class.
 */
public class DivTest {

    @Test
    void printTest() {
        Div add = new Div(new Number(56789), new Number(123));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        add.print(stream);
        assertEquals("(56789/123)", out.toString());

        Div add2 = new Div(new Number(789), new Div(new Variable("x"), new Variable("y")));

        out.reset();

        add2.print(stream);
        assertEquals("(789/(x/y))", out.toString());
    }

    @Test
    void evalTest() {
        Div add1 = new Div(new Number(876), new Number(123));
        assertEquals(876 / 123, add1.eval(""));

        Div add2 = new Div(new Number(1234), new Variable("hoho"));
        assertEquals(1234 / 437, add2.eval("hoho=437"));
    }

    @Test
    void derivativeTest() {
        Div add = new Div(new Mul(new Variable("x"), new Variable("y")), new Number(100));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        add.derivative("x").print(stream);
        assertEquals("(((((1*y)+(0*x))*100)-(0*(x*y)))/(100*100))", out.toString());

        out.reset();

        add.derivative("y").print(stream);
        assertEquals("(((((0*y)+(1*x))*100)-(0*(x*y)))/(100*100))", out.toString());
    }
}
