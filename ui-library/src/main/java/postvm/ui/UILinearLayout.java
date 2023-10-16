package postvm.ui;

import postvm.library.classes.BoolClassInstance;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.types.Type;

import javax.swing.*;
import java.util.Collections;

public class UILinearLayout extends UIView<JPanel> {
    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "UILinearLayout",
            UIView.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new UILinearLayout(caller, new JPanel()).classId;
        }
    };
    public static Type type = PROTOTYPE.type;

    public static final String name = "UILinearLayout";

    public UILinearLayout(int caller, JPanel frame) {
        super(caller, PROTOTYPE, frame);
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "setHorizontal": return voidMethod((caller, args) -> container.setLayout(
                    new BoxLayout(container, args[0].classId == BoolClassInstance.TRUE ?
                            BoxLayout.X_AXIS :
                            BoxLayout.Y_AXIS)), BoolClassInstance.type);
        }

        return super.loadMethod(clazz, target);
    }
}
