package lclang.libs.std.classes;

import lclang.exceptions.LCLangIOException;
import lclang.libs.lang.classes.*;
import lclang.types.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileClass extends LibraryClass {
    public static final String name = "File";
    public static final FileClass instance = new FileClass();
    public static final Type type = instance.classType;

    private FileClass() {
        super(name);
        constructor = method((caller, args) -> new FileClass(new File(args.get(0).cast(StringClass.class).string)),
                StringClass.type, type);
    }

    public FileClass(File file) {
        this();
        globals.put("getName", method((caller, args) -> StringClass.get(file.getName()), StringClass.type));
        globals.put("getPath", method((caller, args) -> StringClass.get(file.getPath()), StringClass.type));
        globals.put("getAbsolutePath", method((caller, args) -> StringClass.get(file.getAbsolutePath()), StringClass.type));
        globals.put("getCanonicalPath", method((caller, args) -> {
            try {
                return StringClass.get(file.getCanonicalPath());
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, StringClass.type));
        globals.put("exists",  method((caller, args) -> BoolClass.get(file.exists()), BoolClass.type));
        globals.put("isDirectory",  method((caller, args) -> BoolClass.get(file.isDirectory()), BoolClass.type));
        globals.put("isFile", method((caller, args) -> BoolClass.get(file.isFile()), BoolClass.type));
        globals.put("files", method((caller, args) -> {
            List<LCClass> classList = new ArrayList<>();
            File[] files = file.listFiles();
            if(files!=null) for (File child: files)
                classList.add(new FileClass(child));

            return new ArrayClass(classList);
        }, ArrayClass.type));

        globals.put("openInput", method((caller, lcClasses) -> {
            try {
                return new InputClass(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                return NullClass.instance;
            }
        }, InputClass.type.nullable()));

        globals.put("openOutput", method((caller, lcClasses) -> {
            try {
                return new OutputClass(new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                return NullClass.instance;
            }
        }, OutputClass.type.nullable()));

        globals.put("createDir", method((caller, lcClasses) -> BoolClass.get(file.mkdir()), BoolClass.type));
        globals.put("createDirs", method((caller, lcClasses) -> BoolClass.get(file.mkdirs()), BoolClass.type));
        globals.put("create", method((caller, lcClasses) -> {
            try {
                return BoolClass.get(file.createNewFile());
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, BoolClass.type));
    }
}
