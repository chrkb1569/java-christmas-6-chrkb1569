package christmas.view.checker;

import christmas.exception.NotValidInputException;

import java.util.regex.Pattern;

import static christmas.exception.EventExceptionMessage.*;

public class InputValueChecker {
    private final String REGEXP_NUMBER_PATTERN = "\\d{1,2}";
    private final int DATE_CONDITION_MIN = 1;
    private final int DATE_CONDITION_MAX = 31;

    public void checkDateValidation(String date) throws NotValidInputException {
        checkNumberFormatValidation(date);
        checkRangeValidation(date);
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
}