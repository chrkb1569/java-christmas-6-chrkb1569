package christmas.view.input;

import christmas.view.checker.InputValueChecker;

public class InputView {
    private final String REQUEST_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final InputValueChecker inputValueChecker;
    private final Input input;

    public InputView(InputValueChecker inputValueChecker, Input input) {
        this.inputValueChecker = inputValueChecker;
        this.input = input;
    }

    public String readDate() {
        System.out.println(REQUEST_DATE_MESSAGE);
        String date = input.readDate();

        inputValueChecker.checkDateValidation(date);

        return date;
    }
}
