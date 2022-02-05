package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "File",
            PostVMClass.PROTOTYPE,
            Utils.listOf(StringClass.PROTOTYPE.type)
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            return new FileClass(caller, new File(args.get(0).cast(StringClass.class).string));
        }
    };

    public File file;

    public FileClass(Caller caller, File file) {
        super(caller, PROTOTYPE);
        this.file = file;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "name": return StringClass.get(file.getName());
            case "path": return StringClass.get(file.getPath());
            case "absolutePath": return StringClass.get(file.getAbsolutePath());
            case "getCanonicalPath": return method((caller, args) -> {
                try {
                    return StringClass.get(file.getCanonicalPath());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            }, StringClass.type);

            case "exists": return method((caller, args) -> BoolClass.get(file.exists()), BoolClass.type);
            case "isDirectory": return method((caller, args) -> BoolClass.get(file.isDirectory()), BoolClass.type);
            case "isFile": return method((caller, args) -> BoolClass.get(file.isFile()), BoolClass.type);
            case "files": return method((caller, args) -> {
                List<PostVMClass> classList = new ArrayList<>();
                File[] files = file.listFiles();
                if(files!=null) for (File child: files)
                    classList.add(new FileClass(caller, child));

                return new ArrayClass(classList);
            }, ArrayClass.type);

            case "openInput": return method((caller, lcClasses) -> {
                try {
                    return new InputClass(caller, new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    return NullClass.INSTANCE;
                }
            }, InputClass.PROTOTYPE.type.nullable());

            case "openOutput": method((caller, lcClasses) -> {
                try {
                    return new OutputClass(caller, new FileOutputStream(file));
                } catch (FileNotFoundException e) {
                    return NullClass.INSTANCE;
                }
            }, OutputClass.PROTOTYPE.type.nullable());

            case "createDir": return method((caller, lcClasses) -> BoolClass.get(file.mkdir()), BoolClass.type);
            case "createDirs": return method((caller, lcClasses) -> BoolClass.get(file.mkdirs()), BoolClass.type);
            case "create": return method((caller, lcClasses) -> {
                try {
                    return BoolClass.get(file.createNewFile());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            }, BoolClass.type);
        }
        return super.loadGlobal(target);
    }
}
