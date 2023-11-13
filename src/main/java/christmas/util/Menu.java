package christmas.util;

import java.util.Arrays;

public enum Menu {
    MENU_SOUP("양송이수프", Type.APPETIZER, 6_000),
    MENU_TAPAS("타파스", Type.APPETIZER, 5_500),
    MENU_SALAD("시저샐러드", Type.APPETIZER, 8_000),
    MENU_STEAK("티본스테이크", Type.MAIN_MENU, 55_000),
    MENU_BARBECUE("바비큐립", Type.MAIN_MENU, 54_000),
    MENU_SEA_PASTA("해산물파스타", Type.MAIN_MENU, 35_000),
    MENU_CHRISTMAS_PASTA("크리스마스파스타", Type.MAIN_MENU, 25_000),
    MENU_CAKE("초코케이크", Type.DESSERT, 15_000),
    MENU_ICE_CREAM("아이스크림", Type.DESSERT, 5_000),
    MENU_COKE("제로콜라", Type.BEVERAGE, 3_000),
    MENU_WINE("레드와인", Type.BEVERAGE, 60_000),
    MENU_CHAMPAGNE("샴페인", Type.BEVERAGE, 25_000)
    ;
    private final String name;
    private final Type type;
    private final int price;

    Menu(String name, Type type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public static boolean findMenu(String name) {
        return Arrays.stream(values())
                .anyMatch(value -> value.name.equals(name));
    }

    public static int getPriceByName(String name) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(name))
                .findFirst().get().price;
    }

    public static Type getTypeByName(String name) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(name))
                .findFirst().get().type;
    }
}
