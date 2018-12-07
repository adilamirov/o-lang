import ru.innopolis.comicon.stdlib.Boolean;
import Integer;
import ru.innopolis.comicon.stdlib.Real;

import static org.junit.Assert.assertEquals;


class BooleanTest {

    @org.junit.jupiter.api.Test
    void createBoolean() {
        Boolean test = new Boolean();
        Boolean test2 = new Boolean();

        assertEquals(test.value, false);

        test = new Boolean(test2);
        assertEquals(test.value, test2.value);

        test = new Boolean(true);
        assertEquals(test.value, true);

        test = new Boolean(false);
        assertEquals(test.value, false);

        test = new Boolean(5);
        assertEquals(test.value, true);

        test = new Boolean(0);
        assertEquals(test.value, false);

        test = new Boolean(5.1);
        assertEquals(test.value, true);

        test = new Boolean(.0);
        assertEquals(test.value, true);
    }


    @org.junit.jupiter.api.Test
    void toInteger() {
        Boolean test = new Boolean();
        Integer integer = new Integer(0);
        assertEquals(test.toInteger(), integer.value);

        test = new Boolean(true);
        integer = new Integer(1);
        assertEquals(test.toInteger(), 1);
    }


    @org.junit.jupiter.api.Test
    void orOperator() {
        Boolean test = new Boolean();
        Boolean test2 = new Boolean(true);
        Boolean test3 = new Boolean(test.value || test2.value);
        assertEquals(test.Or(test2).value, test3.value);

        test = new Boolean(false);
        test2 = new Boolean(false);
        test3 = new Boolean(test.value || test2.value);
        assertEquals(test.Or(test2).value, test3.value);

        test = new Boolean(true);
        test2 = new Boolean(true);
        test3 = new Boolean(test.value || test2.value);
        assertEquals(test.Or(test2), test3.value);

        test = new Boolean(false);
        test3 = new Boolean(test.value || false);
        assertEquals(test.Or(false).value, test3.value);

        test = new Boolean(false);
        test3 = new Boolean(test.value || true);
        assertEquals(test.Or(true).value, test3.value);

        test = new Boolean(true);
        test3 = new Boolean(test.value || true);
        assertEquals(test.Or(true).value, test3.value);
    }


    @org.junit.jupiter.api.Test
    void andOperator() {
        Boolean test = new Boolean();
        Boolean test2 = new Boolean(true);
        Boolean test3 = new Boolean(test.value && test2.value);
        assertEquals(test.And(test2).value, test3.value);

        test = new Boolean(false);
        test2 = new Boolean(false);
        test3 = new Boolean(test.value && test2.value);
        assertEquals(test.And(test2).value, test3.value);

        test = new Boolean(true);
        test2 = new Boolean(true);
        test3 = new Boolean(test.value && test2.value);
        assertEquals(test.And(test2), test3.value);

        test = new Boolean(false);
        test3 = new Boolean(test.value && false);
        assertEquals(test.And(false).value, test3.value);

        test = new Boolean(false);
        test3 = new Boolean(test.value && true);
        assertEquals(test.And(true).value, test3.value);

        test = new Boolean(true);
        test3 = new Boolean(test.value && true);
        assertEquals(test.And(true).value, test3.value);
    }


    @org.junit.jupiter.api.Test
    void xorOperator() {
        Boolean test = new Boolean();
        Boolean test2 = new Boolean(true);
        Boolean test3 = new Boolean(test.value ^ test2.value);
        assertEquals(test.Xor(test2).value, test3.value);

        test = new Boolean(false);
        test2 = new Boolean(false);
        test3 = new Boolean(test.value ^ test2.value);
        assertEquals(test.Xor(test2).value, test3.value);

        test = new Boolean(true);
        test2 = new Boolean(true);
        test3 = new Boolean(test.value ^ test2.value);
        assertEquals(test.Xor(test2), test3.value);

        test = new Boolean(false);
        test3 = new Boolean(test.value ^ false);
        assertEquals(test.Xor(false).value, test3.value);

        test = new Boolean(false);
        test3 = new Boolean(test.value ^ true);
        assertEquals(test.Xor(true).value, test3.value);

        test = new Boolean(true);
        test3 = new Boolean(test.value ^ true);
        assertEquals(test.Xor(true).value, test3.value);
    }

    @org.junit.jupiter.api.Test
    void notOperator() {
        Boolean test = new Boolean();
        assertEquals(test.Not().value, true);

        test = new Boolean(true);
        assertEquals(test.Not().value, false);
    }
}
