package ru.innopolis.comicon.olang;

import ru.innopolis.comicon.lexer.OLangTokenizer;
import ru.innopolis.comicon.parser.Parser;

import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception {
//        OLangTokenizer t= new OLangTokenizer(new FileReader("o-lang/samples/Test2.ol"));
//        while (t.ttype != OLangTokenizer.TT_EOF) {
//            t.next_token();
//            System.out.println(t);
//        }
        Parser p = new Parser(new OLangTokenizer(new FileReader("o-lang/samples/Test2.ol")));
//        p.parse();
//        System.out.println(p.parse());
        p.debug_parse();
    }
}
