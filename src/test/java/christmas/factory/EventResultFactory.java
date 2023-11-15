package christmas.factory;

import christmas.dto.EventResult;

public enum EventResultFactory {
    EVENT_RESULT_1(7, true, false, false),
    EVENT_RESULT_2(25, true, false, true),
    EVENT_RESULT_3(30, false, true, false)
    ;

    private int date;
    private boolean weekendDiscount;
    private boolean holidayDiscount;
    private boolean specialDiscount;

    EventResultFactory(int date, boolean weekendDiscount, boolean holidayDiscount, boolean specialDiscount) {
        this.date = date;
        this.weekendDiscount = weekendDiscount;
        this.holidayDiscount = holidayDiscount;
        this.specialDiscount = specialDiscount;
    }

    public EventResult getInstance() {
        return new EventResult(this.date, this.weekendDiscount, this.holidayDiscount, this.specialDiscount);
    }
}
