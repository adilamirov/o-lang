package ru.innopolis.comicon.olang;

import java_cup.runtime.Symbol;
import ru.innopolis.comicon.lexer.OLangTokenizer;
import ru.innopolis.comicon.parser.Parser;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    private static String main_class1 =

            "import ru.innopolis.comicon.stdlib.Boolean;\n" +
                    "import ru.innopolis.comicon.stdlib.Real;\n" +
                    "import ru.innopolis.comicon.stdlib.Integer;\n" +
                    "public class Main {";

    private static String main_class2 =
                    "public static void main(String[] args) throws Exception {" +
                    "new <CLASS_NAME>();" +
                    "}" +
                    "}";

    public static void main(String[] args) throws Exception {
        String main = main_class2.replaceAll("<CLASS_NAME>", args[0]);


        Parser p = new Parser(new OLangTokenizer(new FileReader("samples/Test2.ol")));
        Symbol sym = p.parse();
        BufferedWriter writer = new BufferedWriter(new FileWriter("compilation/Main.java"));
        writer.write(main);
        if (sym.value == null) {
            return;
        }
        String code = sym.value.toString();
        writer.write(main_class1 + code + main_clas);
        writer.close();

        JarCreator jc = new JarCreator();
        jc.run();
    }
}
