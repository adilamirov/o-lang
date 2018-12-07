package ru.innopolis.comicon.olang;

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

        String main = main_class.replaceAll("<CLASS_NAME>", args[0]);
        BufferedWriter writer = new BufferedWriter(new FileWriter("compilation/Main.java"));
        writer.write(main);
        writer.close();

        Parser p = new Parser(new OLangTokenizer(new FileReader("samples/Test2.ol")));
        writer = new BufferedWriter(new FileWriter("compilation/First.java"));
        writer.write(p.parse().value.toString());
        writer.close();

//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        JarCreator jc = new JarCreator();
        jc.run();
    }
}
