package christmas.controller;

import christmas.dto.Benefit;
import christmas.dto.EventResult;
import christmas.dto.UserInput;
import christmas.service.EventService;
import christmas.util.GameUtil;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;

import java.util.List;

public class EventController {
    private final int INIT_DEPTH = 0;
    private final InputView inputView;
    private final OutputView outputView;
    private final EventService eventService;

    public EventController(final InputView inputView, final OutputView outputView, final EventService eventService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.eventService = eventService;
    }

    public void doProcess() {
        int date = readDateFromUser();
        List<UserInput> userInputs = readOrderFromUser();

        printInfo(userInputs, date);
        printEventResult(getBenefit(userInputs, date));
    }

    private int readDateFromUser() {
        outputView.printStartMessage();
        return Integer.parseInt(inputView.readDate(INIT_DEPTH));
    }

    private List<UserInput> readOrderFromUser() {
        return inputView.readOrder(INIT_DEPTH).stream()
                .map(GameUtil::splitByHyphen)
                .map(UserInput::toDto).toList();
    }

    private void printInfo(final List<UserInput> inputValues, final int date) {
        outputView.printDateBenefit(date);
        outputView.printOrderInfo(inputValues);
    }

    private Benefit getBenefit(final List<UserInput> inputValues, final int date) {
        EventResult eventResult = eventService.getEventResult(date);
        return eventService.getTotalBenefit(inputValues, eventResult);
    }

    private void printEventResult(final Benefit benefit) {
        outputView.printInitialCost(benefit);
        outputView.printFreebieItem(benefit);
        outputView.printBenefits(benefit);
        outputView.printTotalDiscount(benefit);
        outputView.printResultCost(benefit);
        outputView.printBadgeMessage(benefit);
    }
}