import ru.innopolis.comicon.stdlib.Boolean;
import ru.innopolis.comicon.stdlib.Integer;
import ru.innopolis.comicon.stdlib.Real;

import static org.junit.Assert.assertEquals;


class IntegerTest {

    @org.junit.jupiter.api.Test
    void createInteger() {
        Integer testInteger = new Integer(10);
        Real testReal = new Real(5.5);

        Integer test = new Integer();
        assertEquals(test.value, 0);

        test = new Integer(testInteger);
        assertEquals(test.value, testInteger.value);

        test = new Integer(testInteger.value);
        assertEquals(test.value, testInteger.value);

        test = new Integer(testReal);
        assertEquals(test.value, testReal.toInteger().value);

        test = new Integer(testReal.value);
        assertEquals(test.value, testReal.toInteger().value);
    }


    @org.junit.jupiter.api.Test
    void maxFunction() {
        Integer test = new Integer(10);
        assertEquals(test.Max().value, java.lang.Integer.MAX_VALUE);
    }


    @org.junit.jupiter.api.Test
    void minFunction() {
        Integer test = new Integer(10);
        assertEquals(test.Min().value, java.lang.Integer.MIN_VALUE);
    }


    @org.junit.jupiter.api.Test
    void toReal() {
        Integer test = new Integer(10);
        Real testReal = new Real(10);
        assertEquals(test.toReal().value, testReal.value);
    }


    @org.junit.jupiter.api.Test
    void toBoolean() {
        Integer test = new Integer();
        Boolean testBoolean = new Boolean();
        assertEquals(test.toBoolean().value, testBoolean.value);

        test = new Integer(1);
        testBoolean = new Boolean(true);
        assertEquals(test.toBoolean().value, testBoolean.value);
    }

    @org.junit.jupiter.api.Test
    void unaryMinus() {
        Integer test = new Integer(10);
        Integer test2 = new Integer(test.value - 1);
        assertEquals(test.UnaryMinus().value, test2.value);
    }

    @org.junit.jupiter.api.Test
    void plus() {
        Integer test = new Integer(10);
        Integer test2 = new Integer(10);
        Real testReal = new Real(10);

        assertEquals(test.Plus(test2).value, test.value + test2.value);
        assertEquals(test.Plus(testReal).value, test.value + testReal.toInteger().value);
        assertEquals(test.Plus(10).value, test.value + 10);
        assertEquals(test.Plus(10.1).value, test.value + 10.1);
    }


    @org.junit.jupiter.api.Test
    void minus() {
        Integer test = new Integer(10);
        Integer test2 = new Integer(10);
        Real testReal = new Real(10);

        assertEquals(test.Minus(test2).value, test.value - test2.value);
        assertEquals(test.Minus(testReal).value, test.value - testReal.toInteger().value);
        assertEquals(test.Minus(10).value, test.value - 10);
        assertEquals(test.Minus(10.1).value, test.value - 10.1);
    }


    @org.junit.jupiter.api.Test
    void mult() {
        Integer test = new Integer(10);
        Integer test2 = new Integer(10);
        Real testReal = new Real(10);

        assertEquals(test.Mult(test2).value, test.value * test2.value);
        assertEquals(test.Mult(testReal).value, test.value * testReal.toInteger().value);
        assertEquals(test.Mult(10).value, test.value * 10);
        assertEquals(test.Mult(10.1).value, test.value * 10.1);
    }

    @org.junit.jupiter.api.Test
    void divide() {
        Integer test = new Integer(10);
        Integer test2 = new Integer(10);
        Real testReal = new Real(10);

        assertEquals(test.Div(test2).value, test.value / test2.value);
        assertEquals(test.Div(testReal).value, test.value / testReal.toInteger().value);
        assertEquals(test.Div(10).value, test.value / 10);
        assertEquals(test.Div(10.1).value, test.value / 10.1);
    }

    @org.junit.jupiter.api.Test
    void remainder() {
        Integer test = new Integer(10);
        Integer test2 = new Integer(10);

        assertEquals(test.Rem(test2).value, test.value % test2.value);
        assertEquals(test.Rem(10).value, test.value % 10);
    }

