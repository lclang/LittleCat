package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.utils.Function;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static final Pattern unicodeEscapePattern = Pattern.compile("\\\\u([0-9A-f][0-9A-f][0-9A-f][0-9A-f])");
    public static <T> String joinToString(CharSequence spectator, Iterable<T> list, Function<T, String> join) {
        List<String> output = new ArrayList<>();
        for (T item: list) {
            try {
                output.add(join.invoke(item));
            } catch (LCLangRuntimeException e) {
                e.printStackTrace();
            }
        }

        return String.join(spectator, output);
    }

    public static String unescapeString(String input) {
        if(!input.contains("\\")) return input;
        String output = input.replace("\\n", "\n")
                .replace("\\r", "\r")
                .replace("\\t", "\t")
                .replace("\\\"", "\"");

        Matcher matcher = unicodeEscapePattern.matcher(output);
        while (matcher.find()) {
            output = output.replace(matcher.group(0), String.valueOf((char)
                    Long.parseLong(matcher.group(1), 16)));
        }

        return output;
    }

    public static String readFile(File file, String charset) throws FileNotFoundException {
        Scanner scanner = new Scanner(file, charset);

        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) lines.add(scanner.nextLine());
        return String.join("\n", lines);
    }
}