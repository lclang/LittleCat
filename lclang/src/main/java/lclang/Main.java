package lclang;

import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.Library;
import lclang.libs.lang.classes.ArrayClass;
import lclang.libs.lang.classes.StringClass;
import lclang.utils.Utils;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {
    public static final String ERROR_COLOR = (char) 27 + "[31m";
    public static final String RESET_COLOR = (char) 27 + "[0m";

    public static void main(String[] args) {
        try {
            File librariesDirectory = new File(System.getProperty("libsPath", "./libs"));
            if (librariesDirectory.exists()) {
                File[] librariesFiles = librariesDirectory.listFiles();
                if (librariesFiles != null) {
                    for (File libraryFile : librariesFiles) {
                        String fileName = libraryFile.getName();
                        if (fileName.endsWith(".jar")) {
                            loadJarLibrariesFromFile(libraryFile);
                        } else if (fileName.endsWith(".lcat")) {
                            LCRootExecutor executor = new LCRootExecutor(fileName);
                            try {
                                executeInput(executor, Utils.readFile(libraryFile,
                                        UniversalDetector.detectCharset(libraryFile)));
                                Global.libraries.add(executor);
                            } catch (IOException ignored) {}
                        }
                    }
                }
            }

            if(args.length==0) {
                System.out.println("Little cat "+Global.version+" (Build date: "+Global.buildTime+")");
                Scanner scanner = new Scanner(System.in);
                LCRootExecutor cliExecutor = new LCRootExecutor("cli");

                System.out.print("> ");
                while (scanner.hasNextLine()) {
                    String code = scanner.nextLine();

                    try {
                        executeInput(cliExecutor, code);
                    } catch (RuntimeException e) {
                        System.out.println(ERROR_COLOR + e.getMessage() + RESET_COLOR);
                    }

                    System.out.print("> ");
                }

                System.exit(0);
            }

            List<String> programArgs = new ArrayList<>(Arrays.asList(args));
            String filePathString = programArgs.remove(0);
            Path filePath = Paths.get(filePathString);
            if(!filePath.isAbsolute()) filePath = Paths.get(
                    System.getProperty("user.dir"),
                    filePathString
            ).normalize();

            File file = new File(filePath.toUri());
            if(!file.exists()){
                System.out.println(ERROR_COLOR+"File not exists"+RESET_COLOR);
                System.exit(1);
            }

            if(file.length()==0L) return;
            LCRootExecutor executor = new LCRootExecutor(file.getPath());

            List<LCClass> arguments = new ArrayList<>();
            for(String argument: programArgs) arguments.add(StringClass.get(argument));

            executor.executor.variables.put("args", new ArrayClass(arguments).asValue());
            executeInput(executor, Utils.readFile(file, UniversalDetector.detectCharset(file)));
        } catch (RuntimeException e) {
            System.out.println(ERROR_COLOR + e.getMessage() + RESET_COLOR);
            System.exit(1);
        } catch (IOException ignored) {}
    }

    public static void loadJarLibrariesFromFile(File libraryFile) {
        try {
            JarFile jarFile = new JarFile(libraryFile);
            Enumeration<JarEntry> entries = jarFile.entries();
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {
                    new URL("jar:file:" + libraryFile.getPath() + "!/")
            });

            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.isDirectory() || !entry.getName().endsWith(".class")) {
                    continue;
                }

                String className = entry.getName().substring(0, entry.getName().length() - 6)
                        .replace('/', '.');
                Class<?> clazz = classLoader.loadClass(className);
                if (Library.class.isAssignableFrom(clazz))
                    Global.javaLibraries.add((Library) clazz.newInstance());
            }
        } catch (Exception e) {
            System.out.println(ERROR_COLOR);
            e.printStackTrace();
            System.out.println("Library "+ libraryFile.getName() + "not loaded" + RESET_COLOR);
        }
    }

    public static LCClass executeInput(LCRootExecutor executor, String file) throws LCLangRuntimeException {
        lclangParser parser = new lclangParser(new CommonTokenStream(
                new lclangLexer(CharStreams.fromString(file))
        ));
        parser.removeErrorListeners();
        parser.addErrorListener(new LCLangErrorListener(executor.path));

        LCCompiler.instance.fillFile(executor, parser.file());
        return executor.execute();
    }
}
