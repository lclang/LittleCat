package lclang;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.mozilla.universalchardet.UniversalDetector;
import postvm.Library;
import postvm.Utils;
import postvm.exceptions.LCLangLexerException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.ArrayClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;

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
                    PostVMClass[] libs = new PostVMClass[librariesFiles.length];
                    for (int i = 0, l = librariesFiles.length; i < l; i++) {
                        File libraryFile = librariesFiles[i];
                        String fileName = libraryFile.getName();
                        if (fileName.endsWith(".jar")) {
                            libs[i] = loadJarLibrariesFromFile(libraryFile);
                        } else if (fileName.endsWith(".lcat")) {
                            LCLangFileClass executor = new LCLangFileClass(libraryFile);
                            try {
                                executeInput(executor, Utils.readFile(libraryFile,
                                        UniversalDetector.detectCharset(libraryFile)), new int[0]);
                                libs[i] = executor;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    Global.libraries = libs;
                }
            }

            if(args.length==0) {
                System.out.println("Little cat "+Global.version+" (Build date: "+Global.buildTime+")");
                Scanner scanner = new Scanner(System.in);
                LCLangFileClass cliExecutor = new LCLangFileClass(new File("./cli"));

                System.out.print("> ");
                while (scanner.hasNextLine()) {
                    String code = scanner.nextLine();

                    try {
                        executeInput(cliExecutor, code, new int[0]);
                    } catch (RuntimeException e) {
                        System.out.println(ERROR_COLOR + e.getMessage() + RESET_COLOR);
                    }

                    System.out.print("> ");
                }

                System.exit(0);
            }

            String filePathString = args[0];
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
            LCLangFileClass executor = new LCLangFileClass(file);

            int[] arguments = new int[args.length-1];
            for (int i = 0, l = arguments.length; i < l; i++) {
                arguments[i] = StringClass.get(args[i+1]);
            }

            System.gc();
            executeInput(executor, Utils.readFile(file, UniversalDetector.detectCharset(file)), arguments);
        } catch (RuntimeException e) {
            if(e instanceof LCLangRuntimeException||e instanceof LCLangLexerException)
                System.out.println(ERROR_COLOR + e.getMessage() + RESET_COLOR);
            else {
                e.printStackTrace();
                System.out.println(ERROR_COLOR + "Invalid error. Please submit this error to GitHub: " +
                        "https://gtihub.com/lclang/LittleCat/issues"+RESET_COLOR);
            }

            System.exit(1);
        } catch (IOException ignored) {}
    }

    public static Library loadJarLibrariesFromFile(File libraryFile) {
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
                    return (Library) clazz.newInstance();
            }
        } catch (Exception e) {
            System.out.println(ERROR_COLOR);
            e.printStackTrace();
            System.out.println("Library "+ libraryFile.getName() + "not loaded" + RESET_COLOR);
        }

        return null;
    }

    public static void executeInput(LCLangFileClass executor, String file, int[] args) throws LCLangRuntimeException {
        lclangParser parser = new lclangParser(new CommonTokenStream(
                new lclangLexer(CharStreams.fromString(file))
        ));
        parser.removeErrorListeners();
        parser.addErrorListener(new LCLangErrorListener(executor.path));

        LCCompiler.instance.fillFile(executor, parser.file());
        executor.execute(args);
    }
}
