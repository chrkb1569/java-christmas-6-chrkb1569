package christmas.controller;

import christmas.view.input.ConsoleInput;
import christmas.view.input.Input;
import christmas.view.input.InputView;
import christmas.view.output.ConsoleOutputView;
import christmas.view.output.OutputView;

public class EventConfiguration {
    public EventController eventController() {
        return new EventController(inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView(input());
    }

    private Input input() {
        return new ConsoleInput();
    }

    private OutputView outputView() {
        return new ConsoleOutputView();
    }
}
