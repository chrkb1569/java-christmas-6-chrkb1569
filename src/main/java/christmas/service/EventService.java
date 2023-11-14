package christmas.service;

import christmas.dto.Benefit;
import christmas.dto.EventResult;
import christmas.dto.UserInput;
import christmas.model.Discount;
import christmas.model.Orders;
import christmas.util.Menu;
import christmas.util.Type;

import java.util.List;

import static christmas.util.Date.*;

public class EventService {
    private final int CHRISTMAS_DATE = 25;
    private final String FREEBIE_ITEM_NAME = "샴페인";

    public EventResult getEventResult(final int date) {
        String day = convertDate(date);

        boolean holidayDiscount = checkHolidayDiscount(day);
        boolean weekendDiscount = checkWeekendDiscount(day);
        boolean specialDiscount = checkSpecialDiscount(day, date);

        return new EventResult(date, weekendDiscount, holidayDiscount, specialDiscount);
    }

    public Benefit getTotalBenefit(final List<UserInput> inputValues, final EventResult eventResult) {
        Orders orders = new Orders(inputValues);
        Discount discount = new Discount();

        return getBenefit(orders, discount, eventResult);
    }

    private boolean checkHolidayDiscount(final String day) {
        return day.equals(FRIDAY.getDate()) || day.equals(SATURDAY.getDate());
    }

    private boolean checkWeekendDiscount(final String day) {
        return !day.equals(FRIDAY.getDate()) && !day.equals(SATURDAY.getDate());
    }

    private boolean checkSpecialDiscount(final String day, final int date) {
        return day.equals(SUNDAY.getDate()) || date == CHRISTMAS_DATE;
    }

    private Benefit getBenefit(final Orders orders, final Discount discount, final EventResult eventResult) {
        int initialCost = orders.getInitialCost();
        int dayDiscount = getDayDiscount(discount, eventResult);
        int weekendDiscount = getWeekendDiscount(orders, discount, eventResult);
        int holidayDiscount = getHolidayDiscount(orders, discount, eventResult);
        int specialDiscount = getSpecialDiscount(discount, eventResult);
        boolean freebieValue = discount.freebieItem(initialCost, Menu.getPriceByName(FREEBIE_ITEM_NAME));
        int totalDiscount = discount.getDisCountValue();

        return new Benefit(initialCost, totalDiscount, dayDiscount, weekendDiscount,
                holidayDiscount, specialDiscount, freebieValue);
    }

    private int getDayDiscount(final Discount discount, final EventResult eventResult) {
        return discount.dayDiscount(eventResult.getDate());
    }

    private int getWeekendDiscount(final Orders orders, final Discount discount, final EventResult eventResult) {
        int weekendDiscount = 0;

        if(eventResult.isWeekendDiscount()) {
            int dessertMenus = orders.getQuantityByType(Type.DESSERT);
            weekendDiscount = discount.weekendDiscount(dessertMenus);
        }

        return weekendDiscount;
    }

    private int getHolidayDiscount(final Orders orders, final Discount discount, final EventResult eventResult) {
        int holidayDiscount = 0;

        if(eventResult.isHolidayDiscount()) {
            int mainMenus = orders.getQuantityByType(Type.MAIN_MENU);
            holidayDiscount = discount.holidayDiscount(mainMenus);
        }

        return holidayDiscount;
    }

    private int getSpecialDiscount(final Discount discount, final EventResult eventResult) {
        int specialDiscount = 0;

        if(eventResult.isSpecialDiscount()) {
            specialDiscount = discount.specialDiscount();
        }

        return specialDiscount;
    }
}
