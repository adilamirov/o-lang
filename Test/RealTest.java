import ru.innopolis.comicon.stdlib.Boolean;

import static org.junit.Assert.assertEquals;


class RealTest {

    @org.junit.jupiter.api.Test
    void createReal() {
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


}