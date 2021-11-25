package lclang.utils;

import lclang.types.Type;

import java.util.List;

public class TypeUtils {
    public static int isAccept(List<Type> t, List<Type> array) {
        if(t.size()!=array.size()) return array.size()-1;
        for (int i = 0; i < t.size(); i++) {
            if(!t.get(i).isAccept(array.get(i)))
                return i;
        }

        return -1;
    }
}
