import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import ru.innopolis.comicon.lexer.OLangTokenizer;

/*
 We can't perform unit-testing to a particular function directly.
 Thus, every test will call the lexer with an input that evokes only the tested
 */
class LexerTest {

    @org.junit.jupiter.api.Test
    void getToken() throws IOException {
        Reader reader = new StringReader("Integer.Plus");
        OLangTokenizer lex = new OLangTokenizer(reader);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_DOT);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);

        reader = new StringReader("Integer.Plus");
        lex = new OLangTokenizer(reader);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_DOT);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);


    }

}
