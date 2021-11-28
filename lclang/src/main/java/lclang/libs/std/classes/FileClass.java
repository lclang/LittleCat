package lclang.libs.std.classes;

import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangIOException;
import lclang.libs.lang.classes.*;
import lclang.types.Types;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileClass extends LibraryClass {
    public static final String name = "File";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final FileClass instance = new FileClass();

    private FileClass() {
        super(name);
        constructor = method((caller, args) -> new FileClass(new File(args.get(0).toString(caller))),
                StringClass.type, type);
    }

    public FileClass(File file) {
        this();
        globals.put("name", new Value(StringClass.type, (caller) -> StringClass.get(file.getName())));
        globals.put("path", new Value(StringClass.type, (caller) -> StringClass.get(file.getPath())));
        globals.put("absolutePath", new Value(StringClass.type, (caller) -> StringClass.get(file.getAbsolutePath())));
        globals.put("canonicalPath", new Value(StringClass.type, (caller) -> {
            try {
                return StringClass.get(file.getCanonicalPath());
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }));
        globals.put("exists", new Value(BoolClass.type, (caller) -> BoolClass.get(file.exists())));
        globals.put("isDirectory", new Value(BoolClass.type, (caller) -> BoolClass.get(file.isDirectory())));
        globals.put("isFile", new Value(BoolClass.type, (caller) -> BoolClass.get(file.isFile())));
        globals.put("files", new Value(ArrayClass.type, (caller) -> {
            List<LCClass> classList = new ArrayList<>();
            File[] files = file.listFiles();
            if(files!=null) for (File child: files)
                classList.add(new FileClass(child));

            return new ArrayClass(classList);
        }));

        globals.put("openInput", method((caller, lcClasses) -> {
            try {
                return new InputClass(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                return NullClass.instance;
            }
        }, InputClass.type.nullable()).asValue());

        globals.put("openOutput", method((caller, lcClasses) -> {
            try {
                return new OutputClass(new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                return NullClass.instance;
            }
        }, OutputClass.type.nullable()).asValue());

        globals.put("createDir", method((caller, lcClasses) -> BoolClass.get(file.mkdir()), BoolClass.type).asValue());
        globals.put("createDirs", method((caller, lcClasses) -> BoolClass.get(file.mkdirs()), BoolClass.type).asValue());
        globals.put("create", method((caller, lcClasses) -> {
            try {
                return BoolClass.get(file.createNewFile());
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, BoolClass.type).asValue());
    }
}
