package postvm.ui;

import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.types.Type;

import javax.swing.*;

public class UIWindow extends LibraryClass {
    public static final String name = "UIWindow";
    public static final UIWindow INSTANCE = new UIWindow();
    public static final Type type = INSTANCE.classType;
    public JFrame frame;

    private UIWindow() {
        super(name);
        constructor = method((caller, args) -> new UIWindow(new JFrame(
                args.get(0).cast(StringClass.class).string
        )), StringClass.type, type);
    }

    public UIWindow(JFrame frame) {
        super(name);
        this.frame = frame;
        this.extendsClass = new UIContainer(frame);
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "pack": return voidMethod((caller, args) -> frame.pack());
            case "dispose": return voidMethod((caller, args) -> frame.dispose());
        }

        return super.loadGlobal(clazz, target);
    }
}
