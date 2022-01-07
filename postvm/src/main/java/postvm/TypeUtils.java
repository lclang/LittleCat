package postvm;

import postvm.library.classes.VoidClass;
import postvm.types.Type;

import java.util.List;

public class TypeUtils {
    public static int isAccept(List<Type> filterTypes, List<Type> checkTypes) {
        if(filterTypes.size()<checkTypes.size()) {
            return filterTypes.size()+1;
        }

        for (int i = 0; i < filterTypes.size(); i++) {
            Type checkType = VoidClass.type;
            if(checkTypes.size()>i) checkType = checkTypes.get(i);

            if(!filterTypes.get(i).isAccept(checkType)) {
                return i;
            }
        }

        return -1;
    }
}
