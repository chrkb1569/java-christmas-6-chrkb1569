package christmas.view.output;

import christmas.dto.Benefit;
import christmas.dto.UserInput;
import christmas.exception.NotValidInputException;

import java.util.List;

public class OutputView {
    private final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String ORDERS = "%n<주문 메뉴>";
    private final String INITIAL_COST = "%n<할인 전 총주문 금액>";
    private final String FREEBIE_MESSAGE = "%n<증정 메뉴>";
    private final String DAY_DISCOUNT_MESSAGE = "크리스마스 디데이 할인: -%,d원";
    private final String WEEKEND_DISCOUNT_MESSAGE = "평일 할인: -%,d원";
    private final String HOLIDAY_DISCOUNT_MESSAGE = "주말 할인: -%,d원";
    private final String SPECIAL_DISCOUNT_MESSAGE = "특별 할인: -%,d원";
    private final String FREEBIE_DISCOUNT_MESSAGE = "증정 이벤트: -%,d원";
    private final String FREEBIE = "샴페인 1개";
    private final String BENEFIT_MESSAGE = "%n<혜택 내역>";
    private final String NOT_BENEFIT = "없음";
    private final String ORDER_MESSAGE = "%s %d개";
    private final String COST_MESSAGE = "%,d원";
    private final String DISCOUNT_MESSAGE = "-%,d원";
    private final String TOTAL_DISCOUNT = "%n<총혜택 금액>";
    private final String TOTAL_RESULT_MESSAGE = "%n<할인 후 예상 결제 금액>";
    private final String BADGE_RESULT_MESSAGE = "%n<12월 이벤트 배지>";
    private final String BADGE_SANTA = "산타";
    private final String BADGE_TREE = "트리";
    private final String BADGE_STAR = "별";
    private final int EXPENSE_SANTA_BADGE = 20_000;
    private final int EXPENSE_TREE_BADGE = 10_000;
    private final int EXPENSE_STAR_BADGE = 5_000;

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printOrderInfo(List<UserInput> inputValues) {
        System.out.println(String.format(ORDERS));

        for(UserInput inputValue : inputValues) {
            System.out.println(String.format(ORDER_MESSAGE, inputValue.getMenu(), inputValue.getQuantity()));
        }
    }

    public void printInitialCost(Benefit benefit) {
        System.out.println(String.format(INITIAL_COST));
        System.out.println(String.format(COST_MESSAGE, benefit.getInitialCost()));
    }

    public void printFreebieItem(Benefit benefit) {
        System.out.println(String.format(FREEBIE_MESSAGE));
        System.out.println(getFreebieMessage(benefit.getFreebie()));
    }

    public void printBenefits(Benefit benefit) {
        System.out.println(String.format(BENEFIT_MESSAGE));

        if(checkResultMessage(benefit)) {
            System.out.println(NOT_BENEFIT);
            return;
        }

        printDayDiscountMessage(benefit);
        printWeekendDiscountMessage(benefit);
        printHolidayDiscountMessage(benefit);
        printSpecialDiscountMessage(benefit);
        printFreebieMessage(benefit);
    }

    public void printTotalDiscount(Benefit benefit) {
        System.out.println(String.format(TOTAL_DISCOUNT));
        System.out.println(String.format(DISCOUNT_MESSAGE, benefit.getTotalDiscountValue()));
    }

    public void printResultCost(Benefit benefit) {
        System.out.println(String.format(TOTAL_RESULT_MESSAGE));
        System.out.println(String.format(COST_MESSAGE, benefit.getTotalResult()));
    }

    public void printBadgeMessage(Benefit benefit) {
        System.out.println(String.format(BADGE_RESULT_MESSAGE));
        System.out.println(getBadgeMessage(benefit));
    }

    public static <T extends NotValidInputException> void printInputExceptionMessage(T exception) {
        System.out.println(exception.getMessage());
    }

    private String getFreebieMessage(boolean freebieValue) {
        if(freebieValue) return FREEBIE;
        return NOT_BENEFIT;
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
        if(dayDiscount != 0) System.out.println(String.format(DAY_DISCOUNT_MESSAGE, dayDiscount));
    }

    private void printWeekendDiscountMessage(Benefit benefit) {
        int weekendDiscountValue = benefit.getWeekendDiscountValue();
        if(weekendDiscountValue != 0) System.out.println(String.format(WEEKEND_DISCOUNT_MESSAGE, weekendDiscountValue));
    }

    private void printHolidayDiscountMessage(Benefit benefit) {
        int holidayDiscountValue = benefit.getHolidayDiscountValue();
        if(holidayDiscountValue != 0) System.out.println(String.format(HOLIDAY_DISCOUNT_MESSAGE, holidayDiscountValue));
    }

    private void printSpecialDiscountMessage(Benefit benefit) {
        int specialDiscountValue = benefit.getSpecialDiscountValue();
        if(specialDiscountValue != 0) System.out.println(String.format(SPECIAL_DISCOUNT_MESSAGE, specialDiscountValue));
    }

    private void printFreebieMessage(Benefit benefit) {
        boolean freebie = benefit.getFreebie();
        if(freebie) System.out.println(String.format(FREEBIE_DISCOUNT_MESSAGE, benefit.FREE_BIE_ITEM_PRICE));
    }

    private String getBadgeMessage(Benefit benefit) {
        int totalDiscountValue = benefit.getTotalDiscountValue();

        if(totalDiscountValue >= EXPENSE_SANTA_BADGE) return BADGE_SANTA;
        if(totalDiscountValue >= EXPENSE_TREE_BADGE) return BADGE_TREE;
        if(totalDiscountValue >= EXPENSE_STAR_BADGE) return BADGE_STAR;
        return NOT_BENEFIT;
    }
}