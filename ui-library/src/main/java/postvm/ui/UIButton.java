package postvm.ui;

import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.library.classes.*;
import postvm.methods.MethodInstance;
import postvm.types.CallableType;

import javax.swing.*;
import java.util.Collections;

public class UIButton extends UIView<JButton> {
    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "UIButton",
            UIView.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new UIButton(caller, new JButton()).classId;
        }
    };

    public UIButton(int caller, JButton button) {
        super(caller, PROTOTYPE, button);
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "getText": return nativeMethod(StringClassInstance.type, (caller, args) -> StringClassInstance.get(container.getText()));
            case "setText": return voidMethod((caller, args) -> container.setText(args[0]
                            .cast(StringClassInstance.class).string), StringClassInstance.type);
            case "setOnClick": return voidMethod((caller, args) -> container.addActionListener(e -> args[0]
                    .cast(MethodInstance.class).call(caller, new int[0])),
                    CallableType.get(UIButton.type, VoidClassInstance.PROTOTYPE.type));
        }

        return super.loadMethod(clazz, target);
    }
}
