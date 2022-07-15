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
            ObjectClass.PROTOTYPE,
            Utils.listOf(StringClass.PROTOTYPE.type)
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            return new FileClass(caller, new File(PostVMClass.instances.get(args[0]).cast(StringClass.class).string)).classId;
        }
    };

    public File file;

    public FileClass(Caller caller, File file) {
        super(caller, PROTOTYPE);
        this.file = file;
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "name": return StringClass.get(file.getName());
            case "path": return StringClass.get(file.getPath());
            case "absolutePath": return StringClass.get(file.getAbsolutePath());
            case "getCanonicalPath": return method(StringClass.type, (caller, args) -> {
                try {
                    return StringClass.get(file.getCanonicalPath());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });

            case "exists": return method(BoolClass.type, (caller, args) -> BoolClass.get(file.exists()));
            case "isDirectory": return method(BoolClass.type, (caller, args) -> BoolClass.get(file.isDirectory()));
            case "isFile": return method(BoolClass.type, (caller, args) -> BoolClass.get(file.isFile()));
            case "files": return method(ArrayClass.type, (caller, args) -> {
                List<Integer> classList = new ArrayList<>();
                File[] files = file.listFiles();
                if(files!=null) for (File child: files)
                    classList.add(new FileClass(caller, child).classId);

                return new ArrayClass(classList).classId;
            });

            case "openInput": return method(InputClass.PROTOTYPE.type.nullable(), (caller, lcClasses) -> {
                try {
                    return new InputClass(caller, new FileInputStream(file)).classId;
                } catch (FileNotFoundException e) {
                    return NullClass.INSTANCE.classId;
                }
            });

            case "openOutput": method(OutputClass.PROTOTYPE.type.nullable(), (caller, lcClasses) -> {
                try {
                    return new OutputClass(caller, new FileOutputStream(file)).classId;
                } catch (FileNotFoundException e) {
                    return NullClass.INSTANCE.classId;
                }
            });

            case "createDir": return method(BoolClass.type, (caller, lcClasses) -> BoolClass.get(file.mkdir()));
            case "createDirs": return method(BoolClass.type, (caller, lcClasses) -> BoolClass.get(file.mkdirs()));
            case "create": return method(BoolClass.type, (caller, lcClasses) -> {
                try {
                    return BoolClass.get(file.createNewFile());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
        }
        return super.loadGlobal(clazz, target);
    }
}
