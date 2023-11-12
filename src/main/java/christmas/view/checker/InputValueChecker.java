package christmas.view.checker;

import christmas.exception.NotValidInputException;
import christmas.util.GameUtil;
import christmas.util.Menu;

import java.util.List;
import java.util.regex.Pattern;

import static christmas.exception.EventExceptionMessage.*;

public class InputValueChecker {
    private final String REGEXP_NUMBER_PATTERN = "\\d{1,2}";
    private final String REGEXP_ORDER_PATTERN = "^[가-힣]{1,}-[0-9]{1,2}$";
    private final int DATE_CONDITION_MIN = 1;
    private final int DATE_CONDITION_MAX = 31;
    private final int ORDER_CONDITION_MAX = 20;
    private final int MENU_INDEX = 0;
    private final int PRICE_INDEX = 1;

    public void checkDateValidation(String date) throws NotValidInputException {
        checkNumberFormatValidation(date);
        checkRangeValidation(date);
    }

    public void checkOrderValidation(String order) throws NotValidInputException {
        List<String> orders = GameUtil.splitByComma(order);

        for(String value : orders) {
            checkOrderFormatValidation(value);
            checkMenuValidation(value);
        }

        checkMenuDupValidation(orders);
        checkOrderQuantityValidation(orders);
    }

    private void checkNumberFormatValidation(String value) {
        if(!Pattern.matches(REGEXP_NUMBER_PATTERN, value)) {
            throw new NotValidInputException(NOT_VALID_FORMAT.getMessage());
        }
    }

    private void checkRangeValidation(String value) {
        int cvtValue = Integer.parseInt(value);

        if(cvtValue < DATE_CONDITION_MIN || cvtValue > DATE_CONDITION_MAX) {
            throw new NotValidInputException(NOT_VALID_RANGE.getMessage());
        }
    }

    private void checkOrderFormatValidation(String order) {
        if(!Pattern.matches(REGEXP_ORDER_PATTERN, order)) {
            throw new NotValidInputException(NOT_VALID_ORDER.getMessage());
        }
    }

    private void checkMenuValidation(String order) {
        String menuName = GameUtil.splitByHyphen(order).get(MENU_INDEX);

        if(!Menu.findMenu(menuName)) {
            throw new NotValidInputException(NOT_VALID_ORDER.getMessage());
        }
    }

    private void checkMenuDupValidation(List<String> orders) {
        int size = orders.stream().map(GameUtil::splitByHyphen)
                .map(value -> value.get(MENU_INDEX))
                .toList().stream().distinct().toList().size();

        if(orders.size() != size) {
            throw new NotValidInputException(NOT_VALID_ORDER.getMessage());
        }
    }

    private void checkOrderQuantityValidation(List<String> orders) {
        int sum = orders.stream().map(GameUtil::splitByHyphen)
                .mapToInt(value -> Integer.parseInt(value.get(PRICE_INDEX)))
                .sum();

        if(sum > ORDER_CONDITION_MAX) {
            throw new NotValidInputException(NOT_VALID_ORDER.getMessage());
        }
    }
}