    @org.junit.jupiter.api.Test
    void less() {
        Integer test = new Integer(10);
        Integer testInteger = new Integer(9);
        Integer testInteger2 = new Integer(11);
        Real testReal = new Real(9.1);
        Real testReal2 = new Real(11.1);

        assertEquals(test.Less(testInteger).value, false);
        assertEquals(test.Less(testInteger2).value, true);

        assertEquals(test.Less(testReal).value, false);
        assertEquals(test.Less(testReal2).value, true);

        assertEquals(test.Less(9).value, false);
        assertEquals(test.Less(11).value, true);

        assertEquals(test.Less(9.1).value, false);
        assertEquals(test.Less(11.1).value, true);
    }

    @org.junit.jupiter.api.Test
    void lessEqual() {
        Integer test = new Integer(10);
        Integer testInteger = new Integer(9);
        Integer testInteger2 = new Integer(11);
        Real testReal = new Real(9.1);
        Real testReal2 = new Real(11.1);

        assertEquals(test.LessEqual(testInteger).value, false);
        assertEquals(test.LessEqual(testInteger2).value, true);
        assertEquals(test.LessEqual(test.value).value, true);

        assertEquals(test.LessEqual(testReal).value, false);
        assertEquals(test.LessEqual(testReal2).value, true);
        assertEquals(test.LessEqual(testReal2.value).value, true);

        assertEquals(test.LessEqual(9).value, false);
        assertEquals(test.LessEqual(11).value, true);

        assertEquals(test.LessEqual(9.1).value, false);
        assertEquals(test.LessEqual(11.1).value, true);
    }

    @org.junit.jupiter.api.Test
    void greater() {
        Integer test = new Integer(10);
        Integer testInteger = new Integer(9);
        Integer testInteger2 = new Integer(11);
        Real testReal = new Real(9.1);
        Real testReal2 = new Real(11.1);

        assertEquals(test.Greater(testInteger).value, true);
        assertEquals(test.Greater(testInteger2).value, false);
        assertEquals(test.Greater(test.value).value, false);

        assertEquals(test.Greater(testReal).value, true);
        assertEquals(test.Greater(testReal2).value, false);
        assertEquals(test.Greater(testReal2.value).value, false);

        assertEquals(test.Greater(9).value, true);
        assertEquals(test.Greater(11).value, false);
        assertEquals(test.Greater(10).value, false);

        assertEquals(test.Greater(9.1).value, true);
        assertEquals(test.Greater(11.1).value, false);
    }

    @org.junit.jupiter.api.Test
    void greaterEqual() {
        Integer test = new Integer(10);
        Integer testInteger = new Integer(9);
        Integer testInteger2 = new Integer(11);
        Real testReal = new Real(9.1);
        Real testReal2 = new Real(11.1);

        assertEquals(test.GreaterEqual(testInteger).value, true);
        assertEquals(test.GreaterEqual(testInteger2).value, false);
        assertEquals(test.GreaterEqual(test.value).value, true);

        assertEquals(test.GreaterEqual(testReal).value, true);
        assertEquals(test.GreaterEqual(testReal2).value, false);
        assertEquals(test.GreaterEqual(testReal2.value).value, false);

        assertEquals(test.GreaterEqual(9).value, true);
        assertEquals(test.GreaterEqual(11).value, false);
        assertEquals(test.GreaterEqual(10).value, true);

        assertEquals(test.GreaterEqual(9.1).value, false);
        assertEquals(test.GreaterEqual(11.1).value, true);
    }

    @org.junit.jupiter.api.Test
    void equal() {
        Integer test = new Integer(10);
        Integer testInteger = new Integer(9);
        Integer testInteger2 = new Integer(11);
        Real testReal = new Real(9.1);
        Real testReal2 = new Real(11.1);

        assertEquals(test.GreaterEqual(testInteger).value, false);
        assertEquals(test.GreaterEqual(testInteger2).value, false);
        assertEquals(test.GreaterEqual(test.value).value, true);

        assertEquals(test.GreaterEqual(testReal).value, false);
        assertEquals(test.GreaterEqual(testReal2).value, false);
        assertEquals(test.GreaterEqual(testReal2.value).value, false);

        assertEquals(test.GreaterEqual(9).value, false);
        assertEquals(test.GreaterEqual(11).value, false);
        assertEquals(test.GreaterEqual(10).value, true);

        assertEquals(test.GreaterEqual(9.1).value, false);
        assertEquals(test.GreaterEqual(11.1).value, false);
        assertEquals(test.GreaterEqual(10.0).value, true);
    }
}