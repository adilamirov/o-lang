import ru.innopolis.comicon.stdlib.Boolean;
import ru.innopolis.comicon.stdlib.Real;
import ru.innopolis.comicon.stdlib.Integer;

import static org.junit.Assert.assertEquals;


class RealTest {

    @org.junit.jupiter.api.Test
    void createReal() {
        Real test = new Real();
        Real testReal = new Real(5.5);
        Integer testInteger = new Integer(5);

        assertEquals(test.value, (double) 0);
        assertEquals(testReal.value, 5.5);

        test = new Real(testReal);
        assertEquals(test.value, testReal.value);

        test = new Real(testInteger);
        assertEquals(test.value, testInteger.toReal().value);

        test = new Real(5);
        assertEquals(test.value, (double) 5);
    }

    @org.junit.jupiter.api.Test
    void maxFeature() {
        Real test = new Real();
        assertEquals(test.Max().value, Double.MAX_VALUE);
    }

    @org.junit.jupiter.api.Test
    void minFeature() {
        Real test = new Real();
        assertEquals(test.Min().value, Double.MIN_VALUE);
    }

    @org.junit.jupiter.api.Test
    void epsilonFeature() {
        Real test = new Real();
        assertEquals(test.Epsilon().value, Math.ulp(1));
    }

    @org.junit.jupiter.api.Test
    void toInteger() {
        Real test = new Real(10);
        assertEquals(test.toInteger().value, 10);
    }

    @org.junit.jupiter.api.Test
    void unaryMinus() {
        Real test = new Real(10);
        assertEquals(test.UnaryMinus().value, test.value - 1);
    }

    @org.junit.jupiter.api.Test
    void plus() {
        Real test = new Real(1);
        Real testReal = new Real(9);
        Integer testInteger = new Integer(9);

        assertEquals(test.Plus(testReal).value, test.value + testReal.value);
        assertEquals(test.Plus(testInteger).value, test.value + testInteger.toReal().value);
        assertEquals(test.Plus(9).value, test.value + 9);
        assertEquals(test.Plus(9.0).value, test.value + 9.0);
    }

    @org.junit.jupiter.api.Test
    void minus() {
        Real test = new Real(1);
        Real testReal = new Real(9);
        Integer testInteger = new Integer(9);

        assertEquals(test.Minus(testReal).value, test.value - testReal.value);
        assertEquals(test.Minus(testInteger).value, test.value - testInteger.toReal().value);
        assertEquals(test.Minus(9).value, test.value - 9);
        assertEquals(test.Minus(9.0).value, test.value - 9.0);
    }

    @org.junit.jupiter.api.Test
    void mult() {
        Real test = new Real(1);
        Real testReal = new Real(9);
        Integer testInteger = new Integer(9);

        assertEquals(test.Mult(testReal).value, test.value * testReal.value);
        assertEquals(test.Mult(testInteger).value, test.value * testInteger.toReal().value);
        assertEquals(test.Mult(9).value, test.value * 9);
        assertEquals(test.Mult(9.0).value, test.value * 9.0);
    }

    @org.junit.jupiter.api.Test
    void divide() {
        Real test = new Real(1);
        Real testReal = new Real(9);
        Integer testInteger = new Integer(9);

        assertEquals(test.Div(testReal).value, test.value / testReal.value);
        assertEquals(test.Div(testInteger).value, test.value / testInteger.toReal().value);
        assertEquals(test.Div(9).value, test.value / 9);
        assertEquals(test.Div(9.0).value, test.value / 9.0);
    }

    @org.junit.jupiter.api.Test
    void remainder() {
        Real test = new Real(1);
        Integer testInteger = new Integer(9);

        assertEquals(test.Rem(testInteger).value, test.value / testInteger.toReal().value);
        assertEquals(test.Rem(9).value, test.value / 9);
    }

    @org.junit.jupiter.api.Test
    void Less() {
        Real test = new Real(10);
        Real test1 = new Real(9);
        Real test2 = new Real(11);

        Integer testInt = new Integer(9);
        Integer testInt1 = new Integer(10);
        Integer testInt2 = new Integer(11);


        assertEquals(test.Less(test1).value, false);
        assertEquals(test.Less(test).value, false);
        assertEquals(test.Less(test2).value,  true);

        assertEquals(test.Less(testInt).value, false);
        assertEquals(test.Less(testInt1).value, false);
        assertEquals(test.Less(testInt2).value,  true);

        assertEquals(test.Less(9).value, false);
        assertEquals(test.Less(10).value, false);
        assertEquals(test.Less(11).value,  true);

        assertEquals(test.Less(9.0).value, false);
        assertEquals(test.Less(10.0).value, false);
        assertEquals(test.Less(11.0).value,  true);
    }

