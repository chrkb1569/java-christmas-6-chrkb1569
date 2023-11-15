package christmas.view.input;

import christmas.exception.NotValidInputException;
import christmas.exception.NotValidStatusException;
import christmas.util.GameUtil;
import christmas.view.checker.InputValueChecker;

import java.util.List;

import static christmas.exception.EventExceptionMessage.*;
import static christmas.view.output.OutputView.*;

public class InputView {
    private final String REQUEST_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final String REQUEST_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private final int RECURSION_LIMIT = 50;
    private final InputValueChecker inputValueChecker;
    private final Input input;

    public InputView(final InputValueChecker inputValueChecker, final Input input) {
        this.inputValueChecker = inputValueChecker;
        this.input = input;
    }

    public String readDate(int recursion) {
        String date;
        checkRecursionStatus(recursion);

        try {
            System.out.println(REQUEST_DATE_MESSAGE);
            date = input.readDate();
            inputValueChecker.checkDateValidation(date);

            return date;
        } catch(NotValidInputException exception) {
            printInputExceptionMessage(exception);
            return readDate(++recursion);
        }
    }

    public List<String> readOrder(int recursion) {
        String order;
        checkRecursionStatus(recursion);

        try {
            System.out.println(REQUEST_ORDER_MESSAGE);
            order = input.readOrder();
            inputValueChecker.checkOrderValidation(order);

            return GameUtil.splitByComma(order);
        } catch(NotValidInputException exception) {
            printInputExceptionMessage(exception);
            return readOrder(++recursion);
        }
    }

    private void checkRecursionStatus(int depth) {
        if(depth > RECURSION_LIMIT) {
            throw new NotValidStatusException(TOO_MANY_ERROR.getMessage(), depth);
        }
    }
}
