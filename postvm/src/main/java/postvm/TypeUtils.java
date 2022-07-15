package postvm;

import postvm.library.classes.VoidClass;
import postvm.types.Type;

import java.util.List;

public class TypeUtils {
    public static int isAccept(Type[] filterTypes, Type[] checkTypes) {
        if(filterTypes.length<checkTypes.length) {
            return filterTypes.length+1;
        }

        for (int i = 0; i < filterTypes.length; i++) {
            Type checkType = VoidClass.PROTOTYPE.type;
            if(checkTypes.length>i) checkType = checkTypes[i];

            if(!filterTypes[i].isAccept(checkType)) {
                return i;
            }
        }

        return -1;
    }
}
