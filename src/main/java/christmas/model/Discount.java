package christmas.model;

public class Discount {
    private int discountValue;

    public Discount() {
        this.discountValue = 0;
    }

    public int getDisCountValue() {
        return this.discountValue;
    }

    public int dayDiscount(int date) {
        if(date > 25) return 0;
        int dayDiscount = 1000 + (date - 1) * 100;
        this.discountValue += dayDiscount;

        return dayDiscount;
    }

    public int weekendDiscount(int dessertMenus) {
        int weekendDiscount = 2023 * dessertMenus;
        this.discountValue += weekendDiscount;

        return weekendDiscount;
    }

    public int holidayDiscount(int mainMenus) {
        int holidayDiscount = 2023 * mainMenus;
        this.discountValue += holidayDiscount;

        return holidayDiscount;
    }

    public int specialDiscount() {
        this.discountValue += 1000;
        return 1000;
    }

    public boolean freebieItem(int totalCost, int freebiePrice) {
        if(totalCost < 120000) return false;
        this.discountValue += freebiePrice;
        return true;
    }
}