    @org.junit.jupiter.api.Test
    void LessEqual() {
        Real test = new Real(10);
        Real test1 = new Real(9);
        Real test2 = new Real(11);

        Integer testInt = new Integer(9);
        Integer testInt1 = new Integer(10);
        Integer testInt2 = new Integer(11);


        assertEquals(test.LessEqual(test1).value, false);
        assertEquals(test.LessEqual(test).value, false);
        assertEquals(test.LessEqual(test2).value, true);

        assertEquals(test.LessEqual(testInt).value, false);
        assertEquals(test.LessEqual(testInt1).value, true);
        assertEquals(test.LessEqual(testInt2).value, true);

        assertEquals(test.LessEqual(9).value, false);
        assertEquals(test.LessEqual(10).value, true);
        assertEquals(test.LessEqual(11).value, true);

        assertEquals(test.LessEqual(9.0).value, false);
        assertEquals(test.LessEqual(10.0).value, true);
        assertEquals(test.LessEqual(11.0).value, true);
    }

    @org.junit.jupiter.api.Test
    void Greater() {
        Real test = new Real(10);
        Real test1 = new Real(9);
        Real test2 = new Real(11);

        Integer testInt = new Integer(9);
        Integer testInt1 = new Integer(10);
        Integer testInt2 = new Integer(11);


        assertEquals(test.Greater(test1).value, true);
        assertEquals(test.Greater(test).value, false);
        assertEquals(test.Greater(test2).value, false);

        assertEquals(test.Greater(testInt).value, true);
        assertEquals(test.Greater(testInt1).value, false);
        assertEquals(test.Greater(testInt2).value, false);

        assertEquals(test.Greater(9).value, true);
        assertEquals(test.Greater(10).value, false);
        assertEquals(test.Greater(11).value, false);

        assertEquals(test.Greater(9.0).value, true);
        assertEquals(test.Greater(10.0).value, false);
        assertEquals(test.Greater(11.0).value, false);
    }

    @org.junit.jupiter.api.Test
    void GreaterEqual() {
        Real test = new Real(10);
        Real test1 = new Real(9);
        Real test2 = new Real(11);

        Integer testInt = new Integer(9);
        Integer testInt1 = new Integer(10);
        Integer testInt2 = new Integer(11);


        assertEquals(test.GreaterEqual(test1).value, true);
        assertEquals(test.GreaterEqual(test).value, true);
        assertEquals(test.GreaterEqual(test2).value, false);

        assertEquals(test.GreaterEqual(testInt).value, true);
        assertEquals(test.GreaterEqual(testInt1).value, true);
        assertEquals(test.GreaterEqual(testInt2).value, false);

        assertEquals(test.GreaterEqual(9).value, true);
        assertEquals(test.GreaterEqual(10).value, true);
        assertEquals(test.GreaterEqual(11).value, false);

        assertEquals(test.GreaterEqual(9.0).value, true);
        assertEquals(test.GreaterEqual(10.0).value, true);
        assertEquals(test.GreaterEqual(11.0).value, false);
    }

    @org.junit.jupiter.api.Test
    void Equal() {
        Real test = new Real(10);
        Real test1 = new Real(9);
        Real test2 = new Real(11);

        Integer testInt = new Integer(9);
        Integer testInt1 = new Integer(10);
        Integer testInt2 = new Integer(11);


        assertEquals(test.Equal(test1).value, false);
        assertEquals(test.Equal(test).value, true);
        assertEquals(test.Equal(test2).value, false);

        assertEquals(test.Equal(testInt).value, false);
        assertEquals(test.Equal(testInt1).value, true);
        assertEquals(test.Equal(testInt2).value, false);

        assertEquals(test.Equal(9).value, false);
        assertEquals(test.Equal(10).value, true);
        assertEquals(test.Equal(11).value, false);

        assertEquals(test.Equal(9.0).value, false);
        assertEquals(test.Equal(10.0).value, true);
        assertEquals(test.Equal(11.0).value, false);
    }
}