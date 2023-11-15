package christmas.factory;

import christmas.dto.Benefit;

public enum BenefitFactory {
    BENEFIT_1(250_000,26_600,1_600,0,0,0,true),
    BENEFIT_2(250_000,29_400, 3_400, 0, 0, 1_000, true),
    BENEFIT_3(250_000, 45_230, 0, 0, 20_230, 0, true)
    ;
    private int initialCost;
    private int totalDiscountValue;
    private int dayDiscountValue;
    private int weekendDiscountValue;
    private int holidayDiscountValue;
    private int specialDiscountValue;
    private boolean freebie;

    BenefitFactory(int initialCost, int totalDiscountValue, int dayDiscountValue, int weekendDiscountValue,
                   int holidayDiscountValue, int specialDiscountValue, boolean freebie) {
        this.initialCost = initialCost;
        this.totalDiscountValue = totalDiscountValue;
        this.dayDiscountValue = dayDiscountValue;
        this.weekendDiscountValue = weekendDiscountValue;
        this.holidayDiscountValue = holidayDiscountValue;
        this.specialDiscountValue = specialDiscountValue;
        this.freebie = freebie;
    }

    public Benefit getInstance() {
        return new Benefit(this.initialCost, this.totalDiscountValue, this.dayDiscountValue, this.weekendDiscountValue,
                this.holidayDiscountValue, this.specialDiscountValue, this.freebie);
    }
}
