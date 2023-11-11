package christmas.view.output;

public class ConsoleOutputView implements OutputView {
    private final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    @Override
    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
}