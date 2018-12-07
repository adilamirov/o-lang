package translation_tests;
import ru.innopolis.comicon.stdlib.Integer;
import ru.innopolis.comicon.stdlib.Real;


public class JTest1 {
    public Integer a;

    public Integer Square(Integer temp) {
        Integer result = new Integer(temp);
        result = result.Mult(temp);
        return result;
    }

    public void main() {
        a = new Integer(12);
        System.out.println(a + "\n");
        a = Square(a);
    }
}
