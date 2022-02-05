package lclang;

import postvm.Library;
import postvm.PostVMRoot;
import postvm.library.LangLibrary;
import postvm.stdlib.StdLibrary;
//import postvm.ui.UILibrary;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Global {
    public static final String version;
    public static final int buildTime;
    public static final boolean useCache;
    public static final ArrayList<PostVMRoot> libraries = new ArrayList<>();
    public static final ArrayList<Library> javaLibraries = new ArrayList<>();

    public static void printDebug(PrintStream out) {
        out.println("Version: "+version);
        out.println("Build time: "+buildTime);
        out.println("Use cache: "+useCache);
        out.println("Libraries count: "+libraries.size());
        out.println("Native libraries count: "+javaLibraries.size());
    }

    static {
        ResourceBundle prop = ResourceBundle.getBundle("build");
        version = prop.getString("version");
        buildTime = Integer.parseInt(prop.getString("buildTime"));
        useCache = prop.getString("useCache").equals("true");

        javaLibraries.add(new LangLibrary());
        javaLibraries.add(new StdLibrary());
//        javaLibraries.add(new UILibrary());
    }
}
