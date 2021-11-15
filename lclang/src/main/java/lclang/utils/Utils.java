package lclang.utils;

import lclang.exceptions.LCLangException;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static <T> String joinToString(CharSequence spectator, Iterable<T> list, Function<T, String> join) {
        List<String> output = new ArrayList<>();
        for (T item: list) {
            try {
                output.add(join.invoke(item));
            } catch (LCLangException e) {
                e.printStackTrace();
            }
        }

        return String.join(spectator, output);
    }
}
