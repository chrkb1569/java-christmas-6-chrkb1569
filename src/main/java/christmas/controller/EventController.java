package christmas.controller;

import christmas.view.input.InputView;
import christmas.view.output.OutputView;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;

    public EventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void doProcess() {
        outputView.printStartMessage();
        String date = inputView.readDate();
        System.out.println(date);
    }
}
