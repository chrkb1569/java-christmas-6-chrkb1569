package christmas.util;

import java.util.Arrays;
import java.util.List;

public class GameUtil {
    private final static String SPLIT_PATTERN_COMMA = ",";
    private final static String SPLIT_PATTERN_HYPHEN = "-";

    public static List<String> splitByComma(String value) {
        return Arrays.stream(value.split(SPLIT_PATTERN_COMMA)).toList();
    }

    public static List<String> splitByHyphen(String value) {
        return Arrays.stream(value.split(SPLIT_PATTERN_HYPHEN)).toList();
    }
}
