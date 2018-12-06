import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class SyntaxTest {

    // scan file
    private String readFile(String path) {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(encoded);
    }

    private static final String testResourcesDir = "./Test/translation_test";
    private SyntaxAnalyzer SyntaxAnalyzer = new SyntaxAnalyzer();

    // First 3 tests are positive

    // try to read simple c-code
    @Test
    public void simple() {
        cSyntaxAnalyzer.analyze(testResourcesDir + "test1in.txt");
        cSyntaxAnalyzer.serializeTree(testResourcesDir + "test1outActual.txt");
        String actual = readFile(testResourcesDir + "test1outActual.txt");
        String expected = readFile(testResourcesDir + "test1outExpected.txt");
        assertEquals(actual, expected);
    }

    // a bit harder case
    @Test
    public void medium() {
        cSyntaxAnalyzer.analyze(testResourcesDir + "test2in.txt");
        cSyntaxAnalyzer.serializeTree(testResourcesDir + "test2outActual.txt");
        String actual = readFile(testResourcesDir + "test2outActual.txt");
        String expected = readFile(testResourcesDir + "test2outExpected.txt");
        assertEquals(actual, expected);
    }

    // test that program correctly works with big files(btw, the biggest file will in the `in.txt`)
    @Test
    public void hard() {
        cSyntaxAnalyzer.analyze(testResourcesDir + "test3in.txt");
        cSyntaxAnalyzer.serializeTree(testResourcesDir + "test3outActual.txt");
        String actual = readFile(testResourcesDir + "test3outActual.txt");
        String expected = readFile(testResourcesDir + "test3outExpected.txt");
        assertEquals(actual, expected);
    }

    // From this test, there are negative tests which check that program handle errors right

    // Line without ';'
    @Test
    public void wrongEol() {
        String expected = "line 2:0 missing ';' at '<EOF>'";
        String actual = "";
        try {
            cSyntaxAnalyzer.analyze(testResourcesDir + "test4in.txt");
            cSyntaxAnalyzer.serializeTree(testResourcesDir + "test4outActual.txt");
        } catch (Exception e) {
            actual = e.getMessage();
        }
        assertEquals(actual, expected);
    }

    // line with incorrect identifier
    @Test
    public void wrongId() {
        String expected = "line 5:0 mismatched input '{' expecting {'decltype', 'operator', '(', '*', '&', '~', '&&', '::', ';', '...', Identifier}";
        String actual = "";
        try {
            cSyntaxAnalyzer.analyze(testResourcesDir + "test5in.txt");
            cSyntaxAnalyzer.serializeTree(testResourcesDir + "test5outActual.txt");
        } catch (Exception e) {
            actual = e.getMessage();
        }
        assertEquals(actual, expected);
    }

    // line with wrong '}' order
    @Test
    public void wrongOrder() {
        String expected = "line 39:8 no viable alternative at input 'diff->'";
        String actual = "";
        try {
            cSyntaxAnalyzer.analyze(testResourcesDir + "test6in.txt");
            cSyntaxAnalyzer.serializeTree(testResourcesDir + "test6outActual.txt");
        } catch (Exception e) {
            actual = e.getMessage();
        }
        assertEquals(actual, expected);
    }
}