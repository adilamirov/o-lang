package ru.innopolis.comicon.olang;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class JarCreator {
    public static void run() throws IOException
    {
        String file2ToCompile = "./compilation/Main.java";
        String file3ToCompile = "./src/main/java/ru/innopolis/comicon/stdlib/Boolean.java";
        String file4ToCompile = "./src/main/java/ru/innopolis/comicon/stdlib/Integer.java";
        String file5ToCompile = "./src/main/java/ru/innopolis/comicon/stdlib/Real.java";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        int compilationResult = compiler.run(null, null, null,
                file2ToCompile,
                file3ToCompile,
                file4ToCompile,
                file5ToCompile
        );

        if (compilationResult == 0) {

            System.out.println("Compilation is successful");

        } else {
            System.out.println("Compilation Failed");
        }

        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, "Main");
        manifest.getMainAttributes().put(Attributes.Name.CLASS_PATH, "./compilation/");
        JarOutputStream target = new JarOutputStream(new FileOutputStream("output.jar"), manifest);

        add(new File("./compilation/Main.class"), target);
        add(new File("./src/main/java/ru/innopolis/comicon/stdlib/Boolean.class"), target);
        add(new File("./src/main/java/ru/innopolis/comicon/stdlib/Integer.class"), target);
        add(new File("./src/main/java/ru/innopolis/comicon/stdlib/Real.class"), target);

        target.close();
    }

    private static void add(File source, JarOutputStream target) throws IOException
    {
        BufferedInputStream in = null;
        try
        {
            if (source.isDirectory())
            {
                String name = source.getPath().replace("\\", "/");
                if (!name.isEmpty())
                {
                    if (!name.endsWith("/"))
                        name += "/";
                    JarEntry entry = new JarEntry(name);
                    entry.setTime(source.lastModified());
                    target.putNextEntry(entry);
                    target.closeEntry();
                }
                for (File nestedFile: source.listFiles())
                    add(nestedFile, target);
                return;
            }

            JarEntry entry = new JarEntry(source.getPath().replace("\\", "/"));
            entry.setTime(source.lastModified());
            target.putNextEntry(entry);
            in = new BufferedInputStream(new FileInputStream(source));

            byte[] buffer = new byte[1024];
            while (true)
            {
                int count = in.read(buffer);
                if (count == -1)
                    break;
                target.write(buffer, 0, count);
            }
            target.closeEntry();
        }
        finally
        {
            if (in != null)
                in.close();
        }
    }
}