package postvm.ui;

import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.library.classes.VoidClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

import javax.swing.*;
import java.util.Collections;

public class UIButton extends LibraryClass {
    public static final String name = "UIButton";
    public static final UIButton INSTANCE = new UIButton();
    public static final Type type = INSTANCE.classType;
    public JButton button;

    private UIButton() {
        super(name);
        constructor = method((caller, postVMClasses) -> new UIButton(new JButton()), type);
    }

    public UIButton(JButton button) {
        super(name);
        this.button = button;
        this.extendsClass = new UIView(button);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "getText": return method((caller, args) -> StringClass.get(button.getText()),
                    StringClass.type);
            case "setText": return voidMethod((caller, args) -> button.setText(args.get(0)
                            .cast(StringClass.class).string), StringClass.type);
            case "setOnClick": return voidMethod((caller, args) -> button.addActionListener(e -> args.get(0)
                    .cast(Method.class).call(caller, Collections.singletonList(this))),
                    CallableType.get(UIButton.type, VoidClass.PROTOTYPE.type));
        }

        return super.loadGlobal(target);
    }
}
