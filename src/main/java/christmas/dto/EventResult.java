package christmas.dto;

public class EventResult {
    private int date;
    private boolean weekendDiscount;
    private boolean holidayDiscount;
    private boolean specialDiscount;

    public EventResult(int date, boolean weekendDiscount,
                       boolean holidayDiscount, boolean specialDiscount) {
        this.date = date;
        this.weekendDiscount = weekendDiscount;
        this.holidayDiscount = holidayDiscount;
        this.specialDiscount = specialDiscount;
    }

    public int getDate() {
        return this.date;
    }

    public boolean isWeekendDiscount() {
        return this.weekendDiscount;
    }

    public boolean isHolidayDiscount() {
        return this.holidayDiscount;
    }

    public boolean isSpecialDiscount() {
        return this.specialDiscount;
    }
}
