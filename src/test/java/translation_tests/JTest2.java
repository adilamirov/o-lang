package translation_tests;
import ru.innopolis.comicon.stdlib.Integer;
import ru.innopolis.comicon.stdlib.Real;


public class JTest2 extends JTest1 {
    public Integer value;

    private JTest2(ru.innopolis.comicon.stdlib.Real temp) {
        this.value = temp.toInteger();
    }

    private JTest2(Integer temp) {
        this.value = temp;
    }

    public Integer SquareMinuOne(Integer temp) {
        Integer result;
        result = this.Square(temp);
        result = result.Minus(1);
        return result;
    }

    public Integer SumFromOneToN(Integer n) {
        Integer result = new Integer(1);
        Integer i = new Integer(1);
        while (i.LessEqual(n).value) {
            result = result.Plus(i);
            i = i.Plus(1);
        }
        return result;
    }

}



















