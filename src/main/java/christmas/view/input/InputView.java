package christmas.view.input;

public class InputView {
    private final String REQUEST_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final Input input;

    public InputView(Input input) {
        this.input = input;
    }

    public String readDate() {
        System.out.println(REQUEST_DATE_MESSAGE);
        String date = input.readDate();

        return date;
    }
}
