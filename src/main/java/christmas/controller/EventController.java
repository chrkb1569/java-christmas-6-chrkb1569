package christmas.controller;

import christmas.dto.UserInput;
import christmas.model.Order;
import christmas.util.GameUtil;
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
        List<UserInput> userInputs = readOrderFromUser();
        Order userOrder = getUserOrder(userInputs);

        outputView.printUsersOrder(userInputs);
    }

    private int readDateFromUser() {
        outputView.printStartMessage();
        return Integer.parseInt(inputView.readDate());
    }

    private List<UserInput> readOrderFromUser() {
        return inputView.readOrder().stream()
                .map(GameUtil::splitByHyphen)
                .map(UserInput::toDto).toList();
    }

    private Order getUserOrder(List<UserInput> inputValues) {
        return new Order(inputValues);
    }
}