package lclang;

import postvm.Library;
import postvm.library.LangLibrary;
import postvm.library.classes.PostVMClass;
import postvm.stdlib.StdLibrary;
//import postvm.ui.UILibrary;

import java.io.PrintStream;
import java.util.ResourceBundle;

public class Global {
    public static final String version;
    public static final int buildTime;
    public static final boolean useCache;
    public static PostVMClass[] libraries = new PostVMClass[0];
    public static Library[] nativeLibs = new Library[] {
            LangLibrary.INSTANCE,
            StdLibrary.INSTANCE
    };

    public static void printDebug(PrintStream out) {
        out.println("Version: "+version);
        out.println("Build time: "+buildTime);
        out.println("Use cache: "+useCache);
        out.println("Libraries count: "+libraries.length);
        out.println("Native libraries count: "+ nativeLibs.length);
    }

    static {
        ResourceBundle prop = ResourceBundle.getBundle("build");
        version = prop.getString("version");
        buildTime = Integer.parseInt(prop.getString("buildTime"));
        useCache = prop.getString("useCache").equals("true");
    }
}
