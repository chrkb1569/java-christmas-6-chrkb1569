package christmas.controller;

import christmas.view.input.InputView;
import christmas.view.output.OutputView;

import java.util.List;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;

    public EventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void doProcess() {
        int date = readDateFromUser();
        List<String> orders = readOrderFromUser();
    }

    private int readDateFromUser() {
        outputView.printStartMessage();
        return Integer.parseInt(inputView.readDate());
    }

    private List<String> readOrderFromUser() {
        return inputView.readOrder();
    }
}
