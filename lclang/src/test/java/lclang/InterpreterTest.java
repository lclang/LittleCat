package lclang;

import lclang.libs.TestLibrary;
import lclang.libs.lang.LangLibrary;
import lclang.libs.std.StdLibrary;
import lclang.utils.Utils;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interpreter Tests")
public class InterpreterTest {
    private static final File tests = new File("./tests/");

    @TestFactory
    public Stream<DynamicTest> run() {
        List<DynamicTest> testList = new ArrayList<>();
        File[] files = tests.listFiles();
        if(files!=null) for (File file: files)
            testList.add(DynamicTest.dynamicTest(file.getName(), () -> {
                StringBuilder output = new StringBuilder();

                Global.libraries.clear();
                Global.cashedClasses.clear();
                Global.javaLibraries.clear();
                Global.javaLibraries.add(new LangLibrary());
                Global.javaLibraries.add(new StdLibrary());
                Global.javaLibraries.add(new TestLibrary(output));

                String[] parts = Utils.readFile(file, UniversalDetector.detectCharset(file))
                        .split("--OUTPUT--\\R");
                String scriptPart = parts[0];
                String outputPart = parts[1];

                LCRootExecutor executor = new LCRootExecutor(file.getPath());
                lclangParser parser = new lclangParser(new CommonTokenStream(
                        new lclangLexer(CharStreams.fromString(scriptPart))
                ));
                parser.removeErrorListeners();
                parser.addErrorListener(new LCLangErrorListener(file.getPath()));

                long startTime = System.nanoTime();
                lclangParser.FileContext fileContext = parser.file();
                long endTime = System.nanoTime();
                long parseTime = endTime - startTime;

                startTime = System.nanoTime();
                LCCompiler.instance.fillFile(executor, fileContext);
                endTime = System.nanoTime();
                long compileTime = endTime - startTime;

                startTime = System.nanoTime();
                executor.execute();
                endTime = System.nanoTime();
                long executeTime = endTime - startTime;

                System.out.println("All time: "+(parseTime+executeTime+compileTime)+"ns / "+
                        ((parseTime+executeTime+compileTime)/1000000)+"ms");
                System.out.println("Execute time: "+executeTime+"ns / "+(executeTime/1000000)+"ms");
                System.out.println("Compile time: "+compileTime+"ns / "+(compileTime/1000000)+"ms");
                System.out.println("Parse time: "+parseTime+"ns / "+(parseTime/1000000)+"ms");

                System.out.println();
                System.out.println(output);

                assertEquals(outputPart.replaceAll("\\R", "\n").trim(),
                        output.toString().replaceAll("\\R", "\n").trim());
            }));
        return testList.stream();
    }
}
