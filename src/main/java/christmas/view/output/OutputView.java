package christmas.view.output;

import christmas.dto.UserInput;
import christmas.exception.NotValidInputException;

import java.util.List;

public class OutputView {
    private final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String ORDER_MESSAGE = "%s %d개";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printUsersOrder(List<UserInput> inputValues) {
        for(UserInput inputValue : inputValues) {
            System.out.println(String.format(ORDER_MESSAGE, inputValue.getMenu(), inputValue.getQuantity()));
        }
    }

    public static <T extends NotValidInputException> void printInputExceptionMessage(T exception) {
        System.out.println(exception.getMessage());
    }
}