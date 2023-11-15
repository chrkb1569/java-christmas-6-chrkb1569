package christmas.view.output;

public enum OutputMessage {
    START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DATE_BENEFIT_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    TOTAL_COST_BEFORE_DISCOUNT("%n<할인 전 총주문 금액>"),
    TOTAL_COST_AFTER_DISCOUNT("%n<할인 후 예상 결제 금액>"),
    FREEBIE_MESSAGE("%n<증정 메뉴>"),
    ORDERED_MENU_MESSAGE("%n<주문 메뉴>"),
    BENEFIT_LIST_MESSAGE("%n<혜택 내역>"),
    TOTAL_BENEFIT_MESSAGE("%n<총혜택 금액>"),
    EVENT_BADGE_MESSAGE("%n<12월 이벤트 배지>"),
    DAY_DISCOUNT_MESSAGE("크리스마스 디데이 할인: -%,d원"),
    WEEKEND_DISCOUNT_MESSAGE("평일 할인: -%,d원"),
    HOLIDAY_DISCOUNT_MESSAGE("주말 할인: -%,d원"),
    SPECIAL_DISCOUNT_MESSAGE("특별 할인: -%,d원"),
    FREEBIE_DISCOUNT_MESSAGE("증정 이벤트: -%,d원"),
    COST_MESSAGE("%,d원"),
    DISCOUNTED_COST_MESSAGE("-%,d원"),
    ORDERED_ITEM("%s %d개"),
    NOT_BENEFIT_MESSAGE("없음"),
    FREEBIE_ITEM("샴페인 1개")
    ;

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    @Override
    public String toString() {
        return this.outputMessage;
    }
}
