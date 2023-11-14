package christmas.dto;

public class Benefit {
    private final int FREE_BIE_ITEM_PRICE = 25_000;
    private int initialCost;
    private int totalDiscountValue;
    private int dayDiscountValue;
    private int weekendDiscountValue;
    private int holidayDiscountValue;
    private int specialDiscountValue;
    private boolean freebie;

    public Benefit(int initialCost, int totalDiscountValue, int dayDiscountValue, int weekendDiscountValue,
                   int holidayDiscountValue, int specialDiscountValue, boolean freebie) {
        this.initialCost = initialCost;
        this.totalDiscountValue = totalDiscountValue;
        this.dayDiscountValue = dayDiscountValue;
        this.weekendDiscountValue = weekendDiscountValue;
        this.holidayDiscountValue = holidayDiscountValue;
        this.specialDiscountValue = specialDiscountValue;
        this.freebie = freebie;
    }

    public int getInitialCost() {
        return this.initialCost;
    }

    public int getTotalDiscountValue() {
        return this.totalDiscountValue;
    }

    public int getDayDiscountValue() {
        return this.dayDiscountValue;
    }

    public int getWeekendDiscountValue() {
        return this.weekendDiscountValue;
    }

    public int getHolidayDiscountValue() {
        return this.holidayDiscountValue;
    }

    public int getSpecialDiscountValue() {
        return this.specialDiscountValue;
    }

    public boolean getFreebie() {
        return this.freebie;
    }

    public int getTotalResult() {
        if(!freebie) return this.initialCost - this.totalDiscountValue;
        return this.initialCost - this.totalDiscountValue + FREE_BIE_ITEM_PRICE;
    }
}
