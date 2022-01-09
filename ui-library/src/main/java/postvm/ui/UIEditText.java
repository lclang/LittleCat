package postvm.ui;

import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.types.Type;

import javax.swing.*;

public class UIEditText extends LibraryClass {
    public static final String name = "UIEditText";
    public static final UIEditText INSTANCE = new UIEditText();
    public static final Type type = INSTANCE.classType;
    public JTextArea textArea;

    private UIEditText() {
        super(name);
        constructor = method((caller, postVMClasses) -> new UIEditText(new JTextArea()), type);
    }

    public UIEditText(JTextArea textArea) {
        super(name);
        this.textArea = textArea;
        this.extendsClass = new UIView(textArea);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "getText": return method((caller, args) -> StringClass.get(textArea.getText()),
                    StringClass.type);
            case "setText": return voidMethod((caller, args) -> textArea.setText(args.get(0)
                            .cast(StringClass.class).string), StringClass.type);
        }

        return super.loadGlobal(target);
    }
}
