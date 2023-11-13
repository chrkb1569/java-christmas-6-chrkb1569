package christmas.util;

import java.util.Arrays;

public enum Date {
    THURSDAY(0, "목요일"),
    FRIDAY(1, "금요일"),
    SATURDAY(2, "토요일"),
    SUNDAY(3, "일요일"),
    MONDAY(4, "월요일"),
    TUESDAY(5, "화요일"),
    WEDNESDAY(6, "수요일")
    ;

    private final static int DIV_NUMBER = 7;
    private final int index;
    private final String date;

    Date(int index, String date) {
        this.index = index;
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public static String convertDate(int date) {
        return Arrays.stream(values())
                .filter(value -> value.index == date % DIV_NUMBER)
                .findFirst().get().getDate();
    }
}