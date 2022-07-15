package postvm.ui;

import postvm.library.classes.BoolClass;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.types.Type;

import javax.swing.*;

public class UILinearLayout extends LibraryClass {
    public static final String name = "UILinearLayout";
    public static final UILinearLayout INSTANCE = new UILinearLayout();
    public static final Type type = INSTANCE.classType;
    public JPanel frame;

    private UILinearLayout() {
        super(name);
        constructor = methodOld((caller, args) -> new UILinearLayout(new JPanel()), type);
    }

    public UILinearLayout(JPanel frame) {
        super(name);
        this.frame = frame;
        this.extendsClass = new UIView(frame);
        this.frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "setHorizontal": return voidMethod((caller, args) -> frame.setLayout(
                    new BoxLayout(frame, args.get(0) == BoolClass.TRUE ?
                            BoxLayout.X_AXIS :
                            BoxLayout.Y_AXIS)), BoolClass.type);
        }

        return super.loadGlobal(clazz, target);
    }
}
