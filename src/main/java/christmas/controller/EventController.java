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
    private final InputView inputView;
    private final OutputView outputView;
    private final EventService eventService;

    public EventController(InputView inputView, OutputView outputView, EventService eventService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.eventService = eventService;
    }

    public void doProcess() {
        int date = readDateFromUser();
        List<UserInput> userInputs = readOrderFromUser();

        outputView.printOrderInfo(userInputs);

        EventResult eventResult = eventService.getEventResult(date);
        Benefit benefit = eventService.getTotalBenefit(userInputs, eventResult);

        outputView.printInitialCost(benefit);
        outputView.printFreebieItem(benefit);
        outputView.printBenefits(benefit);
        outputView.printTotalDiscount(benefit);
        outputView.printResultCost(benefit);
        outputView.printBadgeMessage(benefit);
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
}