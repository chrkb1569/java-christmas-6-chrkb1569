package christmas.view.output;

import christmas.dto.Benefit;
import christmas.dto.UserInput;
import christmas.exception.NotValidInputException;

import java.util.List;

import static christmas.view.output.OutputMessage.*;

public class OutputView {
    private final String BADGE_SANTA = "산타";
    private final String BADGE_TREE = "트리";
    private final String BADGE_STAR = "별";
    private final int EXPENSE_SANTA_BADGE = 20_000;
    private final int EXPENSE_TREE_BADGE = 10_000;
    private final int EXPENSE_STAR_BADGE = 5_000;
    private final int FREE_BIE_ITEM_PRICE = 25_000;

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printDateBenefit(int date) {
        System.out.println(String.format(DATE_BENEFIT_MESSAGE.toString(), date));
    }

    public void printOrderInfo(List<UserInput> inputValues) {
        System.out.println(String.format(ORDERED_MENU_MESSAGE.toString()));

        for(UserInput inputValue : inputValues) {
            System.out.println(String.format(ORDERED_ITEM.toString(), inputValue.getMenu(), inputValue.getQuantity()));
        }
    }

    public void printInitialCost(Benefit benefit) {
        System.out.println(String.format(TOTAL_COST_BEFORE_DISCOUNT.toString()));
        System.out.println(String.format(COST_MESSAGE.toString(), benefit.getInitialCost()));
    }

    public void printFreebieItem(Benefit benefit) {
        System.out.println(String.format(FREEBIE_MESSAGE.toString()));
        System.out.println(getFreebieMessage(benefit.getFreebie()));
    }

    public void printBenefits(Benefit benefit) {
        System.out.println(String.format(BENEFIT_LIST_MESSAGE.toString()));

        if(checkResultMessage(benefit)) {
            System.out.println(NOT_BENEFIT_MESSAGE);
            return;
        }

        printDayDiscountMessage(benefit);
        printWeekendDiscountMessage(benefit);
        printHolidayDiscountMessage(benefit);
        printSpecialDiscountMessage(benefit);
        printFreebieMessage(benefit);
    }

    public void printTotalDiscount(Benefit benefit) {
        System.out.println(String.format(TOTAL_BENEFIT_MESSAGE.toString()));
        System.out.println(String.format(DISCOUNTED_COST_MESSAGE.toString(), benefit.getTotalDiscountValue()));
    }

    public void printResultCost(Benefit benefit) {
        System.out.println(String.format(TOTAL_COST_AFTER_DISCOUNT.toString()));
        System.out.println(String.format(COST_MESSAGE.toString(), benefit.getTotalResult()));
    }

    public void printBadgeMessage(Benefit benefit) {
        System.out.println(String.format(EVENT_BADGE_MESSAGE.toString()));
        System.out.println(getBadgeMessage(benefit));
    }

    public static <T extends NotValidInputException> void printInputExceptionMessage(T exception) {
        System.out.println(exception.getMessage());
    }

    private String getFreebieMessage(boolean freebieValue) {
        if(freebieValue) return FREEBIE_ITEM.toString();
        return NOT_BENEFIT_MESSAGE.toString();
    }

    private boolean checkResultMessage(Benefit benefit) {
        int dayDiscountValue = benefit.getDayDiscountValue();
        int weekendDiscountValue = benefit.getWeekendDiscountValue();
        int holidayDiscountValue = benefit.getHolidayDiscountValue();
        int specialDiscountValue = benefit.getSpecialDiscountValue();
        boolean freebieValue = benefit.getFreebie();

        return dayDiscountValue == 0 && weekendDiscountValue == 0 &&
                holidayDiscountValue == 0 && specialDiscountValue == 0
                && !freebieValue;
    }

    private void printDayDiscountMessage(Benefit benefit) {
        int dayDiscount = benefit.getDayDiscountValue();
        if(dayDiscount != 0) System.out.println(String.format(DAY_DISCOUNT_MESSAGE.toString(), dayDiscount));
    }

    private void printWeekendDiscountMessage(Benefit benefit) {
        int weekendDiscountValue = benefit.getWeekendDiscountValue();
        if(weekendDiscountValue != 0) System.out.println(String.format(WEEKEND_DISCOUNT_MESSAGE.toString(), weekendDiscountValue));
    }

    private void printHolidayDiscountMessage(Benefit benefit) {
        int holidayDiscountValue = benefit.getHolidayDiscountValue();
        if(holidayDiscountValue != 0) System.out.println(String.format(HOLIDAY_DISCOUNT_MESSAGE.toString(), holidayDiscountValue));
    }

    private void printSpecialDiscountMessage(Benefit benefit) {
        int specialDiscountValue = benefit.getSpecialDiscountValue();
        if(specialDiscountValue != 0) System.out.println(String.format(SPECIAL_DISCOUNT_MESSAGE.toString(), specialDiscountValue));
    }

    private void printFreebieMessage(Benefit benefit) {
        boolean freebie = benefit.getFreebie();
        if(freebie) System.out.println(String.format(FREEBIE_DISCOUNT_MESSAGE.toString(), FREE_BIE_ITEM_PRICE));
    }

    private String getBadgeMessage(Benefit benefit) {
        int totalDiscountValue = benefit.getTotalDiscountValue();

        if(totalDiscountValue >= EXPENSE_SANTA_BADGE) return BADGE_SANTA;
        if(totalDiscountValue >= EXPENSE_TREE_BADGE) return BADGE_TREE;
        if(totalDiscountValue >= EXPENSE_STAR_BADGE) return BADGE_STAR;
        return NOT_BENEFIT_MESSAGE.toString();
    }
}