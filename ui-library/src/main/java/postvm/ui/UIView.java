package postvm.ui;

import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.types.Type;

import javax.swing.*;

public class UIView extends LibraryClass {
    public static final String name = "UIView";
    public static final UIView INSTANCE = new UIView();
    public static final Type type = INSTANCE.classType;
    public JComponent component;
    public int id;

    private UIView() {
        super(name);
    }

    public UIView(JComponent component) {
        super(name);
        this.component = component;
        this.extendsClass = new UIContainer(component);
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "getId": return methodOld((caller, args) -> NumberClass.get(id), NumberClass.TYPE);
            case "setId": return voidMethod((caller, args) -> id = args.get(0).cast(NumberClass.class).value.intValue(),
                    NumberClass.TYPE);
        }

        return super.loadGlobal(clazz, target);
    }
}
