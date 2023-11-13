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

    public EventResult getEventResult(int date) {
        String day = convertDate(date);

        boolean holidayDiscount = checkHolidayDiscount(day);
        boolean weekendDiscount = checkWeekendDiscount(day);
        boolean specialDiscount = checkSpecialDiscount(day, date);

        return new EventResult(date, weekendDiscount, holidayDiscount, specialDiscount);
    }

    public Benefit getTotalBenefit(List<UserInput> inputValues, EventResult eventResult) {
        Orders orders = new Orders(inputValues);
        Discount discount = new Discount();

        return getBenefit(orders, discount, eventResult);
    }

    private boolean checkHolidayDiscount(String day) {
        return day.equals(FRIDAY.getDate()) || day.equals(SATURDAY.getDate());
    }

    private boolean checkWeekendDiscount(String day) {
        return !day.equals(FRIDAY.getDate()) && !day.equals(SATURDAY.getDate());
    }

    private boolean checkSpecialDiscount(String day, int date) {
        return day.equals(SUNDAY.getDate()) || date == CHRISTMAS_DATE;
    }

    private Benefit getBenefit(Orders orders, Discount discount, EventResult eventResult) {
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

    private int getDayDiscount(Discount discount, EventResult eventResult) {
        return discount.dayDiscount(eventResult.getDate());
    }

    private int getWeekendDiscount(Orders orders, Discount discount, EventResult eventResult) {
        int weekendDiscount = 0;

        if(eventResult.isWeekendDiscount()) {
            int dessertMenus = orders.getQuantityByType(Type.DESSERT);
            weekendDiscount = discount.weekendDiscount(dessertMenus);
        }

        return weekendDiscount;
    }

    private int getHolidayDiscount(Orders orders, Discount discount, EventResult eventResult) {
        int holidayDiscount = 0;

        if(eventResult.isHolidayDiscount()) {
            int mainMenus = orders.getQuantityByType(Type.MAIN_MENU);
            holidayDiscount = discount.holidayDiscount(mainMenus);
        }

        return holidayDiscount;
    }

    private int getSpecialDiscount(Discount discount, EventResult eventResult) {
        int specialDiscount = 0;

        if(eventResult.isSpecialDiscount()) {
            specialDiscount = discount.specialDiscount();
        }

        return specialDiscount;
    }
}
