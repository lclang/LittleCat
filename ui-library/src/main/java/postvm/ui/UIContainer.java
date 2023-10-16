package postvm.ui;

import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;
import postvm.types.Type;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class UIContainer<T extends Container> extends LibraryClassInstance {
    public T container;
    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "UIContainer",
            null,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new UIContainer<>(caller, new JPanel()).classId;
        }
    };

    public static Type type = PROTOTYPE.type;

    protected UIContainer(int caller, PostVMClassPrototype prototype, T container) {
        super(caller, prototype);
        this.container = container;
    }

    protected UIContainer(int caller, T container) {
        this(caller, PROTOTYPE, container);
        this.container = container;
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "doLayout": return voidMethod((caller, args) -> container.doLayout());
            case "addNotify": return voidMethod((caller, args) -> container.addNotify());
            case "removeNotify": return voidMethod((caller, args) -> container.removeNotify());
            case "removeAll": return voidMethod((caller, args) -> container.removeAll());
            case "setSize": return voidMethod((caller, args) -> container.setSize(
                    args[0].cast(NumberClassInstance.class).value.intValue(),
                    args[1].cast(NumberClassInstance.class).value.intValue()
            ), NumberClassInstance.TYPE, NumberClassInstance.TYPE);
            case "setMinimumSize": return voidMethod((caller, args) -> container.setMinimumSize(new Dimension(
                    args[0].cast(NumberClassInstance.class).value.intValue(),
                    args[1].cast(NumberClassInstance.class).value.intValue()
            )), NumberClassInstance.TYPE, NumberClassInstance.TYPE);
            case "setMaximumSize": return voidMethod((caller, args) -> container.setMaximumSize(new Dimension(
                    args[0].cast(NumberClassInstance.class).value.intValue(),
                    args[1].cast(NumberClassInstance.class).value.intValue()
            )), NumberClassInstance.TYPE, NumberClassInstance.TYPE);
            case "setVisible": return voidMethod((caller, args) -> container.setVisible(args[0].classId== BoolClassInstance.TRUE),
                    BoolClassInstance.type);
            case "add": return voidMethod((caller, args) -> container.add(args[0]
                            .cast(UIContainer.class).container), type);
        }

        return super.loadMethod(clazz, target);
    }
}
