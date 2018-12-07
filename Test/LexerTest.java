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

        reader = new StringReader("var a := 2");
        lex = new OLangTokenizer(reader);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_VAR);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_ASSIGN);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_NUMBER);

        reader = new StringReader("if a.LessEqual(2) then a := 5 else a := 0 end");
        lex = new OLangTokenizer(reader);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_IF);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_DOT);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_BRACKET_ROUND_OP);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_NUMBER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_BRACKET_ROUND_CL);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_THEN);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_ASSIGN);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_NUMBER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_ELSE);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_ASSIGN);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_NUMBER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_END);


        reader = new StringReader("class C[T] is var m : T");
        lex = new OLangTokenizer(reader);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_CLASS);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_BRACKET_SQUARE_OP);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_BRACKET_SQUARE_CL);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_IS);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_VAR);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_COLON);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);

        reader = new StringReader("while i.LessEqual(a.Size) loop x := 10 end");
        lex = new OLangTokenizer(reader);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_WHILE);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_DOT);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_BRACKET_ROUND_OP);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_DOT);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_BRACKET_ROUND_CL);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_LOOP);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_IDENTIFIER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_ASSIGN);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_NUMBER);
        assertEquals(lex.nextToken(), OLangTokenizer.TT_KW_END);


    }

}
