package christmas.controller;

import christmas.service.EventService;
import christmas.view.checker.InputValueChecker;
import christmas.view.input.ConsoleInput;
import christmas.view.input.Input;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;

public class EventConfiguration {
    public EventController eventController() {
        return new EventController(inputView(), outputView(), eventService());
    }

    private InputView inputView() {
        return new InputView(inputValueChecker(), input());
    }

    private InputValueChecker inputValueChecker() {
        return new InputValueChecker();
    }

    private Input input() {
        return new ConsoleInput();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private EventService eventService() {
        return new EventService();
    }
}
