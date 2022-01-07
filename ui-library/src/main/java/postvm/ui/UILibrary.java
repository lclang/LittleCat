package postvm.ui;

import postvm.Library;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.VoidClass;
import postvm.methods.Method;
import postvm.types.CallableType;

import javax.swing.*;
import java.util.Collections;

public class UILibrary extends Library {

    public UILibrary() {
        super("ui");
        classes.put("UIContainer", UIContainer.INSTANCE);
        classes.put("UILinearLayout", UILinearLayout.INSTANCE);
        classes.put("UIText", UIText.INSTANCE);
        classes.put("UIButton", UIButton.INSTANCE);
        classes.put("UIWindow", UIWindow.INSTANCE);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "useUI": return voidMethod((caller, args) ->
                    SwingUtilities.invokeLater(() -> args.get(0).cast(Method.class)
                            .call(caller, Collections.emptyList())
                    ), CallableType.get(VoidClass.type));
        }

        return super.loadGlobal(target);
    }
}
