package ru.innopolis.comicon.olang;

import java_cup.runtime.Symbol;
import ru.innopolis.comicon.lexer.OLangTokenizer;
import ru.innopolis.comicon.parser.Parser;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    private static String main_class =

            "public class Main {" +
                "public static void main(String[] args) throws Exception {" +
                    "new <CLASS_NAME>();" +
                "}" +
            "}";

    public static void main(String[] args) throws Exception {
        String classname = args[0];
        String main = main_class.replaceAll("<CLASS_NAME>", args[0]);
        BufferedWriter writer = new BufferedWriter(new FileWriter("compilation/Main.java"));
        writer.write(main);
        writer.close();

        Parser p = new Parser(new OLangTokenizer(new FileReader("in.txt")));
        writer = new BufferedWriter(new FileWriter("compilation/" + classname + ".java"));
        Symbol sym = p.parse();
        if (sym.value == null) {
            return;
        }
        String code = "import ru.innopolis.comicon.stdlib.Integer;\n" +
                "import ru.innopolis.comicon.stdlib.Real;\n" +
                "import ru.innopolis.comicon.stdlib.Boolean;\n" + sym.value.toString();
        writer.write(code);
        writer.close();

//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        JarCreator jc = new JarCreator();
        jc.run(classname);
    }
}
