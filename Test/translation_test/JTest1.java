package translation_test;


public class JTest1 {
    public Integer a;

    public Integer Square(Integer temp) {
        Integer result = new Integer(temp);
        result = result.Mult(temp);
        return result;
    }

    public void main() {
        a = 12;
        a = Square(a);
    }
}
