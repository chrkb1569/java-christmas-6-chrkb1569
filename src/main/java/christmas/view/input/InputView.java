package christmas.view.input;

import christmas.exception.NotValidInputException;
import christmas.view.checker.InputValueChecker;

import static christmas.view.output.OutputView.*;

public class InputView {
    private final String REQUEST_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final InputValueChecker inputValueChecker;
    private final Input input;

    public InputView(InputValueChecker inputValueChecker, Input input) {
        this.inputValueChecker = inputValueChecker;
        this.input = input;
    }

    public String readDate() {
        String date;

        try {
            System.out.println(REQUEST_DATE_MESSAGE);
            date = input.readDate();
            inputValueChecker.checkDateValidation(date);

            return date;
        } catch(NotValidInputException exception) {
            printInputExceptionMessage(exception);
            return readDate();
        }
    }
}
