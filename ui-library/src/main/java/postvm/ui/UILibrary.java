package postvm.ui;

import postvm.Library;

public class UILibrary extends Library {
    public static final UILibrary INSTANCE = new UILibrary();

    public UILibrary() {
        super("ui");

        classes.put("UIContainer", UIContainer.PROTOTYPE);
        classes.put("UIView", UIView.PROTOTYPE);
        classes.put("UILinearLayout", UILinearLayout.PROTOTYPE);
        classes.put("UIText", UIText.PROTOTYPE);
        classes.put("UIButton", UIButton.PROTOTYPE);
        classes.put("UIWindow", UIWindow.PROTOTYPE);
        classes.put("UIEditText", UIEditText.PROTOTYPE);
    }
}
