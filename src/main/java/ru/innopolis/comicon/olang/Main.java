package ru.innopolis.comicon.olang;

import ru.innopolis.comicon.lexer.OLangTokenizer;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader r = new FileReader("samples/test.ol");
        OLangTokenizer t = new OLangTokenizer(r);

        while (t.ttype != OLangTokenizer.TT_EOF) {
            t.nextToken();
            System.out.println(t);
        }

    }

}
