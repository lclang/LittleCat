package postvm.ui;

import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.library.classes.StringClassInstance;

import javax.swing.*;
import java.util.Collections;

public class UIEditText extends UIView<JTextArea> {
    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "UIEditText",
            UIView.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new UIEditText(caller, new JTextArea()).classId;
        }
    };

    public UIEditText(int caller, JTextArea textArea) {
        super(caller, PROTOTYPE, textArea);
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "getText": return nativeMethod(StringClassInstance.type, (caller, args) -> StringClassInstance.get(container.getText()));
            case "setText": return voidMethod((caller, args) -> container.setText(args[0]
                            .cast(StringClassInstance.class).string), StringClassInstance.type);
        }

        return super.loadMethod(clazz, target);
    }
}
