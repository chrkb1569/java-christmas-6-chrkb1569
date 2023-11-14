package christmas.model;

public class Discount {
    private final int CHRISTMAS_DAY = 25;
    private final int BASIC_DISCOUNT_DAY = 1_000;
    private final int ADDED_DISCOUNT_DAY = 100;
    private final int WEEKEND_DISCOUNT = 2_023;
    private final int HOLIDAY_DISCOUNT = 2_023;
    private final int SPECIAL_DISCOUNT = 1_000;
    private final int MINIMUM_EXPENSE = 120_000;
    private int discountValue;

    public Discount() {
        this.discountValue = 0;
    }

    public int getDisCountValue() {
        return this.discountValue;
    }

    public int dayDiscount(final int date) {
        if(date > CHRISTMAS_DAY) return 0;
        int dayDiscount = BASIC_DISCOUNT_DAY + (date - 1) * ADDED_DISCOUNT_DAY;
        this.discountValue += dayDiscount;

        return dayDiscount;
    }

    public int weekendDiscount(final int dessertMenus) {
        int weekendDiscount = WEEKEND_DISCOUNT * dessertMenus;
        this.discountValue += weekendDiscount;

        return weekendDiscount;
    }

    public int holidayDiscount(final int mainMenus) {
        int holidayDiscount = HOLIDAY_DISCOUNT * mainMenus;
        this.discountValue += holidayDiscount;

        return holidayDiscount;
    }

    public int specialDiscount() {
        this.discountValue += SPECIAL_DISCOUNT;
        return SPECIAL_DISCOUNT;
    }

    public boolean freebieItem(final int totalCost, final int freebiePrice) {
        if(totalCost < MINIMUM_EXPENSE) return false;
        this.discountValue += freebiePrice;
        return true;
    }
}
