package postvm.ui;

import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.types.Type;

import javax.swing.*;

public class UIText extends LibraryClass {
    public static final String name = "UIText";
    public static final UIText INSTANCE = new UIText();
    public static final Type type = INSTANCE.classType;
    public JLabel label;

    private UIText() {
        super(name);
        constructor = method((caller, postVMClasses) -> new UIText(new JLabel()), type);
    }

    public UIText(JLabel label) {
        super(name);
        this.label = label;
        this.extendsClass = new UIView(label);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "getText": return method((caller, args) -> StringClass.get(label.getText()),
                    StringClass.type);
            case "setText": return voidMethod((caller, args) -> label.setText(args.get(0)
                            .cast(StringClass.class).string), StringClass.type);
        }

        return super.loadGlobal(target);
    }
}
