package postvm.ui;

import postvm.library.classes.BoolClass;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.numbers.IntClass;
import postvm.types.Type;

import java.awt.*;

public class UIContainer extends LibraryClass {
    public static final String name = "UIContainer";
    public static final UIContainer INSTANCE = new UIContainer();
    public static final Type type = INSTANCE.classType;
    public Container container;

    private UIContainer() {
        super(name);
    }

    public UIContainer(Container container) {
        super(name);
        this.container = container;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "doLayout": return voidMethod((caller, args) -> container.doLayout());
            case "addNotify": return voidMethod((caller, args) -> container.addNotify());
            case "removeNotify": return voidMethod((caller, args) -> container.removeNotify());
            case "removeAll": return voidMethod((caller, args) -> container.removeAll());
            case "setSize": return voidMethod((caller, args) -> container.setSize(
                    args.get(0).cast(IntClass.class).value,
                    args.get(1).cast(IntClass.class).value
            ), IntClass.TYPE, IntClass.TYPE);
            case "setMinimumSize": return voidMethod((caller, args) -> container.setMinimumSize(new Dimension(
                    args.get(0).cast(IntClass.class).value,
                    args.get(1).cast(IntClass.class).value
            )), IntClass.TYPE, IntClass.TYPE);
            case "setMaximumSize": return voidMethod((caller, args) -> container.setMaximumSize(new Dimension(
                    args.get(0).cast(IntClass.class).value,
                    args.get(1).cast(IntClass.class).value
            )), IntClass.TYPE, IntClass.TYPE);
            case "setVisible": return voidMethod((caller, args) -> container.setVisible(args.get(0)==BoolClass.TRUE),
                    BoolClass.type);
            case "add": return voidMethod((caller, args) -> container.add(args.get(0)
                            .cast(UIContainer.class).container), type);
        }

        return super.loadGlobal(target);
    }
}
