package lclang.utils;

import lclang.types.Type;

public class TypeUtils {
    public static int isAccept(Type[] t, Type[] array) {
        if(t.length!=array.length) return array.length-1;
        for (int i = 0; i < t.length; i++) {
            if(!t[i].isAccept(array[i]))
                return i;
        }

        return -1;
    }
}
