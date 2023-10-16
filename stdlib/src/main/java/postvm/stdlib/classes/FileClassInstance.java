package postvm.stdlib.classes;

import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "File",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf(StringClassInstance.PROTOTYPE.type)
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new FileClassInstance(caller, new File(PostVMClassInstance.instances.get(args[0]).cast(StringClassInstance.class).string)).classId;
        }
    };

    public File file;

    public FileClassInstance(int caller, File file) {
        super(caller, PROTOTYPE);
        this.file = file;
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "name": return StringClassInstance.get(file.getName());
            case "path": return StringClassInstance.get(file.getPath());
            case "absolutePath": return StringClassInstance.get(file.getAbsolutePath());
            case "getCanonicalPath": return method(StringClassInstance.type, (caller, args) -> {
                try {
                    return StringClassInstance.get(file.getCanonicalPath());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });

            case "exists": return method(BoolClassInstance.type, (caller, args) -> BoolClassInstance.get(file.exists()));
            case "isDirectory": return method(BoolClassInstance.type, (caller, args) -> BoolClassInstance.get(file.isDirectory()));
            case "isFile": return method(BoolClassInstance.type, (caller, args) -> BoolClassInstance.get(file.isFile()));
            case "files": return method(ArrayClassInstance.type, (caller, args) -> {
                List<Integer> classList = new ArrayList<>();
                File[] files = file.listFiles();
                if(files!=null) for (File child: files)
                    classList.add(new FileClassInstance(caller, child).classId);

                return new ArrayClassInstance(classList).classId;
            });

            case "openInput": return method(InputClassInstance.PROTOTYPE.type.nullable(), (caller, lcClasses) -> {
                try {
                    return new InputClassInstance(caller, new FileInputStream(file)).classId;
                } catch (FileNotFoundException e) {
                    return NullClassInstance.INSTANCE.classId;
                }
            });

            case "openOutput": method(OutputClassInstance.PROTOTYPE.type.nullable(), (caller, lcClasses) -> {
                try {
                    return new OutputClassInstance(caller, new FileOutputStream(file)).classId;
                } catch (FileNotFoundException e) {
                    return NullClassInstance.INSTANCE.classId;
                }
            });

            case "createDir": return method(BoolClassInstance.type, (caller, lcClasses) -> BoolClassInstance.get(file.mkdir()));
            case "createDirs": return method(BoolClassInstance.type, (caller, lcClasses) -> BoolClassInstance.get(file.mkdirs()));
            case "create": return method(BoolClassInstance.type, (caller, lcClasses) -> {
                try {
                    return BoolClassInstance.get(file.createNewFile());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
        }
        return super.loadMethod(clazz, target);
    }
}
