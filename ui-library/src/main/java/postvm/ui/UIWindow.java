package postvm.ui;

import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;

import javax.swing.*;
import java.util.Collections;

public class UIWindow extends UIContainer<JFrame> {
    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "UIWindow",
            UIContainer.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new UIWindow(caller, new JFrame()).classId;
        }
    };

    public UIWindow(int caller, JFrame frame) {
        super(caller, PROTOTYPE, frame);
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "pack": return voidMethod((caller, args) -> container.pack());
            case "dispose": return voidMethod((caller, args) -> container.dispose());
        }

        return super.loadMethod(clazz, target);
    }
}
