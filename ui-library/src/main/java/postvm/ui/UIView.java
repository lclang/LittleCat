package postvm.ui;

import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.library.classes.NumberClassInstance;

import javax.swing.*;
import java.util.Collections;

public class UIView<T extends JComponent> extends UIContainer<T> {
    public int id;

    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "UIView",
            UIContainer.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new UIView<>(caller, new JPanel()).classId;
        }
    };

    protected UIView(int caller, PostVMClassPrototype prototype, T component) {
        super(caller, prototype, component);
    }

    protected UIView(int caller, T component) {
        super(caller, PROTOTYPE, component);
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "getId": return nativeMethod(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(id));
            case "setId": return voidMethod((caller, args) -> id = args[0].cast(NumberClassInstance.class).value.intValue(),
                    NumberClassInstance.TYPE);
        }

        return super.loadMethod(clazz, target);
    }
}
