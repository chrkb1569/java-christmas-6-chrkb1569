package christmas.view.output;

import christmas.exception.NotValidInputException;

public class OutputView {
    private final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static <T extends NotValidInputException> void printInputExceptionMessage(T exception) {
        System.out.println(exception.getMessage());
    }
}
